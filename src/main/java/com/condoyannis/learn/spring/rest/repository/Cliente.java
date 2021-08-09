package com.condoyannis.learn.spring.rest.repository;

import org.springframework.stereotype.Repository;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Repository
public class Cliente {
	private final Long id;
	private final String nome;
}