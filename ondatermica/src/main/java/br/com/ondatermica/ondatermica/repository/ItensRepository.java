package br.com.ondatermica.ondatermica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ondatermica.ondatermica.model.Itens;

@Repository
public interface ItensRepository extends JpaRepository<Itens, Long>{
	
	//Consulta por ID
	Optional<Itens> findById (int id);
	
	//Consulta por numero
	Optional<List<Itens>> findByItemnumeroContainingOrderByItemnumero (int itemnumero);
}
