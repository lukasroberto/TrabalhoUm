package br.com.trabalho.main;

import java.util.ArrayList;
import java.util.List;

import br.com.trabalho.dao.AgendaDao;
import br.com.trabalho.entidades.Agenda;

import com.example.appandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);



		List<Agenda> pessoas = AgendaDao.getInstancia().listarAgenda();

		ArrayAdapter<Agenda> adapter = new ArrayAdapter<Agenda>(this,
				android.R.layout.simple_list_item_1, pessoas);
		ListView listView = (ListView) findViewById(R.id.listaEvento);
		listView.setAdapter(adapter);

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
