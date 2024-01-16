package br.com.loja.api.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.api.model.entities.Operacao;
import br.com.loja.api.model.repositories.OperacaoRepository;
import br.com.loja.api.model.repositories.OperacaoRepositoryPaging;

@RestController
@CrossOrigin("*")
@RequestMapping("/operacoes")
public class OperacaoController {
	
	@Autowired
	private OperacaoRepository operacaoRepository;
	@Autowired
	private OperacaoRepositoryPaging operacaoRepositoryPaging;

	@GetMapping
	public Iterable<Operacao> listar(){
		return operacaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Operacao> listar(@PathVariable long id){
		return operacaoRepository.findById(id);
	}
	
	@GetMapping("pagina/{numeroPagina}")
	public Iterable<Operacao> listarPaginada(@PathVariable int numeroPagina){
		Pageable page = PageRequest.of(numeroPagina, 10);
		return operacaoRepositoryPaging.findAll(page);
	}
	
	@PostMapping
	public Operacao inserir(@RequestBody Operacao op) {
		op.setData(LocalDateTime.now());
		return operacaoRepository.save(op);
	}
	
	@PutMapping
	public Operacao atualizar(@RequestBody Operacao op) {
		return operacaoRepository.save(op);
	}	
	
	@DeleteMapping("/{id}")
	public void deletarId(@PathVariable long id) {
		operacaoRepository.deleteById(id);
	}
	
}
