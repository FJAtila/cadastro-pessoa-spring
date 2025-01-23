package br.dev.atila.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import br.dev.atila.model.Pessoa;
import br.dev.atila.model.Produto;

@Component
public class ProdutoRowMapper implements RowMapper<Produto> {

	@Override
	public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
		final var pessoa = Pessoa.builder().id(rs.getInt("responsavel cadastro")).build();

		return Produto.builder().id(rs.getLong("id")).nomeProduto(rs.getString("nome produto")).respCadastro(pessoa)
				.precoVenda(rs.getBigDecimal("preco venda")).precoCompra(rs.getBigDecimal("preco compra"))
				.dataCadastro(LocalDateTime.ofInstant(rs.getDate("data cadastro").toInstant(), ZoneId.systemDefault()))
				.build();
	}
}
