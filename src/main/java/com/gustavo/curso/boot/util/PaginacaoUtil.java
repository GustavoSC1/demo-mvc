package com.gustavo.curso.boot.util;

import java.util.List;

public class PaginacaoUtil<T> {

	private int tamanho;
	private int pagina;
	private long totaldePaginas;
	private List<T> registros;
	
	public PaginacaoUtil(int tamanho, int pagina, long totaldePaginas, List<T> registros) {
		super();
		this.tamanho = tamanho;
		this.pagina = pagina;
		this.totaldePaginas = totaldePaginas;
		this.registros = registros;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getPagina() {
		return pagina;
	}

	public long getTotaldePaginas() {
		return totaldePaginas;
	}

	public List<T> getRegistros() {
		return registros;
	}
		
}
