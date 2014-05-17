package br.com.trabalho.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appandroid.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Bundle parametros = getIntent().getExtras();
		String evento = parametros.getString("nome");

		TextView labelNome = (TextView) findViewById(R.id.teste);
		labelNome.setText(evento);

		// List<Agenda> agendas = AgendaDao.getInstancia().listar();

		// ArrayAdapter<Agenda> adapter = new ArrayAdapter<Agenda>(this,
		// android.R.layout.simple_list_item_1, agendas);
		// ListView listView = (ListView) findViewById(R.id.lista);
		// listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

}
