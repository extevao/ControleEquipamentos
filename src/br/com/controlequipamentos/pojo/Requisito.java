package br.com.controlequipamentos.pojo;

import java.io.Serializable;

public class Requisito implements Serializable{

	private static final long serialVersionUID = -3825006979098572199L;
	private int id;
	private String processador;
	private String memoriaram;
	private String hd;
	private String video;
	
	public Requisito(){
		
	}
		
	public Requisito(int id, String processador, String memoriaram, String hd, String video) {
		super();
		this.id = id;
		this.processador = processador;
		this.memoriaram = memoriaram;
		this.hd = hd;
		this.video = video;
	}

	@Override
	public String toString() {
		return "Requisito [id=" + id + ", processador=" + processador + ", memoriaram=" + memoriaram + ", hd=" + hd
				+ ", video=" + video + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public String getMemoriaram() {
		return memoriaram;
	}
	public void setMemoriaram(String memoriaram) {
		this.memoriaram = memoriaram;
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
