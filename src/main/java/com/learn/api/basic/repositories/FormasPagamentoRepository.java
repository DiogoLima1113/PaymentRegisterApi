package com.learn.api.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.api.basic.models.FormasPagamento;

@Repository
public interface FormasPagamentoRepository extends JpaRepository<FormasPagamento, Integer> {

}
