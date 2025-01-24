package br.dev.atila.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioDTO {
	
	private Integer id;
	private String nome;
	private UfDTO uf;

}
