package br.com.trabalho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalho.entidades.Agenda;

public class AgendaDao { 
	private static AgendaDao   instancia;
	private static List<Agenda> agendas = new ArrayList<Agenda>(); 
	
private AgendaDao(){ 
	
} 
public List<Agenda>listar(){

	return agendas;
}
	
	public static AgendaDao  getInstancia(){ 
		if(instancia == null){ 
			instancia = new AgendaDao();
		}
	return instancia; 
	}  
	public void cadastrar(Agenda agenda){
		agendas.add(agenda);
		
		
	}
	
}
