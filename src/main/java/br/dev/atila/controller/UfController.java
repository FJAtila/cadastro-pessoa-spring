package br.dev.atila.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.atila.dto.UfDTO;
import br.dev.atila.service.UfService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/uf")
@RequiredArgsConstructor
@RestController
@Tag(name = "👤 UF", description = "CRUD de UF")

public class UfController {

	private final UfService ufservice;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UfDTO>> obtemListaUfs() {
		final var ufs = ufservice.recuperarTodos();
		return ResponseEntity.ok(ufs);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UfDTO> recuperarUfPorId(@PathVariable Integer id) {
		final var uf = ufservice.recuperar(id);
		return ResponseEntity.ok(uf);
	}
	
	@GetMapping(path = "/sigla/{sigla}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UfDTO> recuperarSigla(@PathVariable String sigla) {
		final var uf = ufservice.recuperarPorSigla(sigla);
		return ResponseEntity.ok(uf);
	}
	
}
