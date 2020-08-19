package com.sistema.reclamos.app.controllers;



import java.security.Principal;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.reclamos.app.models.entity.Cliente;
import com.sistema.reclamos.app.models.entity.Usuario;
import com.sistema.reclamos.app.models.service.IClienteService;
import com.sistema.reclamos.app.models.service.IUsuarioService;

@Controller
public class LoginController {
	@Autowired
	public IUsuarioService usuarioService;
	@Autowired
	public IClienteService clienteService;

	@GetMapping(value = {"/login"})
	public String login(@RequestParam(value ="error", required = false) String error,
			Model model, Principal principal, RedirectAttributes flash) {
		
		if (principal != null) {
			flash.addFlashAttribute("info", "Ya ha iniciado sesion anteriormente");
			return "redirect:/";
	
		}
		
		if (error != null) {
			model.addAttribute("error", "Error: Contraseña o usuario incorrecto");
		}
		
		return "login";
	}
	@GetMapping("/formularioRegistro")
	public String crearUsuario(Map<String, Object> model) {
		
		Usuario usuario = new Usuario();
		model.put("titulo", "Formulario del Usuario");
		model.put("usuario", usuario);	
		return "formularioRegistro";
		
		}							   										
	@PostMapping("/formularioRegistro")
	public String guardarUsuario(@Valid Usuario usuario, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {
		 
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del usuario");
			return "clientes/form";
		}
		String mensajeFlash = (usuario.getCliente().getId() != null) ? "Cliente Editado con exito" : "Cliente Creado con Exito";
		clienteService.save(usuario.getCliente());
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		String mensajeFlash1 = (usuario.getId() != null) ? "Usuario Editado con exito" : "Usuario Creado con Exito";
		usuarioService.save(usuario);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash1);
	
		return "login";
	}
	
	
}
