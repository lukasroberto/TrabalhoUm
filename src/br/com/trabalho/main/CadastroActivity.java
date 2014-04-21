package br.com.trabalho.main;

import br.com.trabalho.dao.PessoaDao;
import br.com.trabalho.entidades.Pessoa;

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
		ArrayAdapter<String> adapterLocais = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, arrayLocais);

		Spinner locais = (Spinner) findViewById(R.id.local);
		locais.setAdapter(adapterLocais);
		
		String[] arrayLocaisDois = { "Alarme", "Vibrar", "Vibrar e tocar", "Desativado" };
		ArrayAdapter<String> adapterLocaisDois = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, arrayLocaisDois);

		Spinner tipoDeAlerta = (Spinner) findViewById(R.id.tipodealerta);
		tipoDeAlerta.setAdapter(adapterLocaisDois);
		
		
		
	} 
	public void onCadastrarClicked(View view){
	
	Pessoa pessoa = new Pessoa(10l,nome.getText().toString()); 
	PessoaDao.getInstancia().cadastrar(pessoa);
	
	Intent acessarLista = new Intent(this, MainActivity.class); 
	startActivity(acessarLista);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}

}
