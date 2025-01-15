package br.dev.atila.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.dev.atila.model.Pessoa;

@Component
public class PessoaRowMapper implements RowMapper<Pessoa> {

	@Override
	public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Pessoa.builder()
			.id(rs.getInt("id"))
			.nome(rs.getString("nome"))
			.cpf(rs.getString("cpf"))
			.email(rs.getString("email"))
			.build();
	}

}
