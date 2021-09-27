package br.com.ondatermica.ondatermica.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ondatermica.ondatermica.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
	
	//Consulta por ID
	Optional<Compra> findById(int id);
	
	//Consulta por Data de Compra
	Optional<List<Compra>> findByDatacompraContainingOrderByDatacompra(Date datacompra);
}
