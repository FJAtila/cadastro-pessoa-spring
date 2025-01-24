package br.dev.atila;

import java.beans.PersistenceDelegate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Order;

import br.dev.atila.entity.UfEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;

@MinhaAnotacao(name = "Pedro", ordem = 1)
@SpringBootApplication
public class CadastroPessoasSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroPessoasSpringApplication.class, args);
		
//		new ExemploEntityManager().teste();
	}
	
	
	
//	public static void main(String[] args) {
//		final var annotations = CadastroPessoasSpringApplication.class.getDeclaredAnnotations();
//		final var minhaAnotacao = (MinhaAnotacao) annotations[0];
//		System.out.println(minhaAnotacao.name());
//		System.out.println(minhaAnotacao.ordem());;
//	}
	
	private void teste() {
		
		Areia areia = new Areia();
		Pedrinha pedrinha = new Pedrinha();
		
		Balde<Areia> balde = new Balde<Areia>();
		balde.setConteudo(areia);
		
		//Não funciona. Pedrinha não é Quantificavel
//		Balde<Pedrinha> bPedrinha = new Balde<Pedrinha>();
		
		
	}

}

class Controller {
	
	private final Service service;

	public Controller(Service service) {
		super();
		this.service = service;
	}
	
	
}

class Service {
	
	private final Repository repository;

	public Service(Repository repository) {
		super();
		this.repository = repository;
	}
	
	
	
}

class Repository {
	
	private final DataSource dataSource;
	
	public Repository(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
}

class Main {
	
	public static void main(String[] args) {
		DataSource dataSource = null;
		Repository repository = new Repository(dataSource);
		Service service = new Service(repository);
		Controller controller = new Controller(service);
		
		
	}
}


class Pedrinha {
	
}


class Areia extends MaterialParticulado {
	
	@Override
	public Integer getQuantidade() {
		return 10;
	}
	
}

abstract class MaterialParticulado implements Quantificavel {
	
}

abstract class Liquido implements Quantificavel {
	
}

interface Quantificavel {
	
	Integer getQuantidade();
}

class Balde<T extends Quantificavel> {
	
	private T conteudo;
	private Integer volume;
	
	
	public T getConteudo() {
		return conteudo;
	}
	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}
	public Integer getVolume() {
		return conteudo.getQuantidade();
	}
	
	
}



class ExemploEntityManager {
	
	void teste() {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastroPessoaPU");
		
		final EntityManager em = emf.createEntityManager();
		
		final UfEntity uf = em.find(UfEntity.class, 53);
		
//		final UfEntity zz = new UfEntity();
//		zz.setId(99);
//		zz.setNome("Zona Zica");
//		zz.setSigla("ZZ");
//		
//		final var transaction = em.getTransaction();
//		transaction.begin();
//		
//		em.persist(zz);
//		
//		transaction.commit();
		
		final TypedQuery<UfEntity> query = em.createQuery("SELECT a FROM UfEntity a WHERE a.id = :xurupitas", UfEntity.class);
		query.setParameter("xurupitas", 31);
		
		final var df = query.getSingleResult();
		
		final TypedQuery<UfEntity> outraQuery = em.createQuery("SELECT a FROM UfEntity a WHERE a.nome LIKE :umNome", UfEntity.class);
		outraQuery.setParameter("umNome", "%ia%");
		
		final var ufs = outraQuery.getResultList();
		
		final var cb = em.getCriteriaBuilder();
		final var criteriaQuery = cb.createQuery(UfEntity.class);
		criteriaQuery.from(UfEntity.class);
		
		final var todasUfs = em.createQuery(criteriaQuery).getResultList();
		
		
		System.out.println(df);
	}
	
}



























