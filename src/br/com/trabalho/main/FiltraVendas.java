package br.com.trabalho.main;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
import br.com.trabalho.dao.VendasDao;

import com.example.appandroid.R;

public class FiltraVendas extends Activity {

	int dia, mes, ano;

	Button dataInicial;
	Button dataFinal;
	private int datePickerInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.filtra_vendas);

		Calendar dataAtual = Calendar.getInstance();
		dia = dataAtual.get(Calendar.DAY_OF_MONTH);
		mes = dataAtual.get(Calendar.MONTH) + 1;
		ano = dataAtual.get(Calendar.YEAR);

		dataInicial = (Button) findViewById(R.id.data_ini);
		dataInicial.setText(dia + "/" + (mes-5) + "/" + ano);

		dataFinal = (Button) findViewById(R.id.data_fim);
		dataFinal.setText(dia + "/" + mes + "/" + ano);

	}

	public void selecionarData(View view) {
		datePickerInput = view.getId (); 
		showDialog(view.getId());
	}

	@Override
	protected Dialog onCreateDialog(int id) {

		OnDateSetListener listener = new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
				switch (datePickerInput) {
				case R.id.data_ini:
					dataInicial.setText(dayOfMonth + "/" + monthOfYear+ "/" + year);
					break;
				case R.id.data_fim:
					dataFinal.setText(dayOfMonth + "/" + monthOfYear+ "/" + year);
					break;
				default:

					break;
				}

			}
		};

		if (R.id.data_ini == id) {

			return new DatePickerDialog(this, listener, ano, mes, dia);
		}
		if (R.id.data_fim == id) {

			return new DatePickerDialog(this, listener, ano, mes+1, dia);
		}

		return null;

	}
	
	public void relatoriografico(View view){
		String dataIni = dataInicial.getText().toString();
		String dataFim = dataFinal.getText().toString();
		
		
	
		VendasDao.getInstancia().filtraListaDeVendas(dataIni, dataFim);		
		Intent irParaGraficoVendas = new Intent(this, GraficoVendas.class);
		startActivity(irParaGraficoVendas);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.filtra_vendas, menu);
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
		case R.id.criarlistaVendas:
			VendasDao.getInstancia().preencheListaDeVendas();
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

}
