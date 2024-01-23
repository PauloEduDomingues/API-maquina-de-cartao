package br.com.loja.api.model.treatments;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import br.com.loja.api.model.entities.Bandeiras;
import br.com.loja.api.model.entities.Operacao;
import br.com.loja.api.model.repositories.OperacaoRepository;
import br.com.loja.api.model.repositories.OperacaoRepositoryPaging;

@Service
public class OperacaoTreatment {

	@Autowired
	private OperacaoRepository operacaoRepository;
	@Autowired
	private OperacaoRepositoryPaging operacaoRepositoryPaging;

	public Operacao inserirOperacao(Operacao op) {
		if (verificarPreenchimento(op)) {
			// Ver se é um pix e se for atribuir a bandeira PIX
			if (op.getMetodo().getId() == 3) {
				Bandeiras bnd = new Bandeiras(5, "Pix");
				op.setBandeiras(bnd);
			}
			// Definindo a data
			op.setData(LocalDateTime.now());
			return operacaoRepository.save(op);
		}else {
			return op;
		}
	}
	
	public Iterable<Operacao> consultaPaginada(int numeroPagina){
		Pageable page = PageRequest.of(numeroPagina, 10, Sort.by(Sort.Direction.DESC, "id"));
		return operacaoRepositoryPaging.findAll(page);
	}
	
	public Optional<Operacao> consultaPorId(long id) {
		return operacaoRepository.findById(id);
	}
	
	public Page<Operacao> consultaPaginadaPorData(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime datai, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataf, Pageable pageable, int numeroPagina){
		System.out.println("testando");
		pageable = PageRequest.of(numeroPagina, 10, Sort.by(Sort.Direction.DESC, "id"));
		return operacaoRepositoryPaging.searchByDate(datai, dataf, pageable);
	}
	
	public void deletarOperacao(long id) {
		operacaoRepository.deleteById(id);
	}
	
	private boolean verificarPreenchimento(Operacao op) {
		//Verifica se o ID do Tipo é valido
		if(op.getTipo().getId()==1 || op.getTipo().getId()==2) {
			//Verifica se o ID do Metodo é valido
			if(op.getMetodo().getId()==1 || op.getMetodo().getId()==2) {
				//Verifica se o ID da Bandeira é valido
				if(op.getBandeiras().getId()==1 || op.getBandeiras().getId()==2 || op.getBandeiras().getId()==3 || op.getBandeiras().getId()==4) {
					return true;
				}
			}else if(op.getMetodo().getId()==3) {
				return true;
			}
		}
		return false;
	}
}
