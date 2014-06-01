package br.com.trabalho.entidades;

import java.util.ArrayList;

import br.com.trabalho.dao.VendasDao;

public class Cidade {
	private Long id;
	private String nome;
	private String uf;
	
	private ArrayList<Cidade> cidades = VendasDao.getInstancia().listarCidades();
	
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public void listaDeCidades() {

		if (cidades.size() == 0) {
			Cidade cidade1 = new Cidade();
			cidade1.setId(1l);
			cidade1.setUf("SP");
			cidade1.setNome("São joão da Boa Vista");
			VendasDao.getInstancia().cadastrarCidade(cidade1);

			Cidade cidade2 = new Cidade();
			cidade2.setId(2l);
			cidade2.setUf("SP");
			cidade2.setNome("Vargem Grande do Sul");
			VendasDao.getInstancia().cadastrarCidade(cidade2);

			Cidade cidade3 = new Cidade();
			cidade3.setId(3l);
			cidade3.setUf("MG");
			cidade3.setNome("Andradas");
			VendasDao.getInstancia().cadastrarCidade(cidade3);

			Cidade cidade4 = new Cidade();
			cidade4.setId(4l);
			cidade4.setUf("SP");
			cidade4.setNome("São Paulo");
			VendasDao.getInstancia().cadastrarCidade(cidade4);
			
			Cidade cidade5 = new Cidade();
			cidade5.setId(5l);
			cidade5.setUf("SP");
			cidade5.setNome("Aguai");
			VendasDao.getInstancia().cadastrarCidade(cidade5);
			
			Cidade cidade6 = new Cidade();
			cidade6.setId(6l);
			cidade6.setUf("SP");
			cidade6.setNome("Janto Antonio do Jardiim");
			VendasDao.getInstancia().cadastrarCidade(cidade6);
			
			Cidade cidade7 = new Cidade();
			cidade7.setId(7l);
			cidade7.setUf("SP");
			cidade7.setNome("Aguas da Prata");
			VendasDao.getInstancia().cadastrarCidade(cidade7);
			
			Cidade cidade8 = new Cidade();
			cidade8.setId(8l);
			cidade8.setUf("SP");
			cidade8.setNome("Limeira");
			VendasDao.getInstancia().cadastrarCidade(cidade8);
			
			Cidade cidade9 = new Cidade();
			cidade9.setId(9l);
			cidade9.setUf("MG");
			cidade9.setNome("Poços de Caldas");
			VendasDao.getInstancia().cadastrarCidade(cidade9);
		}
	}

}
