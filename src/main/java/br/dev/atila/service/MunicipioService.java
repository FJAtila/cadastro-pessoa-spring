package br.dev.atila.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.dev.atila.dto.MunicipioDTO;
import br.dev.atila.dto.UfDTO;
import br.dev.atila.entity.MunicipioEntity;
import br.dev.atila.entity.UfEntity;
import br.dev.atila.repository.MunicipioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MunicipioService {

	private final MunicipioRepository municipioRepository;
	
	public List<MunicipioDTO> recuperarUf(Integer uf) {
		
		final UfEntity ufe = new UfEntity();
		ufe.setId(uf);
		
		return municipioRepository.findAllByUfOrderByNome(ufe)
				.map(m -> MunicipioDTO.builder()
						.id(m.getId())
						.nome(m.getNome())
						.uf(UfDTO.builder()
								.id(m.getUf().getId())
								.nome(m.getUf().getNome())
								.sigla(m.getUf().getSigla())
								.build())
						.build())
				.toList();
		
    }

	public MunicipioDTO recuperarPorId(Integer id) {
		final MunicipioEntity entity = municipioRepository.findById(id).orElseThrow();
		return MunicipioDTO.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.uf(UfDTO.builder()
						.id(entity.getUf().getId())
						.nome(entity.getUf().getNome())
						.sigla(entity.getUf().getSigla())
						.build())
				.build();

	}
}
