package br.com.trabalho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalho.entidades.Cidade;
import br.com.trabalho.entidades.Produtos;
import br.com.trabalho.entidades.Vendas;

public class VendasDao {
	private static VendasDao instancia;
	private static ArrayList<Vendas> vendas = new ArrayList<Vendas>();
	private static ArrayList<Produtos> produtos = new ArrayList<Produtos>();
	private static ArrayList<Cidade> cidades = new ArrayList<Cidade>();

	private VendasDao() {

	}

	public static VendasDao getInstancia() {
		if (instancia == null) {
			instancia = new VendasDao();
		}
		return instancia;
	}

	public ArrayList<Vendas> listar() {

		return vendas;
	}

	public void cadastrar(Vendas agenda) {
		vendas.add(agenda);
	}

	public ArrayList<Produtos> listarProdutos() {

		return produtos;
	}

	public void cadastrarProduto(Produtos produto) {
		produtos.add(produto);
	}

	public ArrayList<Cidade> listarCidades() {

		return cidades;
	}

	public void cadastrarCidade(Cidade cidade) {
		cidades.add(cidade);
	}

}
