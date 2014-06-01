package br.com.trabalho.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.example.appandroid.R;

import android.net.ParseException;
import android.widget.Button;
import android.widget.Toast;
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

	public List<RowGoogleChart> listarVendasGrafico() {

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

	public void filtraListaDeVendas(String dataIni, String dataFim) {
		
		if(vendas.isEmpty()){
			preencheListaDeVendas();
		}

		dataFim = dataFim.toString();
		dataIni = dataIni.toString();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal1 = Calendar.getInstance();
		try {
			cal1.setTime(sdf.parse(dataIni));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal2 = Calendar.getInstance();
		try {
			cal2.setTime(sdf.parse(dataFim));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int cont = 0; cont < vendas.size(); cont++) {
			if ((vendas.get(cont).getDataCalendar().before(cal1))
					|| (vendas.get(cont).getDataCalendar().after(cal2))) {
				
			} else {
				graficoVendas.add(vendas.get(cont));
			}
		}
	}

	public void preencheListaDeVendas() {

		Cidade cidade = new Cidade();
		listaDeCidades();

		Produtos prod = new Produtos();
		criaListaDeProdutos();

		Random gerar = new Random();
		Long id = (long) 0;

		for (int i = 0; i < 12; i++) {
			id = id + 1;
			int idProduto = gerar.nextInt(9);
			int idCidade = gerar.nextInt(9);
			Float precoUnicatio = (prod.getProd().get(idProduto)
					.getPrecoUnitario());
			String qtdVenda = gerar.nextInt(20) + "";
			Float precoVenda = precoUnicatio * Integer.parseInt(qtdVenda);

			Vendas venda = new Vendas();
			venda.setId(id);
			venda.setCidade(cidade.getCidades().get(idCidade));
			venda.setProduto(prod.getProd().get(idProduto));
			venda.setQtd(qtdVenda);
			venda.setPrecoVenda(precoVenda);

			try {
				String data = gerar.nextInt(31) + "/" + id + "/2014";
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

			cadastrar(venda);
			// graficoVendas.add(venda);

		}

	}

	public void criaListaDeProdutos() {

		if (produtos.size() == 0) {
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

	public void listaDeCidades() {

		if (cidades.size() == 0) {
			Cidade cidade1 = new Cidade();
			cidade1.setId(1l);
			cidade1.setUf("SP");
			cidade1.setNome("São joão da Boa Vista");
			VendasDao.getInstancia().cadastrarCidade(cidade1);

			Cidade cidade2 = new Cidade();
			cidade2.setId(2l);
			cidade2.setUf("SP");
			cidade2.setNome("Vargem Grande do Sul");
			VendasDao.getInstancia().cadastrarCidade(cidade2);

			Cidade cidade3 = new Cidade();
			cidade3.setId(3l);
			cidade3.setUf("MG");
			cidade3.setNome("Andradas");
			VendasDao.getInstancia().cadastrarCidade(cidade3);

			Cidade cidade4 = new Cidade();
			cidade4.setId(4l);
			cidade4.setUf("SP");
			cidade4.setNome("São Paulo");
			VendasDao.getInstancia().cadastrarCidade(cidade4);

			Cidade cidade5 = new Cidade();
			cidade5.setId(5l);
			cidade5.setUf("SP");
			cidade5.setNome("Aguai");
			VendasDao.getInstancia().cadastrarCidade(cidade5);

			Cidade cidade6 = new Cidade();
			cidade6.setId(6l);
			cidade6.setUf("SP");
			cidade6.setNome("Janto Antonio do Jardiim");
			VendasDao.getInstancia().cadastrarCidade(cidade6);

			Cidade cidade7 = new Cidade();
			cidade7.setId(7l);
			cidade7.setUf("SP");
			cidade7.setNome("Aguas da Prata");
			VendasDao.getInstancia().cadastrarCidade(cidade7);

			Cidade cidade8 = new Cidade();
			cidade8.setId(8l);
			cidade8.setUf("SP");
			cidade8.setNome("Limeira");
			VendasDao.getInstancia().cadastrarCidade(cidade8);

			Cidade cidade9 = new Cidade();
			cidade9.setId(9l);
			cidade9.setUf("MG");
			cidade9.setNome("Poços de Caldas");
			VendasDao.getInstancia().cadastrarCidade(cidade9);
		}
	}
}
