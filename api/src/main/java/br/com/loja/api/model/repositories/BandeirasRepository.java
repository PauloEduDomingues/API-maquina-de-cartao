package br.com.loja.api.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.api.model.entities.Bandeiras;

@Repository
public interface BandeirasRepository extends CrudRepository<Bandeiras, Long>{

}
