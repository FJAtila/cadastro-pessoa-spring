package br.dev.atila.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.dev.atila.dto.UfDTO;
import br.dev.atila.entity.UfEntity;
import br.dev.atila.repository.UfRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UfService {

	private final UfRepository ufRepository;

	public List<UfDTO> recuperarTodos() {
		return ufRepository.findAll()
				.stream()
				.map(e -> UfDTO.builder()
						.id(e.getId())
						.nome(e.getNome())
						.sigla(e.getSigla())
						.build()
				)
				.toList();
	}

	public UfDTO recuperar(Integer id) {
		final UfEntity entity =  ufRepository.findById(id).orElseThrow();
		return UfDTO.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.sigla(entity.getSigla())
				.build();
	}
	

	public UfDTO recuperarPorSigla(String sigla) {
		final UfEntity entity = ufRepository.findBySigla(sigla).orElseThrow();
		return UfDTO.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.sigla(entity.getSigla())
				.build();

	}
}