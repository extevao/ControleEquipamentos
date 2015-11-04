package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Requisito implements Serializable {

	private static final long serialVersionUID = -3825006979098572199L;
	private String id;
	private String processador;
	private String frequencia;
	private String numeroNucleos;
	private String memoria;
	private String hd;
	private String video;

	public Requisito() {

	}

	public Requisito(String id, String processador, String frequencia, String numeroNucleos, String memoria, String hd,
			String video) {
		super();
		this.id = id;
		this.processador = processador;
		this.frequencia = frequencia;
		this.numeroNucleos = numeroNucleos;
		this.memoria = memoria;
		this.hd = hd;
		this.video = video;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public String getNumeroNucleos() {
		return numeroNucleos;
	}

	public void setNumeroNucleos(String numeroNucleos) {
		this.numeroNucleos = numeroNucleos;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

}
