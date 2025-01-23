package br.dev.atila.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import br.dev.atila.model.Pessoa;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PessoaRepository {
	
	private final JdbcTemplate jdbcTemplate;
	private final PessoaRowMapper pessoaRowMapper;
	private final PessoaResultSetExtractor pessoaResultSetExtractor;
	
	public List<Pessoa> recuperarTodos() throws SQLException {
		return jdbcTemplate.query("select * from pessoa", pessoaRowMapper);
		
	}
	
	
	
	
	public Integer salvar(Pessoa pessoa) {
		
		
		return jdbcTemplate.execute("insert into pessoa (nome, cpf, email) values (?, ?, ?);", (PreparedStatementCallback<Integer>) ps -> {
			
			String nome = pessoa.getNome();
			
			ps.setString(1, nome);
		 	ps.setString(2, pessoa.getCpf());
		 	ps.setString(3, pessoa.getEmail());
		 	
		 	return ps.executeUpdate();
		});
	 }
	
	
	
	public Integer deletar(Integer id) {
		
		return jdbcTemplate.execute("delete from pessoa where id = ?;", (PreparedStatementCallback<Integer>) ps -> {
			
			ps.setInt(1, id);
		 	
			return ps.executeUpdate();
		});
			
	}
	
	
	
	public Integer atualizar(Pessoa pessoa, Integer id) {
		
		return jdbcTemplate.execute("update pessoa set nome = ?, cpf = ?, email = ? where id = ?;", (PreparedStatementCallback<Integer>) ps -> {
			
			String atualizarDados = pessoa.getNome();
			
			ps.setString(1, atualizarDados);
		 	ps.setString(2, pessoa.getCpf());
		 	ps.setString(3, pessoa.getEmail());
		 	ps.setInt(4, id);
			
			return ps.executeUpdate();	
		});
	}
	
	
	public Pessoa recuperar(Integer id) {
		final var sql = "select * from pessoa where id = ?";
		
		Pessoa p = jdbcTemplate.query(
				sql, 
				ps -> ps.setInt(1, id), 
				pessoaResultSetExtractor
			);
		
		return p;
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
