package br.com.trabalho.entidades;

import java.util.ArrayList;
import java.util.List;


public class Vendas {

	private Long id;
	private String qtd;
	private String data;
	private Float precoVenda;
	private List<Produtos> produto;	
	private List<Cidade> cidade;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQtd() {
		return qtd;
	}
	public void setQtd(String qtd) {
		this.qtd = qtd;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Float getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(Float precoVenda) {
		this.precoVenda = precoVenda;
	}
	public List<Produtos> getProduto() {
		return produto;
	}
	public void setProduto(List<Produtos> produto) {
		this.produto = produto;
	}
	public List<Cidade> getCidade() {
		return cidade;
	}
	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}



}
