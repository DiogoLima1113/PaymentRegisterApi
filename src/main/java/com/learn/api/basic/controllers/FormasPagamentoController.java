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

import com.learn.api.basic.dtos.FormasPagamentoDTO;
import com.learn.api.basic.services.FormasPagamentoService;

@RestController
@RequestMapping("/formaspagamento")
public class FormasPagamentoController {
	
	@Autowired
	private FormasPagamentoService service;
	
	@PostMapping
	public ResponseEntity<FormasPagamentoDTO> post(@RequestBody FormasPagamentoDTO dto){
		FormasPagamentoDTO criado = service.criar(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(criado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FormasPagamentoDTO> put(@PathVariable Integer id,@RequestBody FormasPagamentoDTO dto){
		dto.setId(id);
		FormasPagamentoDTO editado = service.editar(dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(editado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FormasPagamentoDTO> get(@PathVariable Integer id){
		FormasPagamentoDTO buscado = service.obterId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(buscado);
	}
	
	@GetMapping()
	public ResponseEntity<List<FormasPagamentoDTO>> get(){
		List<FormasPagamentoDTO> lista = service.obterTodos();
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<FormasPagamentoDTO> delete(@PathVariable Integer id){
		FormasPagamentoDTO deletado = service.excluir(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(deletado);
	}
	
}
