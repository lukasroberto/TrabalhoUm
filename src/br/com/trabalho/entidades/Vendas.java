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
	public Vendas(String nome, String data) {

		this.qtd = nome;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Evento: " + qtd + "\n" + "Data: " + data;
	}

}
