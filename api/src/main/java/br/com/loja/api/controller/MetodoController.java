package br.com.loja.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.api.model.entities.Metodo;
import br.com.loja.api.model.repositories.MetodoRepository;

@RestController
@RequestMapping("/metodos")
public class MetodoController {
	
	@Autowired
	public MetodoRepository metodoRepository;
	
	@GetMapping
	public Iterable<Metodo> listar(){
		return metodoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Metodo> metodo(@PathVariable long id) {
		return metodoRepository.findById(id);
	}
	
	@PostMapping
	public Metodo inserir(@RequestBody Metodo mt) {
		return metodoRepository.save(mt);
	}
	
	@PutMapping
	public Metodo atualizar(@RequestBody Metodo mt) {
		return metodoRepository.save(mt);
	}	
	
	@DeleteMapping("/{id}")
	public void deletarId(@PathVariable long id) {
		metodoRepository.deleteById(id);
	}
}
