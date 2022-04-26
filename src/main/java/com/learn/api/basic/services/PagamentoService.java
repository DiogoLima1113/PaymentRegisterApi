package com.learn.api.basic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.api.basic.adapters.FormasPagamentoAdapter;
import com.learn.api.basic.adapters.PagamentoAdapter;
import com.learn.api.basic.dtos.PagamentoDTO;
import com.learn.api.basic.models.Pagamento;
import com.learn.api.basic.repositories.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository repository;
	
	private PagamentoAdapter adapter = new PagamentoAdapter();
	
	private FormasPagamentoAdapter formasPagamentoAdapter = new FormasPagamentoAdapter();
	
	public PagamentoDTO criar(PagamentoDTO dto) {
		Pagamento pagamento = adapter.converter(dto);
		
		pagamento = repository.save(pagamento);
		
		return adapter.converter(pagamento);
	}
	
	public PagamentoDTO editar(PagamentoDTO dto) {
		Pagamento pagamento = repository.getById(dto.getId());
		
		pagamento.setDescricao(dto.getDescricao());
		pagamento.setFormaPagamento(formasPagamentoAdapter.converter(dto.getFormaPagamento()));
		pagamento.setValor(dto.getValor());
		pagamento.setMoeda(dto.getMoeda());
		pagamento.setData(dto.getData());
		
		repository.save(pagamento);
		
		return adapter.converter(pagamento);
	}
	
	public PagamentoDTO obterId(Integer id) {
		Pagamento pagamento = repository.getById(id);
		
		return adapter.converter(pagamento);
	}
	
	public List<PagamentoDTO> obterTodos() {
		List<Pagamento> pagamentoList = repository.findAll();
		
		List<PagamentoDTO> dtoList = new ArrayList<PagamentoDTO>();
		
		for (Pagamento pagamento : pagamentoList) {
			dtoList.add(adapter.converter(pagamento));
		}
		
		return dtoList;
	}
	
	public PagamentoDTO excluir(Integer id) {
		Pagamento pagamento = repository.getById(id);
		
		repository.delete(pagamento);
		
		return adapter.converter(pagamento);
	}
}
