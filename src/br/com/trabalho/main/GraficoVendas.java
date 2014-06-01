package br.com.trabalho.main;

import java.util.List;

import br.com.trabalho.dao.VendasDao;

import com.example.appandroid.R;
import com.example.appandroid.R.id;
import com.example.appandroid.R.layout;
import com.example.appandroid.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class GraficoVendas extends Activity {
	
	WebView webview;
    String strURL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grafico_vendas);
		
		List<RowGoogleChart> dados = VendasDao.getInstancia().listarVendasGrafico();
				
		Grafico grafico = new Grafico(DadosGrafico.CABECALHO, dados, DadosGrafico.RODAPE);		
		String conteudo = grafico.plotar();
		
		webview = (WebView) findViewById(R.id.wvGrafico);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.requestFocusFromTouch();
        webview.loadDataWithBaseURL( "file:///android_asset/", conteudo, "text/html", "utf-8", null );
	        	 
	        
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

