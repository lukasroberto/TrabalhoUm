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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.trabalho.entidades.Produtos;

import com.example.appandroid.R;

public class ListaProdutos extends Activity implements OnItemClickListener {

	private ListView listView;
	private ArrayList<Produtos> prod;
	private AdapterListView adapterListViewProdutos;
	Produtos atual = null;
	EditText preco = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_produtos);

		listView = (ListView) findViewById(R.id.listaprodutos);
		listView.setOnItemClickListener(this);

		createListView();
	}

	private void createListView() {

		prod = new ArrayList<Produtos>();
		
		Produtos produto1 = new Produtos();
		produto1.setId(1l);
		produto1.setPrecoUnitario(1.5f);
		produto1.setDescricao("Banana");
		prod.add(produto1);
		
		Produtos produto2 = new Produtos();
		produto2.setId(2l);
		produto2.setPrecoUnitario(1.9f);
		produto2.setDescricao("Morango");
		prod.add(produto2);
		
		Produtos produto3 = new Produtos();
		produto3.setId(3l);
		produto3.setPrecoUnitario(2.5f);
		produto3.setDescricao("Ma�a");
		prod.add(produto3);
		
		Produtos produto4 = new Produtos();
		produto4.setId(4l);
		produto4.setPrecoUnitario(2.2f);
		produto4.setDescricao("Goiaba");
		prod.add(produto4);

		// Cria o adapter
		adapterListViewProdutos = new AdapterListView(this, prod);

		// Define o Adapter
		listView.setAdapter(adapterListViewProdutos);
		// Cor quando a lista é selecionada para ralagem.
		listView.setCacheColorHint(Color.TRANSPARENT);
	}
	
	

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// Pega o item que foi selecionado.
		Produtos prod = adapterListViewProdutos.getItem(arg2);
		// Demostração
		Toast.makeText(this, "Você Clicou em: " + prod.getDescricao() + " " + prod.getId() + " " + prod.getPrecoUnitario(),
		Toast.LENGTH_LONG).show();
		

	}

	public class AdapterListView extends BaseAdapter {

		private LayoutInflater mInflater;
		private ArrayList<Produtos> prod;

		public AdapterListView(Context context, ArrayList<Produtos> prod) {
			// Itens que preencheram o listview
			this.prod = prod;
			// responsavel por pegar o Layout do item.
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
			// infla o layout para podermos preencher os dados
			view = mInflater.inflate(R.layout.item_listview_produtos, null);

			// atravez do layout pego pelo LayoutInflater, pegamos cada id
			// relacionado
			// ao item e definimos as informações.
			((TextView) view.findViewById(R.id.descricao_produtos))
					.setText(item.getDescricao());
			// ((ImageView)
			// view.findViewById(R.id.imagemview)).setImageResource(R.drawable.venda);

			return view;
		}
	}

}