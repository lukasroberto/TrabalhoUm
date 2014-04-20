package br.com.trabalho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalho.entidades.Pessoa;

public class PessoaDao { 
	private static PessoaDao   instancia;
	private static List<Pessoa> pessoas = new ArrayList<Pessoa>(); 
	
private PessoaDao(){ 
	
} 
public List<Pessoa>listar(){

	return pessoas;
}
	
	public static PessoaDao  getInstancia(){ 
		if(instancia == null){ 
			instancia = new PessoaDao();
		}
	return instancia; 
	}  
	public void cadastrar(Pessoa pessoa){
		pessoas.add(pessoa);
		
		
	}
	
	
	
	

}
