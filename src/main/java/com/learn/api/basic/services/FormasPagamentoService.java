package com.learn.api.basic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.api.basic.adapters.FormasPagamentoAdapter;
import com.learn.api.basic.dtos.FormasPagamentoDTO;
import com.learn.api.basic.models.FormasPagamento;
import com.learn.api.basic.repositories.FormasPagamentoRepository;

@Service
public class FormasPagamentoService {
	
	@Autowired
	private FormasPagamentoRepository repository;
	
	private FormasPagamentoAdapter adapter = new FormasPagamentoAdapter();
	
	public FormasPagamentoDTO criar(FormasPagamentoDTO dto) {
		FormasPagamento formasPagamento = adapter.converter(dto);
		
		formasPagamento = repository.save(formasPagamento);
		
		return adapter.converter(formasPagamento);
	}
	
	public FormasPagamentoDTO editar(FormasPagamentoDTO dto) {
		FormasPagamento formasPagamento = repository.getById(dto.getId());
		
		formasPagamento.setDescricao(dto.getDescricao());
		repository.save(formasPagamento);
		
		return adapter.converter(formasPagamento);
	}
	
	public FormasPagamentoDTO obterId(Integer id) {
		FormasPagamento formasPagamento = repository.getById(id);
		
		return adapter.converter(formasPagamento);
	}
	
	public List<FormasPagamentoDTO> obterTodos() {
		List<FormasPagamento> formasPagamentoList = repository.findAll();
		
		List<FormasPagamentoDTO> dtoList = new ArrayList<FormasPagamentoDTO>();
		
		for (FormasPagamento formasPagamento : formasPagamentoList) {
			dtoList.add(adapter.converter(formasPagamento));
		}
		
		return dtoList;
	}
	
	public FormasPagamentoDTO excluir(Integer id) {
		FormasPagamento formasPagamento = repository.getById(id);
		
		repository.delete(formasPagamento);
		
		return adapter.converter(formasPagamento);
	}
}
