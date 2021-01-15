package br.com.iblue.projetorei.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="movimentacao")
@SequenceGenerator(name="seq_movimentacao", sequenceName="seq_movimentacao", initialValue = 1, allocationSize = 1)
public class Movimentacao implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(generator="seq_movimentacao")
	@Column(name="idmovimentacao")
	@JsonProperty("idmovimentacao")
	private Long idMovimentacao;
	
	@Column(name="tipo", length = 50)
	@JsonProperty("tipo")
	private String tipo;
	
	@Column(name="valor")
	@JsonProperty("valor")
	private Double valor;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@JsonProperty("datahora")
	@Column(name="datahora")
	private java.util.Date dataHora;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="id_correntista", referencedColumnName="idCorrentista")
	private Correntista correntista;
	
	{
		this.valor=0.;
		this.dataHora= new java.util.Date();
	}
	
	public Movimentacao() {
	}

	public Movimentacao(Long idMovimentacao, String tipo, Double valor, Date dataHora) {
		super();
		this.idMovimentacao = idMovimentacao;
		this.tipo = tipo;
		this.valor = valor;
		this.dataHora = dataHora;
	}

	public Movimentacao(Long idMovimentacao, String tipo, Double valor, Date dataHora, Correntista correntista) {
		super();
		this.idMovimentacao = idMovimentacao;
		this.tipo = tipo;
		this.valor = valor;
		this.dataHora = dataHora;
		this.correntista = correntista;
	}

	@Override
	public String toString() {
		return "Movimentacao [idMovimentacao=" + idMovimentacao + ", tipo=" + tipo + ", valor=" + valor + ", dataHora="
				+ dataHora + ", correntista=" + correntista + "]";
	}

	public Long getIdMovimentacao() {
		return idMovimentacao;
	}

	public void setIdMovimentacao(Long idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public java.util.Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(java.util.Date dataHora) {
		this.dataHora = dataHora;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}