package br.com.ondatermica.ondatermica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ondatermica.ondatermica.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	//Consulta por ID
	Optional<Cliente> findById(int id);
	
	//Consultar por CPF
	Optional<List<Cliente>> findByCpfContainingOrderByCpf(String cpf);
	
	//Consultar por email
	Optional<List<Cliente>> findByEmailContainingOrderByEmail(String email);

}
