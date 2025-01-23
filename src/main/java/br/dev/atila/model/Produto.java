package br.dev.atila.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class Produto {

	private Long id;
	private String nomeProduto;
	private Pessoa respCadastro;
	private BigDecimal precoVenda;
	private BigDecimal precoCompra;
	private LocalDateTime dataCadastro;
}
