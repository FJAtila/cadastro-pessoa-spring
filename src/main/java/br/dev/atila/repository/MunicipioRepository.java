package br.dev.atila.repository;

import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.dev.atila.model.Municipio;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MunicipioRepository {

	private final JdbcTemplate jdbcTemplate;
	private final MunicipioRowMapper municipioRowMapper;
	private final MunicipioResultSetExtractor municipioResultSetExtractor;
	
	
	
	public List<Municipio> recuperarMunicipiosPoruf(Integer uf) {
		
		final var sql = "select * from municipio where uf = ?";
		
		List<Municipio> mu = jdbcTemplate.query(sql, ps -> ps.setInt(1, uf), municipioRowMapper);
		
		return mu;
	}
}
