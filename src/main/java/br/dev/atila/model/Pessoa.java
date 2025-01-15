package br.dev.atila.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String email;

}
