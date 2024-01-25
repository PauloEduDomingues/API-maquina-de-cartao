package br.com.loja.api.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.loja.api.model.entities.Operacao;
import br.com.loja.api.model.integration.ApiIntegrada;
import br.com.loja.api.model.integration.Fee;
import br.com.loja.api.model.treatments.OperacaoTreatment;

@RestController
@CrossOrigin("*")
@RequestMapping("/operacoes")
public class OperacaoController {
	
	@Autowired
	private OperacaoTreatment operacaoTreatment;
	
	@GetMapping("/{id}")
	public Optional<Operacao> listar(@PathVariable long id){
		return operacaoTreatment.consultaPorId(id);
	}
	
	@GetMapping("pagina/{numeroPagina}")
	public Iterable<Operacao> listarPaginada(@PathVariable int numeroPagina){
		return operacaoTreatment.consultaPaginada(numeroPagina);
	}
	
	@GetMapping("/datas/{numeroPagina}")
	public Page<Operacao> listarPagina(@RequestParam LocalDateTime datai, @RequestParam LocalDateTime dataf, Pageable pageable, @PathVariable int numeroPagina){
		return operacaoTreatment.consultaPaginadaPorData(datai, dataf, pageable, numeroPagina);
	}
	
	@PostMapping
	public Operacao inserir(@RequestBody Operacao op) {
		return operacaoTreatment.inserirOperacao(op);
	}
	
	@PutMapping
	public Operacao atualizar(@RequestBody Operacao op) {
		return operacaoTreatment.inserirOperacao(op);
	}	
	
	@DeleteMapping("/{id}")
	public void deletarId(@PathVariable long id) {
		operacaoTreatment.deletarOperacao(id);
	}
	
	@GetMapping("/teste")
	public String teste() {
		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "https://api.infinitepay.io/v2/products/pricings";
		ResponseEntity<ApiIntegrada> responseEntity = restTemplate.getForEntity(apiUrl, ApiIntegrada.class);
		 
		return responseEntity.getBody().getData().getPricings().getMpos().getD1Antecipation().getMastercard().getFees().get(0).getPercentage();
	}
	
}
