package br.com.trabalho.entidades;

import java.util.ArrayList;

import br.com.trabalho.dao.VendasDao;

public class Cidade {
	private Long id;
	private String nome;
	private String uf;
	
	private ArrayList<Cidade> cidades = VendasDao.getInstancia().listarCidades();
	
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

}
