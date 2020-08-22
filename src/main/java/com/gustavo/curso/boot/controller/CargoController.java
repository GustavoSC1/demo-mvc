package com.gustavo.curso.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gustavo.curso.boot.domain.Cargo;
import com.gustavo.curso.boot.service.CargoService;
import com.gustavo.curso.boot.service.DepartamentoService;
import com.gustavo.curso.boot.domain.Departamento;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	// No Thymeleaf não é necessário usar o @ModelAttribute antes de Cargo cargo, mas no JSP precisa.
	public String salvar(Cargo cargo, RedirectAttributes attr) {
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	//Quando a anotação @ModelAttribute é usada no nível do método, ela indica que o propósito desse método é adicionar 
	//um ou mais atributos do modelo. Os métodos @ModelAttribute são chamados antes dos métodos do controlador 
	//anotados com @RequestMapping serem chamados.
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos(){
		return departamentoService.buscarTodos();
	}

}
