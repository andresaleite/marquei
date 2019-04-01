package br.com.marquei.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marquei.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Optional<Pessoa> save(Optional<Pessoa> pessoaSalva);
	public Page<Pessoa> findByNomeContaining(String nome, Pageable pageable);
	

}
