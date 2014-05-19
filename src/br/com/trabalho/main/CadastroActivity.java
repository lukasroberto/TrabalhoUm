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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import br.com.trabalho.dao.VendasDao;
import br.com.trabalho.entidades.Produtos;
import br.com.trabalho.entidades.Vendas;

import com.example.appandroid.ListaCidade;
import com.example.appandroid.R;

public class CadastroActivity extends Activity {

	EditText precoVenda;
	EditText data;
	EditText qtd;
	EditText idProduto;
	EditText descricaoProduto;
	EditText precoUnitarioProduto;
	int dia, mes, ano;

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
		dataSelecionada.setText(dia + "/" + mes + "/" + ano);

		this.precoVenda = (EditText) findViewById(R.id.precoVenda);
		this.qtd = (EditText) findViewById(R.id.qtd);
		this.idProduto = (EditText) findViewById(R.id.id_produto);
		this.descricaoProduto = (EditText) findViewById(R.id.descricao_produtos);
		this.precoUnitarioProduto = (EditText) findViewById(R.id.preco_unitario);

		Bundle parametros = getIntent().getExtras();

		if (parametros != null) {

			String tipo = parametros.getString("tipo");
			if (tipo.equals("produto")) {

				String descricaoProduto = parametros
						.getString("descricaoProduto");
				TextView labelDescricao = (TextView) findViewById(R.id.busca_produto);
				labelDescricao.setText(descricaoProduto);

				String idProduto = parametros.getString("idProduto");
				TextView labelidproduto = (TextView) findViewById(R.id.id_produto);
				labelidproduto.setText(idProduto);

				String precoUnProduto = parametros.getString("precoUnitario");
				TextView labelprecoUn = (TextView) findViewById(R.id.preco_unitario);
				labelprecoUn.setText(precoUnProduto);
				// setContentView(textView);

			}
			if (tipo.equals("cidade")) {

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
		}
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
				dataSelecionada.setText(dayOfMonth + "/" + monthOfYear + "/"
						+ year);
			}
		};

		if (R.id.data == id) {

			return new DatePickerDialog(this, listener, ano, mes, dia);
		}

		return null;

	}

	public void buscaProduto(View view) {
		Intent irParaProdutos = new Intent(this, ListaProdutos.class);
		startActivity(irParaProdutos);
	}

	public void buscaCidade(View view) {
		Intent irParaCidades = new Intent(this, ListaCidade.class);
		startActivity(irParaCidades);
	}

	public void cadastrarVenda(View view) {

		Vendas venda = new Vendas();
		venda.setPrecoVenda(Float.parseFloat(precoVenda.getText().toString()));
		venda.setData(dataSelecionada.getText().toString());
		venda.setQtd(qtd.getText().toString());

		//Produtos produtoVendido = new Produtos();
		//produtoVendido.setId(Long.parseLong(idProduto.getText().toString()));
		//produtoVendido.setPrecoUnitario(Float.parseFloat(precoUnitarioProduto.getText().toString()));
		//produtoVendido.setDescricao(descricaoProduto.getText().toString());

		//venda.setProduto(produtoVendido);

		VendasDao.getInstancia().cadastrar(venda);

		Toast.makeText(this, "preco "+venda.getPrecoVenda() + "data "+venda.getData()+"qtd "+venda.getQtd(), Toast.LENGTH_LONG)
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
