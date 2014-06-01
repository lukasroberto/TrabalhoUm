package br.com.trabalho.entidades;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.trabalho.dao.VendasDao;
import br.com.trabalho.main.RowGoogleChart;


public class Vendas implements RowGoogleChart {

	private Long id;
	private String qtd;
	private Calendar data;
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
		int dia = data.get(Calendar.DAY_OF_MONTH);
		int mes = data.get(Calendar.MONTH) + 1;
		int ano = data.get(Calendar.YEAR);
		
		return dia + "/" + mes +"/"+ ano;
	}

	public void setData(Calendar data) {
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
	
	public void VendasGrafico(Calendar data, Float precoVenda) {		
		this.data = data;
		this.precoVenda = precoVenda;
	}
	
	@Override
	public String getRow() {
		int mes = data.get(Calendar.MONTH) + 1;
		int ano = data.get(Calendar.YEAR);
		return "['"+mes+"-"+ano+"', "+precoVenda+"],";
	}

	

}
