package com.learn.api.basic.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "descricao", nullable = false, length = 50)
	private String descricao;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idFormaPagamento", referencedColumnName = "id")
	private FormasPagamento formaPagamento;
	
	@Column(name = "valor", nullable = false, precision = 2)
	private Double valor;
	
	@Column(name = "moeda", nullable = false)
	private String moeda;
	
	@Column(name = "data", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;

	public Pagamento() {
		super();
	}
	
	public Pagamento(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FormasPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormasPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
