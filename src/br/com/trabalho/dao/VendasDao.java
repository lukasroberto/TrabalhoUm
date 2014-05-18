package br.com.trabalho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalho.entidades.Vendas;

public class VendasDao { 
	private static VendasDao   instancia;
	private static ArrayList<Vendas> vendas = new ArrayList<Vendas>(); 
	
private VendasDao(){ 
	
} 
public ArrayList<Vendas>listar(){

	return vendas;
}
	
	public static VendasDao  getInstancia(){ 
		if(instancia == null){ 
			instancia = new VendasDao();
		}
	return instancia; 
	}  
	public void cadastrar(Vendas agenda){
		vendas.add(agenda);
		
		
	}
	
}
