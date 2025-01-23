package br.dev.atila.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import br.dev.atila.model.UF;


@Component
public class UfResultSetExtractor implements ResultSetExtractor<UF> {

	@Override
	public UF extractData(ResultSet rs) throws SQLException, DataAccessException {
		if (rs.next()) {
			return UF.builder()
					.id(rs.getInt("id"))
					.nome(rs.getString("nome"))
					.sigla(rs.getString("sigla"))
					.build();
		}
		return null;
	}
}
