package br.com.loja.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.api.model.entities.Metodo;
import br.com.loja.api.model.repositories.MetodoRepository;

@RestController
@RequestMapping("/metodos")
public class MetodoController {
	
	@Autowired
	public MetodoRepository metodoRepository;
	
	@GetMapping("/todos")
	public Iterable<Metodo> listar(){
		return metodoRepository.findAll();
	}
	
	@GetMapping("/consulta")
	public Optional<Metodo> metodo(@RequestParam long id) {
		return metodoRepository.findById(id);
	}
}
