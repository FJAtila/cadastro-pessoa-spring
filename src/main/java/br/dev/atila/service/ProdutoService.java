package br.dev.atila.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.dev.atila.model.Produto;
import br.dev.atila.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public List<Produto> recuperarTodosService() {

		try {
			return produtoRepository.recuperarTodosRepository();
		} catch (SQLException e) {
			log.error("Ocorreu erro ao buscar no banco de dados!", e);
			throw new RuntimeException(e);
		}
	}

	@Transactional
	public Integer cadastrarProdutoService(Produto produto) {

		if (produto.getNomeProduto() != null && produto.getId() != null) {
			return produtoRepository.cadastrarProdutoRepository(produto);
		}

		else {

			throw new RuntimeException("Erro de cadastro");
		}
	}

	@Transactional
	public void atualizarProdutoService(Produto produto, Long id) {

		if (produto.getId() == null || produto.getId().equals(id)) {
			produtoRepository.atualizarProdutoRepository(produto, id);
		}

		else {

			throw new RuntimeException("Informação divergente");
		}
	}

	public Produto recuperarProdutoPorIdService(Long id) {

		if (id > 0) {

			return produtoRepository.recuperarProdutoPorIdRepository(id);
		}

		else {

			throw new RuntimeException("id não existem no banco de dados");
		}

	}

	@Transactional
	public void deletarService(Long id) {

		if (id > 0) {
			produtoRepository.deletarProdutoRepository(id);
		}

		else {

			throw new RuntimeException("id não existem no banco de dados");
		}

	}

	public List<Produto> recuperarProdutoPorNomeService(String nomeProduto) {

		if (nomeProduto != null) {
			return produtoRepository.recuperarProdutoPorNomeRepository(nomeProduto);
		}

		else {
			throw new RuntimeException("uf não existem no banco de dados");
		}
	}

}
