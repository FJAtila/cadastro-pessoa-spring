package br.dev.atila.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.dev.atila.model.Municipio;
import br.dev.atila.service.MunicipioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/municipio")
@RequiredArgsConstructor
@RestController
@Tag(name = "👤 Municipio", description = "CRUD de Municipio")

public class MunicipioController {

	private final MunicipioService municipioService;

	@GetMapping(path = "/{uf}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Municipio>> recuperarUf(@PathVariable Integer uf) {
		final var ufs = municipioService.recuperarUf(uf);
		return ResponseEntity.ok(ufs);
	}
}