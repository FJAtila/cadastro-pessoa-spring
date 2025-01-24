package br.dev.atila.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dev.atila.entity.UfEntity;

@Repository
public interface UfRepository extends JpaRepository<UfEntity, Integer> {
	
	Optional<UfEntity> findBySigla(String sigla);

}
