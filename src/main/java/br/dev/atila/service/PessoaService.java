package br.dev.atila.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.atila.model.Pessoa;
import br.dev.atila.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaService {
	
	private final PessoaRepository pessoaRepository;
	
	public List<Pessoa> recuperarTodos() {
		try {
			return pessoaRepository.recuperarTodos();
		} catch (SQLException e) {
			log.error("Ocorreu erro ao buscar no banco de dados!", e);
			throw new RuntimeException(e);
		}
	}
	
	public Pessoa recuperar(Integer id) {
		//TODO: implementar
		return null;
	}
	
	@Transactional
	public Integer criar(Pessoa pessoa) {
		//TODO: implementar
		return 0;
	}
	
	
	@Transactional
	public void atualizar(Pessoa pessoa) {
		//TODO: implementar
	}
	
	@Transactional
	public void deletar(Integer id) {
		//TODO: implementar
	}
	

}
