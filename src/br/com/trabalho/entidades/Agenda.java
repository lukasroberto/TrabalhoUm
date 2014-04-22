package br.com.trabalho.entidades;

public class Agenda { 
	
	private Long id; 
	private String nome;
	private String data;
	private String desc;
	private int tipoAlerta;
	private String local;
    
	public Agenda(String nome, String data) {
		
		this.nome = nome;
		this.data = data;
	}

	@Override
	public String toString() {
		return nome + "                    " + data;
	} 
	
	
	

}
