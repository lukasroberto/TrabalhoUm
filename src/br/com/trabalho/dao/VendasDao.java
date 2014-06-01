package br.com.trabalho.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import android.net.ParseException;
import br.com.trabalho.entidades.Cidade;
import br.com.trabalho.entidades.Produtos;
import br.com.trabalho.entidades.Vendas;
import br.com.trabalho.main.RowGoogleChart;

public class VendasDao {
	private static VendasDao instancia;
	private static ArrayList<Vendas> vendas = new ArrayList<Vendas>();
	private static ArrayList<Produtos> produtos = new ArrayList<Produtos>();
	private static ArrayList<Cidade> cidades = new ArrayList<Cidade>();
	private static List<RowGoogleChart> graficoVendas = new ArrayList<RowGoogleChart>();

	private VendasDao() {

	}
	
	
	
	public List<RowGoogleChart> listarVendasGrafico(){
		


		return graficoVendas;
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

	public void cadastrar(Vendas venda) {
		vendas.add(venda);
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

	public void preencheListaDeVendas() {

		Cidade cidade = new Cidade();
		cidade.listaDeCidades();

		Produtos prod = new Produtos();
		prod.listDeProdutos();

		Random gerar = new Random();
		Long id = (long) 0;

		for (int i = 0; i < 10; i++) {

			Vendas venda = new Vendas();
			venda.setId(id);

			try {
				String data = gerar.nextInt(31) + "/5/2014";
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(sdf.parse(data));
				venda.setData(cal);

			} catch (ParseException e) {
				e.printStackTrace();
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// venda.setData(data);
			venda.setQtd(gerar.nextInt(20) + "");
			venda.setPrecoVenda(100f);

			venda.setCidade(cidade.getCidades().get(gerar.nextInt(9)));
			venda.setProduto(prod.getProd().get(gerar.nextInt(9)));
			cadastrar(venda);
			
graficoVendas.add(venda);
			

		}

	}
}
	
