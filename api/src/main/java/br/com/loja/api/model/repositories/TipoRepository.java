package br.com.loja.api.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.api.model.entities.Tipo;

@Repository
public interface TipoRepository extends CrudRepository<Tipo, Long>{

}
