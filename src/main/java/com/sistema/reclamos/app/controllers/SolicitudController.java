package com.sistema.reclamos.app.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.reclamos.app.models.entity.Cliente;
import com.sistema.reclamos.app.models.entity.Solicitud;
import com.sistema.reclamos.app.models.entity.Usuario;
import com.sistema.reclamos.app.models.service.IProductoService;
import com.sistema.reclamos.app.models.service.ISolicitudService;
import com.sistema.reclamos.app.models.service.IUsuarioService;
import com.sistema.reclamos.app.util.paginator.PageRender;
import com.sistema.reclamos.app.models.service.IMotivoService;

@Controller
@SessionAttributes("solicitud")
@RequestMapping("/solicitud")
public class SolicitudController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	Usuario usuario;

	@Autowired
	IProductoService productoService;

	@Autowired
	IMotivoService motivoService;

	@Autowired
	ISolicitudService solicitudService;

	@Autowired
	IUsuarioService usuarioService;

	@GetMapping("/formSolicitud")
	public String nuevo(Map<String, Object> model, Authentication aut) {

		Usuario usuario = usuarioService.findByUsername(aut.getName());

		if (usuario == null) {
			log.info("No se obtubo el objeto Usuario");
		}

		Cliente cliente = usuario.getCliente();

		Solicitud solicitud = new Solicitud();
		List<String> notificacion = Arrays.asList("telefono", "correo", "direccion");
		
		solicitud.setCliente(cliente);
		model.put("listaProductos", productoService.findAll());
		model.put("listaMotivos", motivoService.findAll());
		model.put("notificacion", notificacion);
		model.put("solicitud", solicitud);
		model.put("titulo", "Registro de Solicitud");

		return "solicitud/formSolicitud";
	}

	@PostMapping("/formSolicitud")
	public String Grabar(@Valid Solicitud solicitud, BindingResult result,Map<String, Object> model,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			List<String> notificacion = Arrays.asList("telefono", "correo", "direccion");
			model.put("titulo", "Registro de Solicitud");
			model.put("listaProductos", productoService.findAll());
			model.put("listaMotivos", motivoService.findAll());
			model.put("notificacion", notificacion);
			return "solicitud/formSolicitud";
		}

		solicitudService.save(solicitud);
		status.setComplete();
		flash.addFlashAttribute("success", "Solicitud Registrada con satisfactoriamente");
		return "redirect:misSolicitudes";
	}
	
	
	
	@GetMapping(value = { "/listarBandeja" })
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Solicitud> solicitudes = solicitudService.findAll(pageRequest);

		PageRender<Solicitud> pageRender = new PageRender<>("/solicitud/bandeja", solicitudes);

		model.addAttribute("clientes", solicitudes);
		model.addAttribute("page", pageRender);

		return "solicitud/bandeja";

	}

	@GetMapping(value = { "/misSolicitudes" })
	public String MisSolicitudes(Model model, Authentication aut) {

		
		Usuario usuario = usuarioService.findByUsername(aut.getName());
		if (usuario == null) {
			log.info("No se obtubo el objeto Usuario");
		}
		Cliente cliente = usuario.getCliente();


		model.addAttribute("solicitudes", cliente.getSolicitudes());
		
		return "solicitud/misSolicitudes";

	}
	
	
	
}
