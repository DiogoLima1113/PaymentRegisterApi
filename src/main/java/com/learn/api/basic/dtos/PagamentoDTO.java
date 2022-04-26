package com.learn.api.basic.dtos;

import java.util.Date;

public class PagamentoDTO {
		
	private Integer id;
	
	private String descricao;
	
	private FormasPagamentoDTO formaPagamento;
	
	private Double valor;
	
	private String moeda;
	
	private Date data;

	public PagamentoDTO() {
		super();
	}

	public PagamentoDTO(Integer id, String descricao, FormasPagamentoDTO formaPagamento, Double valor, String moeda, Date data) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.formaPagamento = formaPagamento;
		this.valor = valor;
		this.moeda = moeda;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FormasPagamentoDTO getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormasPagamentoDTO formaPagamento) {
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
