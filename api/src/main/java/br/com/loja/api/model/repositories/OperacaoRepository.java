package br.com.loja.api.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.api.model.entities.Operacao;

@Repository
public interface OperacaoRepository extends CrudRepository<Operacao, Long>{

}
