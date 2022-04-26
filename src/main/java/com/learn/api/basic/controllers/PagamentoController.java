package com.learn.api.basic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.basic.dtos.PagamentoDTO;
import com.learn.api.basic.services.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
	
	@Autowired
	private PagamentoService service;
	
	@PostMapping
	public ResponseEntity<PagamentoDTO> post(@RequestBody PagamentoDTO dto){
		PagamentoDTO criado = service.criar(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(criado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PagamentoDTO> put(@PathVariable Integer id, @RequestBody PagamentoDTO dto){
		dto.setId(id);
		PagamentoDTO editado = service.editar(dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(editado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PagamentoDTO> get(@PathVariable Integer id){
		PagamentoDTO buscado = service.obterId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(buscado);
	}
	
	@GetMapping()
	public ResponseEntity<List<PagamentoDTO>> get(){
		List<PagamentoDTO> lista = service.obterTodos();
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PagamentoDTO> delete(@PathVariable Integer id){
		PagamentoDTO deletado = service.excluir(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(deletado);
	}
	
}
