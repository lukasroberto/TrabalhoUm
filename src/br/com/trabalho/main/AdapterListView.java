/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trabalho.main;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.trabalho.entidades.Vendas;

import com.example.appandroid.R;


/**
 *
 * @author guilherme
 */
public class AdapterListView extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<Vendas> venads;

    public AdapterListView(Context context, ArrayList<Vendas> itens) {
        //Itens que preencheram o listview
        this.venads = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount() {
        return venads.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public Vendas getItem(int position) {
        return venads.get(position);
    }

    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        //Pega o item de acordo com a posção.
    	Vendas item = venads.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_listview_vendas, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(R.id.text)).setText(item.getQtd());
        ((ImageView) view.findViewById(R.id.imagemview)).setImageResource(R.drawable.venda);

        return view;
    }
}
