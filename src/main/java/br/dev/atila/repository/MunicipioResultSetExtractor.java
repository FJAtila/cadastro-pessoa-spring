package br.dev.atila.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import br.dev.atila.model.Municipio;


@Component
public class MunicipioResultSetExtractor implements ResultSetExtractor<Municipio> {

	@Override
	public Municipio extractData(ResultSet rs) throws SQLException, DataAccessException {
		if (rs.next()) {
			return Municipio.builder()
					.id(rs.getInt("id"))
					.nome(rs.getString("nome"))
					.uf(rs.getInt("uf"))
					.build();
		}
		return null;
	}
}
