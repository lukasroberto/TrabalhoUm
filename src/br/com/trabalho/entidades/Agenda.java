package br.com.trabalho.entidades;

public class Agenda { 
	
	private Long id; 
	private String nome;
	private String data;
    
	public Agenda(String data, String nome) {
		
		this.nome = nome;
		this.data = data;
	}

	@Override
	public String toString() {
		return nome + "                    "+ data;
	} 
	
	
	

}
