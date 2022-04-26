package com.learn.api.basic.adapters;

import com.learn.api.basic.dtos.FormasPagamentoDTO;
import com.learn.api.basic.models.FormasPagamento;

public class FormasPagamentoAdapter {

	public FormasPagamento converter(FormasPagamentoDTO dto) {
		var formasPagamento = new FormasPagamento(
			dto.getId(),
			dto.getDescricao()
		);
				
		return formasPagamento;
	}
	
	public FormasPagamentoDTO converter(FormasPagamento formasPagamento) {
		var dto = new FormasPagamentoDTO(
			formasPagamento.getId(),
			formasPagamento.getDescricao()
		);
				
		return dto;
	}
}
