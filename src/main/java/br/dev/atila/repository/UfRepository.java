package br.dev.atila.repository;

import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.dev.atila.model.UF;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UfRepository {

	private final JdbcTemplate jdbcTemplate;
	private final UfRowMapper ufRowMapper;
	private final UfResultSetExtractor ufResultSetExtractor;
	
	
	public List<UF> recuperarTodos() throws SQLException {
		return jdbcTemplate.query("select * from uf", ufRowMapper);
	}
	
	
	
	public UF recuperar(Integer id) {
		final var sql = "select * from uf where id = ?";
		
		UF u = jdbcTemplate.query(
				sql, 
				ps -> ps.setInt(1, id), 
				ufResultSetExtractor
			);
		
		return u;
	}
	
	public UF recuperarSigla(String sigla) {
		final var sql = "select * from uf where sigla = ?";
		
		UF s = jdbcTemplate.query(
				sql, 
				ps -> ps.setString(1, sigla), 
				ufResultSetExtractor
			);
		
		return s;
	}
}
