package br.dev.atila.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.dev.atila.model.Pessoa;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PessoaRepository {
	
	private final JdbcTemplate jdbcTemplate;
	private final PessoaRowMapper pessoaRowMapper;
	
	public List<Pessoa> recuperarTodos() throws SQLException {
		return jdbcTemplate.query("select * from pessoa", pessoaRowMapper);
	}
	

	
//	public static void main(String[] args) {
//		try {
//			Class.forName("org.postgresql.Driver");
//			
//			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:25432/postgres", "postgres", "postgres");
//
//			connection.createStatement().execute("begin");
//			
//			
//			PreparedStatement ps = connection.prepareStatement("select * from pessoa");
//			
//			List<Pessoa> pessoas = new ArrayList<Pessoa>();
//			
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				final var pessoa = Pessoa.builder()
//						.id(rs.getInt("id"))
//						.nome(rs.getString("nome"))
//						.cpf(rs.getString("cpf"))
//						.email(rs.getString("email"))
//						.build();
//				pessoas.add(pessoa);
//			}
//			
//			connection.createStatement().execute("commit;");
//			connection.createStatement().execute("end");
//			connection.close();
//		}catch (Exception e) {
//			System.err.println("Deu ruim!");
//			e.printStackTrace();
//		}
//	}
	
	

}
