package com.learn.api.basic.adapters;

import com.learn.api.basic.dtos.PagamentoDTO;
import com.learn.api.basic.models.Pagamento;

public class PagamentoAdapter {
	
	private FormasPagamentoAdapter formasPagamentoAdapter = new FormasPagamentoAdapter();
	
	public Pagamento converter(PagamentoDTO dto) {
		var pagamento = new Pagamento(dto.getId());
		
		pagamento.setDescricao(dto.getDescricao());
		pagamento.setFormaPagamento(formasPagamentoAdapter.converter(dto.getFormaPagamento()));
		pagamento.setValor(dto.getValor());
		pagamento.setMoeda(dto.getMoeda());
		pagamento.setData(dto.getData());
		
		return pagamento;
	}
	
	public PagamentoDTO converter(Pagamento pagamento) {
		var dto = new PagamentoDTO();
		
		dto.setId(pagamento.getId());
		dto.setDescricao(pagamento.getDescricao());
		dto.setFormaPagamento(formasPagamentoAdapter.converter(pagamento.getFormaPagamento()));
		dto.setValor(pagamento.getValor());
		dto.setMoeda(pagamento.getMoeda());
		dto.setData(pagamento.getData());
		
		return dto;
	}
}
