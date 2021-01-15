package br.com.iblue.projetorei.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.iblue.projetorei.entity.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Long>{
}