package br.com.trabalho.controller;

public enum DadosGrafico {

	CABECALHO(
			"<html>"
	                + "  <head>"
	                + "    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>"
	                + "    <script type=\"text/javascript\">"
	                + "      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
	                + "      google.setOnLoadCallback(drawChart);"
	                + "      function drawChart() {"
	                + "        var data = google.visualization.arrayToDataTable([['Mes-Ano', 'Vendas'],"
			),	
	RODAPE(
			"        ]);"
	                + "        var options = {"
	                + "          title: 'Vendas de 2014',"
	                + "          hAxis: {title: 'Mês/Ano', titleTextStyle: {color: 'red'}}"
	                + "        };"
	                + "        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));"
	                + "        chart.draw(data, options);"
	                + "      }"
	                + "    </script>"
	                + "  </head>"
	                + "  <body>"
	                + "    <div id=\"chart_div\" style=\"width: 100%; height: 100%;\"></div>"                
	                + "  </body>" + "</html>"
			);
	
	private String conteudo;

	private DadosGrafico(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getConteudo() {
		return conteudo;
	}
	
	
}
