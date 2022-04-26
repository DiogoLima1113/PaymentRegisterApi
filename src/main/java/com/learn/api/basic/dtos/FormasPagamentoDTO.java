package com.learn.api.basic.dtos;

public class FormasPagamentoDTO {
		
	private Integer id;
	
	private String descricao;
	
	public FormasPagamentoDTO() {
		super();
	}

	public FormasPagamentoDTO(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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

}
