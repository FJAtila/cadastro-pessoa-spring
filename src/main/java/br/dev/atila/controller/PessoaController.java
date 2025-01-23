package br.dev.atila.controller;

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

import br.dev.atila.model.Pessoa;
import br.dev.atila.service.PessoaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Tag(name = "👤 Pessoa", description = "CRUD de Pessoa")
@RequestMapping("/pessoa")
@RequiredArgsConstructor
public class PessoaController {
	
	private final PessoaService pessoaService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pessoa>> obtemListaPessoas() {
		final var pessoas = pessoaService.recuperarTodos();
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> recuperarPorId(@PathVariable Integer id) {
		final var pessoa = pessoaService.recuperar(id);
		return ResponseEntity.ok(pessoa);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> cadastrarPessoa(@RequestBody Pessoa pessoa) {
		
		Integer id = pessoaService.criar(pessoa); 
		
		final var uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(id)
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa, @PathVariable Integer id) {
		pessoaService.atualizar(pessoa, id);
		return ResponseEntity.ok().build() ;
	}
	
	
	
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> deletar(@PathVariable Integer id) {
		pessoaService.deletar(id);
		return ResponseEntity.ok().build() ;
	}
	

}
