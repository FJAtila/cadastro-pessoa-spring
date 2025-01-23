package br.dev.atila.service;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

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
		
		if (id > 0) {
			
			return pessoaRepository.recuperar(id);
			
		}
		
		else {
			
			throw new RuntimeException("id não existem no banco de dados");
	   }
		
	}
	
	

	@Transactional
	public Integer criar(Pessoa pessoa) {
		
		if (pessoa.getNome() != null && pessoa.getCpf() != null) {
			return pessoaRepository.salvar(pessoa);
        }
		
		else {
			
			throw new RuntimeException("Digite os campos obrigatórios");
		}
	}
	
	

	@Transactional
	public void atualizar(Pessoa pessoa, Integer id) {
		
		if(pessoa.getId() == null || pessoa.getId().equals(id)) {
			pessoaRepository.atualizar(pessoa,id);
		}
		
		else {
			
			throw new RuntimeException("Informação divergente");
		}
	}
	
	

	@Transactional
	public void deletar(Integer id) {
		
		if (id > 0) {
			pessoaRepository.deletar(id);
		}
		
		else {
			
			throw new RuntimeException("id não existem no banco de dados");
	    }

	}
}
