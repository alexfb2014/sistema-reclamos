package com.sistema.reclamos.app.controllers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.sistema.reclamos.app.models.service.ITipoSolicitudService;
import com.sistema.reclamos.app.models.service.IUsuarioService;
import com.sistema.reclamos.app.util.paginator.PageRender;
import com.sistema.reclamos.app.models.service.IClienteService;
import com.sistema.reclamos.app.models.service.IEstadoService;
import com.sistema.reclamos.app.models.service.IMotivoService;

@Controller
@SessionAttributes(value = {"solicitud","cliente"})
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

	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IEstadoService estadoService;
	
	@Autowired
	ITipoSolicitudService tipoSolicitud;

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
		model.put("listaTipos", tipoSolicitud.findAll());
		model.put("notificacion", notificacion);
		model.put("solicitud", solicitud);
		model.put("titulo", "Registro de Solicitud");

		return "solicitud/formSolicitud";
	}

	@GetMapping(value = "/formSolicitud/{id}")
	public String nuevaSol(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(id);
		Solicitud solicitud = new Solicitud();
		solicitud.setCliente(cliente);

		List<String> notificacion = Arrays.asList("telefono", "correo", "direccion");
		model.put("titulo", "Registro de Solicitud");
		model.put("listaProductos", productoService.findAll());
		model.put("listaMotivos", motivoService.findAll());
		model.put("listaTipos", tipoSolicitud.findAll());
		model.put("notificacion", notificacion);
		model.put("solicitud", solicitud);

		return "solicitud/formSolicitud1";
	}


	@PostMapping("/formSolicitud")
	public String Grabar(@Valid Solicitud solicitud, BindingResult result, Map<String, Object> model,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			List<String> notificacion = Arrays.asList("telefono", "correo", "direccion");
			model.put("titulo", "Registro de Solicitud");
			model.put("listaProductos", productoService.findAll());
			model.put("listaMotivos", motivoService.findAll());
			model.put("listaTipos", tipoSolicitud.findAll());
			model.put("notificacion", notificacion);
			return "solicitud/formSolicitud";
		}

		if (solicitud.id == null) {

			solicitud.setEstado(estadoService.findByDescripcion("registrado"));
			solicitud.setEstadoEvalua(estadoService.findByDescripcion("registrado"));

		}

		solicitudService.save(solicitud);
		status.setComplete();
		flash.addFlashAttribute("success", "Solicitud Registrada satisfactoriamente");
		return "redirect:misSolicitudes";
	}

	@PostMapping("/formSolicitud1")
	public String Grabar1(@Valid Solicitud solicitud, BindingResult result, Map<String, Object> model,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			List<String> notificacion = Arrays.asList("telefono", "correo", "direccion");
			model.put("titulo", "Registro de Solicitud");
			model.put("listaProductos", productoService.findAll());
			model.put("listaMotivos", motivoService.findAll());
			model.put("listaTipos", tipoSolicitud.findAll());
			model.put("notificacion", notificacion);
			return "solicitud/formSolicitud";
		}

		if (solicitud.id == null) {

			solicitud.setEstado(estadoService.findByDescripcion("registrado"));
			solicitud.setEstadoEvalua(estadoService.findByDescripcion("registrado"));

		}

		solicitudService.save(solicitud);
		status.setComplete();
		flash.addFlashAttribute("success", "Solicitud Registrada satisfactoriamente");
		return "redirect:BuscarCliente";
	}
	
	@GetMapping(value = "/BuscarCliente")
	public String BuscarCliente(Map<String, Object> model, RedirectAttributes flash) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);

		model.put("titulo", "Buscar Cliente");

		return "solicitud/buscarCliente";
	}
	
	
	@PostMapping(value = "/BuscarCliente")
	public String MostrarCliente(@Valid Cliente cliente, BindingResult result,
			Map<String, Object> model, RedirectAttributes flash, SessionStatus status) {

		
		
		
		if (cliente.getNumdoc().isBlank() || cliente.getNumdoc().isEmpty()) {
			flash.addFlashAttribute("warning", "Ingresar numero de documento");
			model.put("cliente", cliente);
			model.put("titulo", "Buscar Cliente");
			return "redirect:BuscarCliente";
		}
		
		
		if (clienteService.findByNumdoc(cliente.getNumdoc()) == null) {
			flash.addFlashAttribute("warning", "Documento no existe");
			model.put("cliente", cliente);
			model.put("titulo", "Buscar Cliente");
			return "redirect:BuscarCliente";
		}
		
		Cliente cliente1 = clienteService.findByNumdoc(cliente.getNumdoc());
		
		
		model.put("cliente", cliente1);
		model.put("titulo", "Buscar Cliente");

		return "solicitud/buscarCliente";
	}
	
	@GetMapping(value = { "/listarBandeja" })
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model, Authentication aut) {

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Solicitud> solicitudes = null;
		if (hasRole("ROLE_AREA")) {
			solicitudes = solicitudService.ListarEnviadas(pageRequest);
		}else
			if (hasRole("ROLE_ATENCION")) {
				
			solicitudes = solicitudService.ListarRegistradasYDevueltas(pageRequest);
			} else {
				solicitudes = solicitudService.findAll(pageRequest);
			}
		String indicador="1";
		if (solicitudes.isEmpty()) {
			indicador = "0";
		}
		log.info("Se obtuvieron:" + solicitudes.getSize() + " solicitudes del pageRequest");

		PageRender<Solicitud> pageRender = new PageRender<>("/solicitud/bandeja", solicitudes);

		model.addAttribute("solicitudes", solicitudes);
		model.addAttribute("page", pageRender);
		model.addAttribute("indicador", indicador);
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

	@GetMapping(value = "/mostrarParaAtencion/{id}")
	public String verAtencion(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Solicitud solicitud = solicitudService.findOne(id);

		model.put("cliente", solicitud.getCliente());
		model.put("solicitud", solicitud);
		model.put("titulo", "Datos de Solicitud");

		return "solicitud/mostrarSolicitudParaAtencion";
	}

	@GetMapping(value = "/mostrarParaArea/{id}")
	public String verArea(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Solicitud solicitud = solicitudService.findOne(id);

		model.put("cliente", solicitud.getCliente());
		model.put("solicitud", solicitud);
		model.put("titulo", "Datos de Solicitud");

		return "solicitud/mostrarSolicitudParaArea";
	}
	
	@GetMapping(value = "/mostrarParaCliente/{id}")
	public String VistaSolicitud(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Solicitud solicitud = solicitudService.findOne(id);

		model.put("cliente", solicitud.getCliente());
		model.put("solicitud", solicitud);
		model.put("titulo", "Datos de Solicitud");

		return "solicitud/mostrarSolicitudParaCliente";
	}
	
	@PostMapping("/finalizar")
	public String accion(@Valid Solicitud solicitud, BindingResult result, Map<String, Object> model,
			RedirectAttributes flash, SessionStatus status) {

		String mensaje = "";

		if (result.hasErrors()) {
			model.put("cliente", solicitud.getCliente());
			model.put("solicitud", solicitud);
			model.put("titulo", "Datos de Solicitud");

			return "solicitud/mostrarSolicitudParaAtencion";
		}

		if (solicitud.detalle.respuesta == null || solicitud.detalle.respuesta == ""
				|| solicitud.detalle.respuesta.length() <= 0) {

			flash.addFlashAttribute("error", "Ingresar respuesta para finalizar la solicitud");
			return "redirect:mostrarParaAtencion/"+solicitud.id;
		} else {

			if (solicitud.detalle.respuesta != null || solicitud.detalle.respuesta.length() > 0) {
				solicitud.setEstado(estadoService.findByDescripcion("finalizado"));
				solicitud.setEstadoEvalua(estadoService.findByDescripcion("finalizado"));
				mensaje = "Solicitud finalizada correctamente";
			} else {
				log.info("No se encontro flujo de decision");
			}

		}
		solicitud.fechaRespuesta = new Date();
		solicitudService.save(solicitud);
		status.setComplete();
		flash.addFlashAttribute("success", mensaje);
		return "redirect:listarBandeja";
	}

	@PostMapping("/opinionArea")
	public String responder(@Valid Solicitud solicitud, BindingResult result, Map<String, Object> model,
			RedirectAttributes flash, SessionStatus status) {

		String mensaje = "";

		if (result.hasErrors()) {
			model.put("cliente", solicitud.getCliente());
			model.put("solicitud", solicitud);
			model.put("titulo", "Datos de Solicitud");

			return "solicitud/mostrar";
		}

		
			if (solicitud.detalle.respuesta != null || solicitud.detalle.opinionArea.length() > 0) {
				
				solicitud.setEstadoEvalua(estadoService.findByDescripcion("devuelto"));
				mensaje = "Solicitud respondida correctamente";
			}

		solicitudService.save(solicitud);
		status.setComplete();
		flash.addFlashAttribute("success", mensaje);
		return "redirect:listarBandeja";
	}

	@GetMapping(value = "/enviar/{id}")
	public String enviar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash,
			@RequestParam(name = "page", defaultValue = "0") int page) {

		Solicitud solicitud = solicitudService.findOne(id);

		if (solicitud != null) {
			solicitud.setEstado(estadoService.findByDescripcion("evaluacion"));
			solicitud.setEstadoEvalua(estadoService.findByDescripcion("enviado"));
		}

		solicitudService.save(solicitud);

		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Solicitud> solicitudes = null;
		if (hasRole("ROLE_AREA")) {
			solicitudes = solicitudService.ListarEnviadas(pageRequest);
		}else
			if (hasRole("ROLE_ATENCION")) {
				
			solicitudes = solicitudService.ListarRegistradasYDevueltas(pageRequest);
			} else {
				solicitudes = solicitudService.findAll(pageRequest);
			}
		PageRender<Solicitud> pageRender = new PageRender<>("/solicitud/bandeja", solicitudes);
		
		String indicador="1";
		if (solicitudes.isEmpty()) {
			indicador = "0";
		}	
		
		model.put("solicitudes", solicitudes);
		model.put("page", pageRender);
		model.put("indicador", indicador);
		flash.addFlashAttribute("success", "Solicitud enviada correctamente");
		return "solicitud/bandeja";
	}

	private boolean hasRole(String role) {

		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return false;
		}

		Authentication auth = context.getAuthentication();

		if (auth == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		for (GrantedAuthority authority : authorities) {

			if (role.equals(authority.getAuthority())) {
				log.info("Hola ".concat(auth.getName()).concat(" tu rol es: ".concat(authority.getAuthority())));
				return true;
			}

		}
		return false;

	}

	@SuppressWarnings("unused")
	private boolean hasRole(String role, String role1) {

		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return false;
		}

		Authentication auth = context.getAuthentication();

		if (auth == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		for (GrantedAuthority authority : authorities) {

			if (role.equals(authority.getAuthority()) || role1.equals(authority.getAuthority())) {
				log.info("Hola ".concat(auth.getName()).concat(" tu rol es: ".concat(authority.getAuthority())));
				return true;
			}

		}
		return false;

	}
	
}
