package br.com.trabalho.main;

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
import br.com.trabalho.entidades.Vendas;

import com.example.appandroid.R;

public class ListaVendasActivity extends Activity {

	private ListView list;
	private AdapterListView adapterListView;
	private EditText editsearch;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_vendas);
		list = (ListView) findViewById(R.id.listaVendas);
		
		Vendas vendas = new Vendas();
		adapterListView = new AdapterListView(this,vendas.getVendas());
		list.setAdapter(adapterListView);
		list.setCacheColorHint(Color.TRANSPARENT);
		editsearch = (EditText) findViewById(R.id.search);
		editsearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				String text = editsearch.getText().toString()
						.toLowerCase(Locale.getDefault());
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
		// Quando clicar na lista de vendas
		Vendas item = adapterListView.getItem(arg2);
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
		case R.id.grafico_vendas:
			Intent irParaFiltroVendas = new Intent(this, FiltraVendas.class);
			startActivity(irParaFiltroVendas);
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);

	}

}