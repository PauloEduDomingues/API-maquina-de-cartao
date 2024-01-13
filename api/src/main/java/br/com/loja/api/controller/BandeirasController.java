package br.com.loja.api.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.api.model.entities.Bandeiras;
import br.com.loja.api.model.entities.Operacao;
import br.com.loja.api.model.repositories.BandeirasRepository;

@RestController
@RequestMapping("/bandeiras")
public class BandeirasController {

		@Autowired
		public BandeirasRepository bandeirasRepository;
		
		@GetMapping
		public Iterable<Bandeiras> listar(){
			return bandeirasRepository.findAll();
		}
		
		@GetMapping("/{id}")
		public Optional<Bandeiras> listar(@PathVariable long id){
			return bandeirasRepository.findById(id);
		}
		
		@PostMapping
		public Bandeiras inserir(@RequestBody Bandeiras bd) {
			return bandeirasRepository.save(bd);
		}
		
		@PutMapping
		public Bandeiras atualizar(@RequestBody Bandeiras bd) {
			return bandeirasRepository.save(bd);
		}	
		
		@DeleteMapping("/{id}")
		public void deletarId(@PathVariable long id) {
			bandeirasRepository.deleteById(id);
		}
}
