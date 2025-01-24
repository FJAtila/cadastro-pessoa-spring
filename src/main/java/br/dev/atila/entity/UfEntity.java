package br.dev.atila.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "uf")
public class UfEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", length = 19, nullable = false)
	private String nome;
	
	@Column(name = "sigla", length = 2, nullable = false)
	private String sigla;

}
