package br.dev.atila;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MinhaAnotacao(name = "Pedro", ordem = 1)
@SpringBootApplication
public class CadastroPessoasSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroPessoasSpringApplication.class, args);
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