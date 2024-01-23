package br.com.loja.api.model.repositories;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.loja.api.model.entities.Operacao;

@Repository
public interface OperacaoRepositoryPaging extends PagingAndSortingRepository<Operacao, Long>{

	@Query("SELECT o FROM Operacao o WHERE o.data BETWEEN :datai AND :dataf")
    Page<Operacao> searchByDate(
            @Param("datai") LocalDateTime datai,
            @Param("dataf") LocalDateTime dataf,
            Pageable pageable);
	
}
