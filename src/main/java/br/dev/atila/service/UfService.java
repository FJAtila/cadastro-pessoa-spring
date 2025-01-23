package br.dev.atila.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import br.dev.atila.model.UF;
import br.dev.atila.repository.UfRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UfService {

	private final UfRepository ufRepository;

	public List<UF> recuperarTodos() {
		try {
			return ufRepository.recuperarTodos();
		} catch (SQLException e) {
			log.error("Ocorreu erro ao buscar no banco de dados!", e);
			throw new RuntimeException(e);
		}
	}

	public UF recuperar(Integer id) {
			
			if (id > 0) {
				
				return ufRepository.recuperar(id);
			}
			
			else {
				
				throw new RuntimeException("id não existem no banco de dados");
		   }
	}
	

	public UF recuperarSigla(String sigla) {

		if (sigla != null) {

			return ufRepository.recuperarSigla(sigla);
		}

		else {

			throw new RuntimeException("sigla não existem no banco de dados");

		}
	}
}