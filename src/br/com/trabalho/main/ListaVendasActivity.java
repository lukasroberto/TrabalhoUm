package br.com.trabalho.main;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import br.com.trabalho.dao.VendasDao;
import br.com.trabalho.entidades.Vendas;

import com.example.appandroid.R;

public class ListaVendasActivity extends Activity {

	private ListView list;
	private AdapterListView adapterListView;
	private EditText editsearch;
	private ArrayList<Vendas> vendas = VendasDao.getInstancia().listar();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_vendas);

		list = (ListView) findViewById(R.id.listaVendas);


		// Cria o adapter
		adapterListView = new AdapterListView(this, vendas);

		// Define o Adapter
		list.setAdapter(adapterListView);
		// Cor quando a lista é selecionada para ralagem.
		list.setCacheColorHint(Color.TRANSPARENT);
		

		
		// Locate the EditText in listview_main.xml
		editsearch = (EditText) findViewById(R.id.search);

		// Capture Text in EditText
		editsearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
				adapterListView.filter(text);
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
			}
		});
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