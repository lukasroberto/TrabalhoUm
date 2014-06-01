package br.com.trabalho.entidades;

import java.util.ArrayList;

import br.com.trabalho.dao.VendasDao;

public class Produtos {
	
	private Long id; 
	private String descricao;
	private Float precoUnitario;
	private ArrayList<Produtos> prod = VendasDao.getInstancia().listarProdutos();
	
	
	public ArrayList<Produtos> getProd() {
		return prod;
	}
	public void setProd(ArrayList<Produtos> prod) {
		this.prod = prod;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Float getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(Float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}


}
