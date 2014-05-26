package br.com.trabalho.main;

import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import br.com.trabalho.dao.VendasDao;
import br.com.trabalho.entidades.Vendas;

import com.example.appandroid.R;

public class CadastroActivity extends Activity {

	EditText precoVenda;
	EditText qtd;
	EditText idProduto;
	Button descricaoProduto;
	EditText precoUnitarioProduto;
	EditText idCidade;
	Button nomeCidade;
	EditText ufCidade;
	int dia, mes, ano;

	Button dataSelecionada;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_activity);

		Calendar dataAtual = Calendar.getInstance();
		dia = dataAtual.get(Calendar.DAY_OF_MONTH);
		mes = dataAtual.get(Calendar.MONTH) + 1;
		ano = dataAtual.get(Calendar.YEAR);

		dataSelecionada = (Button) findViewById(R.id.data);
		dataSelecionada.setText(dia + "/" + mes + "/" + ano);

		this.precoVenda = (EditText) findViewById(R.id.precoVenda);
		this.qtd = (EditText) findViewById(R.id.qtd);
		this.idProduto = (EditText) findViewById(R.id.id_produto);
		this.descricaoProduto = (Button) findViewById(R.id.busca_produto);
		this.precoUnitarioProduto = (EditText) findViewById(R.id.preco_unitario);
		this.idCidade = (EditText) findViewById(R.id.id_cidade);
		this.nomeCidade = (Button) findViewById(R.id.busca_cidade);
		this.ufCidade = (EditText) findViewById(R.id.uf_cidade);

		Bundle parametros = getIntent().getExtras();

		if (parametros != null) {

			String descricaoProduto = parametros.getString("descricaoProduto");
			TextView labelDescricao = (TextView) findViewById(R.id.busca_produto);
			labelDescricao.setText(descricaoProduto);

			String idProduto = parametros.getString("idProduto");
			TextView labelidproduto = (TextView) findViewById(R.id.id_produto);
			labelidproduto.setText(idProduto);

			String precoUnProduto = parametros.getString("precoUnitario");
			TextView labelprecoUn = (TextView) findViewById(R.id.preco_unitario);
			labelprecoUn.setText(precoUnProduto);

			String qtd = parametros.getString("qtd");
			TextView labelqtd = (TextView) findViewById(R.id.qtd);
			labelqtd.setText(qtd);

			String data = parametros.getString("data");
			TextView labeldata = (TextView) findViewById(R.id.data);
			labeldata.setText(data);
			// setContentView(textView);

			String nomeCidade = parametros.getString("nomeCidade");
			TextView lbelNomeCidade = (TextView) findViewById(R.id.busca_cidade);
			lbelNomeCidade.setText(nomeCidade);

			String idCidade = parametros.getString("idCidade");
			TextView labelIdCidade = (TextView) findViewById(R.id.id_cidade);
			labelIdCidade.setText(idCidade);

			String ufCidade = parametros.getString("ufCidade");
			TextView labelUfCidade = (TextView) findViewById(R.id.uf_cidade);
			labelUfCidade.setText(ufCidade);
			// setContentView(textView);

		}
		


		qtd.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
				if (precoUnitarioProduto.getText().toString().equals("")) {
					selecioneProduto();
				}else{
					int quantidade = Integer.parseInt(qtd.getText().toString());
					valorTotalVenda(quantidade);		
				}
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

	public void selecioneProduto() {
		Toast.makeText(this, "Selecione um produto antes!", Toast.LENGTH_LONG).show();	
		TextView qtd = (TextView) findViewById(R.id.qtd);
		qtd.setText("");
	}
	public void valorTotalVenda(int qtd) {		
		Float totalVenda = Float.parseFloat(precoUnitarioProduto.getText().toString()) * qtd;
		
		TextView precoVenda = (TextView) findViewById(R.id.precoVenda);
		precoVenda.setText("R$"+totalVenda.toString());
	}
	


	public void selecionarData(View view) {

		showDialog(view.getId());
	}

	@Override
	protected Dialog onCreateDialog(int id) {

		OnDateSetListener listener = new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				dataSelecionada.setText(dayOfMonth + "/" + (monthOfYear + 1)
						+ "/" + year);
			}
		};

		if (R.id.data == id) {

			return new DatePickerDialog(this, listener, ano, mes, dia);
		}

		return null;

	}

	public void buscaProduto(View view) {
		Intent irParaProdutos = new Intent(this, ListaProdutos.class);

		Bundle parametros = new Bundle();
		parametros.putString("idCidade", idCidade.getText().toString());
		parametros.putString("nomeCidade", nomeCidade.getText().toString());
		parametros.putString("ufCidade", ufCidade.getText().toString());
		parametros.putString("qtd", qtd.getText().toString());
		parametros.putString("precoUnitario", precoUnitarioProduto.getText()
				.toString());
		parametros.putString("data", dataSelecionada.getText().toString());

		irParaProdutos.putExtras(parametros);

		startActivity(irParaProdutos);
	}

	public void buscaCidade(View view) {
		Intent irParaCidades = new Intent(this, ListaCidade.class);

		Bundle parametros = new Bundle();
		parametros.putString("idProduto", idProduto.getText().toString());
		parametros.putString("descricaoProduto", descricaoProduto.getText()
				.toString());
		parametros.putString("qtd", qtd.getText().toString());
		parametros.putString("precoUnitario", precoUnitarioProduto.getText()
				.toString());
		parametros.putString("data", dataSelecionada.getText().toString());

		irParaCidades.putExtras(parametros);

		startActivity(irParaCidades);
	}

	public void cadastrarVenda(View view) {

		Vendas venda = new Vendas();
		venda.setPrecoVenda(Float.parseFloat(precoVenda.getText().toString()));
		venda.setData(dataSelecionada.getText().toString());
		venda.setQtd(qtd.getText().toString());

		// Produtos produtoVendido = new Produtos();
		// produtoVendido.setId(Long.parseLong(idProduto.getText().toString()));
		// produtoVendido.setPrecoUnitario(Float.parseFloat(precoUnitarioProduto.getText().toString()));
		// produtoVendido.setDescricao(descricaoProduto.getText().toString());

		// venda.setProduto(produtoVendido);

		VendasDao.getInstancia().cadastrar(venda);

		Toast.makeText(this, "Venda Cadastrada com sucesso!", Toast.LENGTH_LONG)
				.show();

		// Vendas agenda = new Vendas(precoVenda.getText().toString(),
		// data.getText().toString());
		// VendasDao.getInstancia().cadastrar(agenda);

		// Intent acessarLista = new Intent(this, MainActivity.class);
		// startActivity(acessarLista);
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
