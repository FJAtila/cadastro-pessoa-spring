package br.dev.atila.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.dev.atila.model.UF;

@Component
public class UfRowMapper implements RowMapper <UF> {

	public UF mapRow(ResultSet rs, int rowNum) throws SQLException {
		return UF.builder()
			.id(rs.getInt("id"))
			.nome(rs.getString("nome"))
			.sigla(rs.getString("sigla"))
			.build();
	}
	
}
