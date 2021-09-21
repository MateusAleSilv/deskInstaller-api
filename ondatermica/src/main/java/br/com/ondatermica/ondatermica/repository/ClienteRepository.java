package br.com.ondatermica.ondatermica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ondatermica.ondatermica.model.Cliente;
import br.com.ondatermica.ondatermica.model.Produtos;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	//Consultar por ID
	Optional<List<Cliente>> findByIdClienteContainingOrderByIdCliente(String idCliente);
	
	//Consulta por CPF
	Optional<Produtos> findById(int codigo);
}
