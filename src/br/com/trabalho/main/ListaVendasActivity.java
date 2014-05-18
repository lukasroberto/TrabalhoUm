package br.com.trabalho.main;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import br.com.trabalho.dao.VendasDao;
import br.com.trabalho.entidades.Vendas;

import com.example.appandroid.R;

	public class ListaVendasActivity extends Activity {
		List<Vendas> vendas = VendasDao.getInstancia().listar();

		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.lista_vendas);
			
			//Bundle parametros = getIntent().getExtras();
			//String evento = parametros.getString("precoVenda");

			//TextView labelNome = (TextView) findViewById(R.id.precoVenda);
			//labelNome.setText(evento);
			

			ArrayAdapter<Vendas> adapter = new ArrayAdapter<Vendas>(this,
			android.R.layout.simple_list_item_1, vendas);
			ListView listView = (ListView) findViewById(R.id.listaVendas);
			listView.setAdapter(adapter);

		}
	
		
		
		
		
		
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View linha = convertView;
			ArmazenadorRestaurante armazenador = null;
			
			if (linha == null) {
				LayoutInflater inflater = getLayoutInflater();
				linha = inflater.inflate(R.layout.lista_vendas, parent, false);
				armazenador = new ArmazenadorRestaurante(linha);
				linha.setTag(armazenador);
			} else {
				armazenador = (ArmazenadorRestaurante) linha.getTag();
			}
			
			armazenador.popularFormulario(vendas.get(position));
			
			return linha;
		}
		
		static class ArmazenadorRestaurante {
			private TextView nome = null;
			private TextView endereco = null;
			private ImageView icone = null;
			
			ArmazenadorRestaurante(View linha) {
				nome = (TextView) linha.findViewById(R.id.precoVenda);
				endereco = (TextView) linha.findViewById(R.id.qtd);
			}
		
		void popularFormulario(Vendas r) {
			nome.setText(r.getPrecoVenda().toString());
			endereco.setText(r.getQtd());
		
		}
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