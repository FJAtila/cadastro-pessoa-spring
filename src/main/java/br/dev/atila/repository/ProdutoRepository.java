package br.dev.atila.repository;

import java.sql.Date;
import java.sql.SQLException;
import java.time.ZoneOffset;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import br.dev.atila.model.Produto;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProdutoRepository {

	private final JdbcTemplate jdbcTemplate;
	private final ProdutoRowMapper produtoRowMapper;
	private final ProdutoResultSetExtractor produtoResultSetExtractor;

	public List<Produto> recuperarTodosRepository() throws SQLException {
		return jdbcTemplate.query("select * from produto", produtoRowMapper);

	}

	public Produto recuperarProdutoPorIdRepository(Long id) {

		final var sql = "select * from produto where id = ?";
		Produto idProduto = jdbcTemplate.query(sql, ps -> ps.setLong(1, id), produtoResultSetExtractor);
		return idProduto;

	}

	public Integer atualizarProdutoRepository(Produto produto, Long id) {

		return jdbcTemplate.execute(
				"update produto set nome = ?, responsavel_produto = ?, preco_compra = ?, preco_venda = ?, data_cadastro = ?, where id = ?;",
				(PreparedStatementCallback<Integer>) ps -> {

					ps.setString(1, produto.getNomeProduto());
					ps.setInt(2, produto.getRespCadastro().getId());
					ps.setBigDecimal(3, produto.getPrecoCompra());
					ps.setBigDecimal(4, produto.getPrecoVenda());
					ps.setDate(5, new Date(produto.getDataCadastro().toEpochSecond(ZoneOffset.UTC)));
					ps.setLong(6, produto.getId());

					return ps.executeUpdate();
				});

	}

	public Integer deletarProdutoRepository(Long id) {

		return jdbcTemplate.execute("delete from produto where id = ?;", (PreparedStatementCallback<Integer>) ps -> {

			ps.setLong(1, id);

			return ps.executeUpdate();
		});
	}

	public Integer cadastrarProdutoRepository(Produto produto) {

		return jdbcTemplate.execute(
				"insert into produto (nome, responsavel_cadastro, preco_compra, preco_venda, data_cadastro) values (?, ?, ?, ?, ?);",
				(PreparedStatementCallback<Integer>) ps -> {

					ps.setString(1, produto.getNomeProduto());
					ps.setInt(2, produto.getRespCadastro().getId());
					ps.setBigDecimal(3, produto.getPrecoCompra());
					ps.setBigDecimal(4, produto.getPrecoVenda());
					ps.setDate(5, new Date(produto.getDataCadastro().toEpochSecond(ZoneOffset.UTC)));

					return ps.executeUpdate();
				});
	}

	public List<Produto> recuperarProdutoPorNomeRepository(String nomeProduto) {

		final var sql = "select * from produto where nome like ' % ? % '";

		List<Produto> nome = jdbcTemplate.query(sql, ps -> ps.setString(1, nomeProduto), produtoRowMapper);

		return nome;
	}
}
