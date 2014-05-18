package br.com.trabalho.main;

import java.util.Calendar;

import junit.framework.Protectable;

import br.com.trabalho.dao.VendasDao;
import br.com.trabalho.entidades.Vendas;

import com.example.appandroid.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroActivity extends Activity {

	EditText precoVenda;
	EditText data;
	EditText qtd;
	int dia,mes,ano;
	
	Button dataSelecionada;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_activity);
		
		Calendar dataAtual = Calendar.getInstance();
		dia = dataAtual.get(Calendar.DAY_OF_MONTH);
		mes = dataAtual.get(Calendar.MONTH);
		ano = dataAtual.get(Calendar.YEAR);
		
		dataSelecionada = (Button) findViewById(R.id.data);
		dataSelecionada.setText(dia+"/"+mes+"/"+ano);
		
		this.precoVenda = (EditText) findViewById(R.id.precoVenda);
		this.qtd = (EditText) findViewById(R.id.qtd);

		String[] arrayLocais = { "Minha casa", "Facul", "Chacara Bentivi" };
		spinner(arrayLocais, (Spinner) findViewById(R.id.local));

		String[] arrayLocaisDois = { "Alarme", "Vibrar", "Alarme e Vibrar" };
		spinner(arrayLocaisDois, (Spinner) findViewById(R.id.tipodealerta));

	}

	public void selecionarData(View view){
		
		showDialog(view.getId());
	}
@Override	
protected Dialog onCreateDialog(int id){
	
	OnDateSetListener listener = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			dataSelecionada.setText(dayOfMonth+"/"+monthOfYear+"/"+year);		
		}
	};
	
	if (R.id.data == id) {
		
		return new DatePickerDialog(this, listener, ano, mes, dia);
	}
	
	return null;	
	
}
	
	
	public void spinner(String[] dados, Spinner spinner) {

		ArrayAdapter<String> adapterLocais = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dados);

		spinner.setAdapter(adapterLocais);

	}
	
	public void passarParametro(View view){
		
		Intent intent = new Intent(this, ListaVendasActivity.class);
		Bundle parametros = new Bundle();
		parametros.putString("precoVenda", precoVenda.getText().toString());
		intent.putExtras(parametros);
		startActivity(intent);
		
	}
	
	public void buscaProduto(View view) {
		Intent irParaCadastro = new Intent(this, ListaProdutos.class);
		startActivity(irParaCadastro);		
	}

	public void cadastrarVenda(View view) {
		
		Vendas venda = new Vendas();
		venda.setPrecoVenda(Float.parseFloat(precoVenda.getText().toString()));
		venda.setData(dataSelecionada.getText().toString());
		venda.setQtd(qtd.getText().toString());
		
		VendasDao.getInstancia().cadastrar(venda);
		
		Toast.makeText(this, "Venda Cadastrada com sucesso", Toast.LENGTH_LONG).show();
		

		//Vendas agenda = new Vendas(precoVenda.getText().toString(), data.getText().toString());
		//VendasDao.getInstancia().cadastrar(agenda);

		//Intent acessarLista = new Intent(this, MainActivity.class);
		//startActivity(acessarLista);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cadastro, menu);
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
