package br.dev.atila.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dev.atila.entity.MunicipioEntity;
import br.dev.atila.entity.UfEntity;

@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioEntity, Integer> {
	
	Stream<MunicipioEntity> findAllByUfOrderByNome(UfEntity uf);

}
