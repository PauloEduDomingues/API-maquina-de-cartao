package br.com.loja.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.api.model.entities.Bandeiras;
import br.com.loja.api.model.repositories.BandeirasRepository;

@RestController
@RequestMapping("/bandeiras")
public class BandeirasController {

		@Autowired
		public BandeirasRepository bandeirasRepository;
		
		@GetMapping("/todos")
		public Iterable<Bandeiras> listar(){
			return bandeirasRepository.findAll();
		}
		
		@GetMapping("/consulta")
		public Optional<Bandeiras> listar(@RequestParam long id){
			return bandeirasRepository.findById(id);
		}
}
