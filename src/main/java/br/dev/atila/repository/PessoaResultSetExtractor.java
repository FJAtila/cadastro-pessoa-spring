package br.dev.atila.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import br.dev.atila.model.Pessoa;

@Component
public class PessoaResultSetExtractor implements ResultSetExtractor<Pessoa> {
	
	@Override
	public Pessoa extractData(ResultSet rs) throws SQLException, DataAccessException {
		if (rs.next()) {
			return Pessoa.builder()
					.id(rs.getInt("id"))
					.nome(rs.getString("nome"))
					.cpf(rs.getString("cpf"))
					.email(rs.getString("email"))
					.build();
		}
		return null;
	}

}
