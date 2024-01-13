package br.com.loja.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.api.model.entities.Tipo;
import br.com.loja.api.model.repositories.TipoRepository;

@RestController
@RequestMapping("/tipos")
public class TipoController {
	
	@Autowired
	public TipoRepository tipoRepository;
	
	
	@GetMapping("/todos")
	public Iterable<Tipo> listar(){
		return tipoRepository.findAll();
	}
	
	@GetMapping("/consulta")
	public Optional<Tipo> tipoId(@RequestParam long id) {
		return tipoRepository.findById(id);
	}
}
