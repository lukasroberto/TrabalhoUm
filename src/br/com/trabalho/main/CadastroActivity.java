package br.com.trabalho.main;

import br.com.trabalho.dao.AgendaDao;
import br.com.trabalho.entidades.Agenda;

import com.example.appandroid.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class CadastroActivity extends Activity {

	EditText nome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_activity);
		this.nome = (EditText) findViewById(R.id.nome);

		String[] arrayLocais = { "Minha casa", "Facul", "Chacara Bentivi" };
		spinner(arrayLocais, (Spinner) findViewById(R.id.local));

		String[] arrayLocaisDois = { "Alarme", "Vibrar", "Vibrar e tocar",
				"Desativado" };
		spinner(arrayLocaisDois, (Spinner) findViewById(R.id.tipodealerta));

	}

	public void spinner(String[] dados, Spinner spinner) {

		ArrayAdapter<String> adapterLocais = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dados);

		spinner.setAdapter(adapterLocais);

	}

	public void onCadastrarClicked(View view) {

		Agenda agenda = new Agenda(10l, nome.getText().toString());
		AgendaDao.getInstancia().cadastrar(agenda);

		Intent acessarLista = new Intent(this, MainActivity.class);
		startActivity(acessarLista);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}

}
