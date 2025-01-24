package br.dev.atila.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "municipio")
public class MunicipioEntity {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome", length = 255, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "uf", referencedColumnName = "id")
	private UfEntity uf;
	
}
