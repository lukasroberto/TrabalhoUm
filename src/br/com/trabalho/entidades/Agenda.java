package br.com.trabalho.entidades;

public class Agenda { 
	
	private Long id; 
	private String nome;
    
	public Agenda(Long id, String nome) {
		
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	} 
	
	
	

}
