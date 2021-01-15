package br.com.iblue.projetorei.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.iblue.projetorei.entity.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{
}