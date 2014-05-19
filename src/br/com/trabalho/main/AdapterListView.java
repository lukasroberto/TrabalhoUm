/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trabalho.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    private List<Vendas> vendas = null;
	private ArrayList<Vendas> arraylist;


    public AdapterListView(Context context, ArrayList<Vendas> itens) {
        //Itens que preencheram o listview
        this.vendas = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
		this.arraylist = new ArrayList<Vendas>();
		this.arraylist.addAll(itens);
    }

    public int getCount() {
        return vendas.size();
    }


    public Vendas getItem(int position) {
        return vendas.get(position);
    }


    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
    	//Vendas item = vendas.get(position);
        view = mInflater.inflate(R.layout.item_listview_vendas, null);

        ((TextView) view.findViewById(R.id.listPrecoVenda)).setText(vendas.get(position).getPrecoVenda().toString());
        ((TextView) view.findViewById(R.id.listQtd)).setText(vendas.get(position).getQtd());
        ((TextView) view.findViewById(R.id.listData)).setText(vendas.get(position).getData().toString());
        ((ImageView) view.findViewById(R.id.imagemview)).setImageResource(R.drawable.venda);

        return view;
    }
    public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		vendas.clear();
		if (charText.length() == 0) {
			vendas.addAll(arraylist);
		} 
		else 
		{
			for (Vendas wp : arraylist) 
			{
				if (wp.getQtd().toLowerCase(Locale.getDefault()).contains(charText)) 
				{
					vendas.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}
}
