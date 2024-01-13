package br.com.loja.api.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.api.model.entities.Metodo;

@Repository
public interface MetodoRepository extends CrudRepository<Metodo, Long>{

}
