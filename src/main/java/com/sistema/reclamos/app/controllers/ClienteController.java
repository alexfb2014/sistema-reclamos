package com.sistema.reclamos.app.controllers;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.sistema.reclamos.app.models.service.IClienteService;
import com.sistema.reclamos.app.models.service.ITipoDocumento;
import com.sistema.reclamos.app.util.paginator.PageRender;



@Controller
@SessionAttributes("cliente")
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	public IClienteService clienteService;
	
	@Autowired
	public ITipoDocumento tipoDocumentoService;
	
	

	@GetMapping("/form")
	public String crear(Model model, SessionStatus status, HttpServletRequest request) {

		 Map md = model.asMap();
		if (!md.isEmpty()) {
			model.addAttribute("titulo", "Formulario del cliente");
			model.addAttribute("tipoDocumentos", tipoDocumentoService.findAll());
			return "clientes/form";
		}
		 
		
		Cliente cliente = new Cliente();
		model.addAttribute("titulo", "Formulario del cliente");
		model.addAttribute("tipoDocumentos", tipoDocumentoService.findAll());
		model.addAttribute("cliente", cliente);

		return "clientes/form";
	}
	

	
	@PostMapping("/form")
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model,
							RedirectAttributes flash, SessionStatus status) {

		if (cliente.getTipoDocumento().getLongitud() != cliente.getNumdoc().length()) {
			
			flash.addFlashAttribute("warning", "El tipo de documento seleccionado: "+cliente.getTipoDocumento().getDescripcion()
					+" debe tener "+ cliente.getTipoDocumento().getLongitud()+" caracteres");
		
			flash.addFlashAttribute("titulo", "Formulario del cliente");
			flash.addFlashAttribute("tipoDocumentos", tipoDocumentoService.findAll());
			flash.addFlashAttribute("cliente", cliente);
			return "redirect:form";
			
		}
		
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del cliente");
			return "clientes/form";
		}

		

		String mensajeFlash = (cliente.getId() != null) ? "Cliente Editado con exito" : "Cliente Creado con Exito";

		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteService.findOne(id);
			if (cliente == null) {
				flash.addFlashAttribute("error", "El cliente no existe en la BDD");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El Id del cliente no puede ser cero");
			return "redirect:/listar";
		}
		model.put("titulo", "Editar cliente");
		model.put("tipoDocumentos", tipoDocumentoService.findAll());
		model.put("cliente", cliente);
		return "clientes/form";
	}
	
	
	@GetMapping(value = {"/listar"})
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, 
			Model model) {
		
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Cliente> clientes = clienteService.findAll(pageRequest);

		PageRender<Cliente> pageRender = new PageRender<>("/clientes/listar", clientes);

		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);

		return "clientes/listar";

	}
	
	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(id);

		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la BDD");
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Cliente: " + cliente.getNombre() +" " + cliente.getApellido());
		return "clientes/ver";

	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		if (id > 0) {
			
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente Eliminado con Exito");

		}
		return "redirect:/clientes/listar";

	}
	
}
