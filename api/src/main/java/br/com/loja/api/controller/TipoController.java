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

import br.com.loja.api.model.entities.Tipo;
import br.com.loja.api.model.repositories.TipoRepository;

@RestController
@RequestMapping("/tipos")
public class TipoController {
	
	@Autowired
	public TipoRepository tipoRepository;
	
	
	@GetMapping
	public Iterable<Tipo> listar(){
		return tipoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Tipo> tipoId(@PathVariable long id) {
		return tipoRepository.findById(id);
	}
	@PostMapping
	public Tipo inserir(@RequestBody Tipo tp) {
		return tipoRepository.save(tp);
	}
	
	@PutMapping
	public Tipo atualizar(@RequestBody Tipo tp) {
		return tipoRepository.save(tp);
	}	
	
	@DeleteMapping("/{id}")
	public void deletarId(@PathVariable long id) {
		tipoRepository.deleteById(id);
	}
}
