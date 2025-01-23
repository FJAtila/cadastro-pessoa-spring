package br.dev.atila.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.dev.atila.model.Municipio;

@Component
public class MunicipioRowMapper implements RowMapper <Municipio> {

	public Municipio mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Municipio.builder()
			.id(rs.getInt("id"))
			.nome(rs.getString("nome"))
			.uf(rs.getInt("uf"))
			.build();
	}
}
