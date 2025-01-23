package br.dev.atila.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import br.dev.atila.model.Municipio;
import br.dev.atila.repository.MunicipioRepository;
import br.dev.atila.repository.MunicipioRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MunicipioService {

	private final MunicipioRepository municipioRepository;
	private final MunicipioRowMapper municipioRowMapper;
	
	
	//public List<Municipio> recuperarMunicipio() {
		
	//	try {
	//		return municipioRepository.recuperarMunicipio();
	//	} catch (SQLException e) {
	//		log.error("Ocorreu erro ao buscar no banco de dados!", e);
	//		throw new RuntimeException(e);
	//	}
//	}
	
	
	
	public List<Municipio> recuperarUf(Integer uf) {
		
		if (uf > 0) {
			return municipioRepository.recuperarMunicipiosPoruf(uf);
		}
		
		else {
			throw new RuntimeException("uf não existem no banco de dados");
	    }
    }
}
