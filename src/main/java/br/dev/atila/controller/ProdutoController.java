package br.dev.atila.controller;

import br.dev.atila.service.ProdutoService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.dev.atila.model.Produto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Tag(name = "👤 Produto", description = "CRUD de Produto")
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

	private final ProdutoService produtoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> obtemListaProdutos() {
		final var produtos = produtoService.recuperarTodosService();
		return ResponseEntity.ok(produtos);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> cadastrarProdutoController(@RequestBody Produto produto) {
        Integer id = produtoService.cadastrarProdutoService(produto);
        final var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(path = "/{atualizarid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> atualizarController(@RequestBody Produto produto, @PathVariable Long id) {
		produtoService.atualizarProdutoService(produto, id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(path = "/{deletarid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> deletarController(@PathVariable Long id) {
		produtoService.deletarService(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(path = "/{recuperarid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> recuperarPorIdController(@PathVariable Long id) {
		final var produtos = produtoService.recuperarProdutoPorIdService(id);
		return ResponseEntity.ok(produtos);
	}
	
	@GetMapping(path = "/{recuperarnome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> recuperarProdutoPorNome(@PathVariable String nomeProduto) {
		final var nome = produtoService.recuperarProdutoPorNomeService(nomeProduto);
		return ResponseEntity.ok(nome);
	}
}
