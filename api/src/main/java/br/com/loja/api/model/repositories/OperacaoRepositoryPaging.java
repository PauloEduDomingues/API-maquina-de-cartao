package br.com.loja.api.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.api.model.entities.Operacao;

@Repository
public interface OperacaoRepositoryPaging extends PagingAndSortingRepository<Operacao, Long>{

}
