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
	public void listDeProdutos() {
	
	if (prod.size() == 0) {
		Produtos produto1 = new Produtos();
		produto1.setId(1l);
		produto1.setPrecoUnitario(1.5f);
		produto1.setDescricao("Banana");
		VendasDao.getInstancia().cadastrarProduto(produto1);

		Produtos produto2 = new Produtos();
		produto2.setId(2l);
		produto2.setPrecoUnitario(1.9f);
		produto2.setDescricao("Morango");
		VendasDao.getInstancia().cadastrarProduto(produto2);

		Produtos produto3 = new Produtos();
		produto3.setId(3l);
		produto3.setPrecoUnitario(2.5f);
		produto3.setDescricao("Maça");
		VendasDao.getInstancia().cadastrarProduto(produto3);

		Produtos produto4 = new Produtos();
		produto4.setId(4l);
		produto4.setPrecoUnitario(2.2f);
		produto4.setDescricao("Goiaba");
		VendasDao.getInstancia().cadastrarProduto(produto4);
		
		Produtos produto5 = new Produtos();
		produto5.setId(5l);
		produto5.setPrecoUnitario(3.3f);
		produto5.setDescricao("Pecego");
		VendasDao.getInstancia().cadastrarProduto(produto5);

		Produtos produto6 = new Produtos();
		produto6.setId(6l);
		produto6.setPrecoUnitario(2.7f);
		produto6.setDescricao("Uva");
		VendasDao.getInstancia().cadastrarProduto(produto6);
		
		Produtos produto7 = new Produtos();
		produto7.setId(7l);
		produto7.setPrecoUnitario(5.2f);
		produto7.setDescricao("Abacaxi");
		VendasDao.getInstancia().cadastrarProduto(produto7);
		
		Produtos produto8 = new Produtos();
		produto8.setId(8l);
		produto8.setPrecoUnitario(2.2f);
		produto8.setDescricao("Laranja");
		VendasDao.getInstancia().cadastrarProduto(produto8);
		
		Produtos produto9 = new Produtos();
		produto9.setId(4l);
		produto9.setPrecoUnitario(1.2f);
		produto9.setDescricao("Jaca");
		VendasDao.getInstancia().cadastrarProduto(produto9);
	}
}

}
