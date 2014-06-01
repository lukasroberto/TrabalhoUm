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
import br.com.trabalho.entidades.Produtos;

import com.example.appandroid.R;

public class ListaProdutos extends Activity implements OnItemClickListener {

	private ListView listView;
	private AdapterListView adapterListViewProdutos;
	private String nomeCidade;
	private String idCidade;
	private String ufCidade;
	private String data;
	private String qtd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_produtos);

		listView = (ListView) findViewById(R.id.listaprodutos);
		listView.setOnItemClickListener(this);

		Bundle parametros = getIntent().getExtras();

		if (parametros != null) {

			idCidade = parametros.getString("idCidade");
			nomeCidade = parametros.getString("nomeCidade");
			ufCidade = parametros.getString("ufCidade");
			data = parametros.getString("data");
			qtd = parametros.getString("qtd");
		}

		createListView();
	}

	private void createListView() {

		Produtos prod = new Produtos();
		VendasDao.getInstancia().criaListaDeProdutos();

		adapterListViewProdutos = new AdapterListView(this, prod.getProd());
		listView.setAdapter(adapterListViewProdutos);
		listView.setCacheColorHint(Color.TRANSPARENT);
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// Pega o item que foi selecionado.
		Produtos prod = adapterListViewProdutos.getItem(arg2);

		Intent intent = new Intent(this, CadastroActivity.class);

		Bundle parametros = new Bundle();
		parametros.putString("descricaoProduto", prod.getDescricao().toString());
		parametros.putString("precoUnitario", prod.getPrecoUnitario().toString());
		parametros.putString("idProduto", prod.getId().toString());
		parametros.putString("idCidade", idCidade);
		parametros.putString("nomeCidade", nomeCidade);
		parametros.putString("ufCidade", ufCidade);
		parametros.putString("data", data);
		parametros.putString("qtd", qtd);

		intent.putExtras(parametros);
		startActivity(intent);

	}

	public class AdapterListView extends BaseAdapter {

		private LayoutInflater mInflater;
		private ArrayList<Produtos> prod;

		public AdapterListView(Context context, ArrayList<Produtos> prod) {
			// Itens que preencheram o listview
			this.prod = prod;
			mInflater = LayoutInflater.from(context);
		}

		/**
		 * Retorna a quantidade de itens
		 * 
		 * @return
		 */
		public int getCount() {
			return prod.size();
		}

		/**
		 * Retorna o item de acordo com a posicao dele na tela.
		 * 
		 * @param position
		 * @return
		 */
		public Produtos getItem(int position) {
			return prod.get(position);
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
			Produtos item = prod.get(position);
			view = mInflater.inflate(R.layout.item_listview_produtos, null);
			// atravez do layout pego pelo LayoutInflater, pegamos cada id
			((TextView) view.findViewById(R.id.descricao_produtos))
					.setText(item.getDescricao());
			return view;
		}
	}

}