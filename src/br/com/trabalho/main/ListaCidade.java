package br.com.trabalho.main;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import br.com.trabalho.dao.VendasDao;
import br.com.trabalho.entidades.Cidade;

import com.example.appandroid.R;

public class ListaCidade extends Activity implements OnItemClickListener {

	private ListView listView;
	private ArrayList<Cidade> cidades = VendasDao.getInstancia()
			.listarCidades();
	private AdapterListView adapterListViewCidades;
	
	private String data;
	private String qtd;
	private String idProduto;
	private String descricaoProduto;
	private String precoUnitario;
	private String totalVenda;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_cidade);

		listView = (ListView) findViewById(R.id.lista_cidades);
		listView.setOnItemClickListener(this);
		
		
		Bundle parametros = getIntent().getExtras();

		if (parametros != null) {

			idProduto = parametros.getString("idProduto");
			descricaoProduto = parametros.getString("descricaoProduto");
			precoUnitario = parametros.getString("precoUnitario");
			totalVenda = parametros.getString("totalVenda");
			data = parametros.getString("data");
			qtd = parametros.getString("qtd");

			
			//precoTotal = Float.parseFloat(precoUnitario)* Integer.parseInt(qtd);

	}

		createListView();
	}

	private void createListView() {

		if (cidades.size() == 0) {
			Cidade cidade1 = new Cidade();
			cidade1.setId(1l);
			cidade1.setUf("SP");
			cidade1.setNome("S�o jo�o da Boa Vista");
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
			cidade4.setNome("Aguai");
			VendasDao.getInstancia().cadastrarCidade(cidade4);
		}

		// Cria o adapter
		adapterListViewCidades = new AdapterListView(this, cidades);

		// Define o Adapter
		listView.setAdapter(adapterListViewCidades);
		// Cor quando a lista é selecionada para ralagem.
		listView.setCacheColorHint(Color.TRANSPARENT);
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// Pega o item que foi selecionado.
		Cidade cidade = adapterListViewCidades.getItem(arg2);
		// Demostração
		// Toast.makeText(this, "Você Clicou em: " + prod.getDescricao() + " "
		// + prod.getId() + " " + prod.getPrecoUnitario(),
		// Toast.LENGTH_LONG).show();
		
		
		Intent intent = new Intent(this, CadastroActivity.class);
		
	Bundle parametros = new Bundle();
	parametros.putString("idCidade", cidade.getId().toString());
	parametros.putString("nomeCidade", cidade.getNome().toString());
	parametros.putString("ufCidade", cidade.getUf().toString());
	
	parametros.putString("idProduto", idProduto);
	parametros.putString("descricaoProduto", descricaoProduto);
	parametros.putString("precoUnitario", precoUnitario);
	parametros.putString("data", data);
	parametros.putString("totalVenda", totalVenda);
	parametros.putString("qtd", qtd);


	intent.putExtras(parametros);
	startActivity(intent);
	}

	public class AdapterListView extends BaseAdapter {

		private LayoutInflater mInflater;
		private ArrayList<Cidade> cidades;

		public AdapterListView(Context context, ArrayList<Cidade> cidade) {
			// Itens que preencheram o listview
			this.cidades = cidade;
			// responsavel por pegar o Layout do item.
			mInflater = LayoutInflater.from(context);
		}

		/**
		 * Retorna a quantidade de itens
		 * 
		 * @return
		 */
		public int getCount() {
			return cidades.size();
		}

		/**
		 * Retorna o item de acordo com a posicao dele na tela.
		 * 
		 * @param position
		 * @return
		 */
		public Cidade getItem(int position) {
			return cidades.get(position);
		}

		/**
		 * Sem implementação
		 * 
		 * @param position
		 * @return
		 */
		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View view, ViewGroup parent) {
			// Pega o item de acordo com a posção.
			Cidade cidade = cidades.get(position);
			// infla o layout para podermos preencher os dados
			view = mInflater.inflate(R.layout.item_listview_cidade, null);

			// atravez do layout pego pelo LayoutInflater, pegamos cada id
			// relacionado
			// ao item e definimos as informações.
			((TextView) view.findViewById(R.id.nome_cidade)).setText(cidade
					.getNome());
			// ((ImageView)
			// view.findViewById(R.id.imagemview)).setImageResource(R.drawable.venda);

			return view;
		}
	}

}