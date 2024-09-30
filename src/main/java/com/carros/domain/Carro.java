package com.carros.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "carro")
@Data
public class Carro {

	// FORAM RETIRADOS OS CONTRUTORES, GETTERS E SETTERS E SUBSTITUIDOS PELA NOTAÇÃO
	// @Data do Projeto Lombok

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String tipo;

}
