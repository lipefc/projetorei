package br.com.iblue.projetorei.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="correntista")
@SequenceGenerator(name="seq_correntista", sequenceName="seq_correntista", initialValue = 1, allocationSize = 1)
public class Correntista implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(generator="seq_correntista")
	@Column(name="idcorrentista")
	@JsonProperty("idcorrentista")
	private Long idCorrentista;
	
	@Column(name="nome", length = 50)
	@JsonProperty("nome")
	private String nome;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="dataconta")
	private java.util.Date dataConta;
	
	@Column(name="saldo")
	@JsonProperty("saldo")
	private Double saldo=0.;

	@OneToMany(mappedBy = "correntista", cascade = {CascadeType.ALL})
	private Set<Movimentacao> movimentacoes = new HashSet<Movimentacao>();
	
	public Correntista() {
		// TODO Auto-generated constructor stub
	}

	public Correntista(Long idCorrentista, String nome, Date dataConta, Double saldo) {
		super();
		this.idCorrentista = idCorrentista;
		this.nome = nome;
		this.dataConta = dataConta;
		this.saldo = saldo;
	}

	public Correntista(Long idCorrentista, String nome, Date dataConta, Double saldo, Set<Movimentacao> movimentacoes) {
		super();
		this.idCorrentista = idCorrentista;
		this.nome = nome;
		this.dataConta = dataConta;
		this.saldo = saldo;
		this.movimentacoes = movimentacoes;
	}

	@Override
	public String toString() {
		return "Correntista [idCorrentista=" + idCorrentista + ", nome=" + nome + ", dataConta=" + dataConta
				+ ", saldo=" + saldo + ", movimentacoes=" + movimentacoes + "]";
	}

	public Long getIdCorrentista() {
		return idCorrentista;
	}

	public void setIdCorrentista(Long idCorrentista) {
		this.idCorrentista = idCorrentista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public java.util.Date getDataConta() {
		return dataConta;
	}

	public void setDataConta(java.util.Date dataConta) {
		this.dataConta = dataConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Set<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(Set<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void adicionarECalcular(Movimentacao m) {
		if(m.getTipo().equals("DEOISITO")) {
			this.saldo += m.getValor();
		}else if (m.getTipo().equals("RETIRADA")){
			this.saldo-= m.getValor();
		}else {
			throw new IllegalArgumentException("Tipo de processo não definido ...");
		}
		m.setCorrentista(this);
		this.movimentacoes.add(m);
	}
}