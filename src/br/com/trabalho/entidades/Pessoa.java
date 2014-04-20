package br.com.trabalho.entidades;

public class Pessoa { 
	
	private Long id; 
	private String nome;
    
	public Pessoa(Long id, String nome) {
		
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	} 
	
	
	

}
