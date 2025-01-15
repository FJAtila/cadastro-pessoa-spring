package br.dev.atila;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MinhaAnotacao {
	
	String name();
	
	int ordem();
	
	
	

}
