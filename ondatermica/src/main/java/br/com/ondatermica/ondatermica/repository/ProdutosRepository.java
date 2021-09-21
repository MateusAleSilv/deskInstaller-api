package br.com.ondatermica.ondatermica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ondatermica.ondatermica.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
	
	//Consutla por descricao
	Optional<List<Produtos>> findByDescricaoContainingOrderByDescricao(String descricao);
	
	//Consulta por codigo
	Optional<Produtos> findById(int codigo);
	
}