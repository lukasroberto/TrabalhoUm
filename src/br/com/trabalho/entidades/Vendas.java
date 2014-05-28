package br.com.trabalho.entidades;

import java.util.ArrayList;

import br.com.trabalho.dao.VendasDao;


public class Vendas {

	private Long id;
	private String qtd;
	private String data;
	private Float precoVenda;
	private Produtos produto;
	private Cidade cidade;
	
	private ArrayList<Vendas> vendas = VendasDao.getInstancia().listar();

	public ArrayList<Vendas> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Vendas> vendas) {
		this.vendas = vendas;
	}

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

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
