package br.dev.atila.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import br.dev.atila.model.Pessoa;
import br.dev.atila.model.Produto;

@Component
public class ProdutoResultSetExtractor implements ResultSetExtractor<Produto> {

	@Override
	public Produto extractData(ResultSet rs) throws SQLException, DataAccessException {

		final var pessoa = Pessoa.builder().id(rs.getInt("responsavel cadastro")).build();

		if (rs.next()) {
			return Produto.builder().id(rs.getLong("id")).nomeProduto(rs.getString("nome produto")).respCadastro(pessoa)
					.precoVenda(rs.getBigDecimal("preco venda")).precoCompra(rs.getBigDecimal("preco compra"))
					.dataCadastro(LocalDateTime.ofInstant(rs.getDate("data cadastro").toInstant(), ZoneId.systemDefault()))
					.build();
		}

		return null;

	}
}