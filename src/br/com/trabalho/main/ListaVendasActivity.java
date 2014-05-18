package br.com.trabalho.main;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import br.com.trabalho.dao.VendasDao;
import br.com.trabalho.entidades.Vendas;

import com.example.appandroid.R;

public class ListaVendasActivity extends Activity {

	private ListView listView;
	private AdapterListView adapterListView;
	private ArrayList<Vendas> vendas = VendasDao.getInstancia().listar();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_vendas);

		listView = (ListView) findViewById(R.id.listaVendas);
		createListView();
	}

	private void createListView() {
		// Cria o adapter
		adapterListView = new AdapterListView(this, vendas);

		// Define o Adapter
		listView.setAdapter(adapterListView);
		// Cor quando a lista é selecionada para ralagem.
		listView.setCacheColorHint(Color.TRANSPARENT);
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// Pega o item que foi selecionado.
		Vendas item = adapterListView.getItem(arg2);
		// Demostração
		// Toast.makeText(this, "Você Clicou em: " + item.getTexto(),
		// Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lista_vendas, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();

		switch (id) {
		case R.id.novo:
			Intent irParaCadastro = new Intent(this, CadastroActivity.class);
			startActivity(irParaCadastro);
			break;
		case R.id.lista:
			Intent irParaLista = new Intent(this, ListaVendasActivity.class);
			startActivity(irParaLista);
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);

	}

}