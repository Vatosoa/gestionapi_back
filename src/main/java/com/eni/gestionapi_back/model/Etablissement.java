package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etablissements")
public class Etablissement {
	
	private long id_etabli;
	private String etabli_nom;
	private String etabli_adr;
	private String etabli_code_post;
	
	public Etablissement() {
		
	}
	
	public Etablissement(String etabli_nom, String etabli_adr, String etabli_code_post) {
		this.etabli_nom = etabli_nom;
		this.etabli_adr = etabli_adr;
		this.etabli_code_post = etabli_code_post;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_etabli() {
		return id_etabli;
	}

	public void setId_etabli(long id_etabli) {
		this.id_etabli = id_etabli;
	}

	@Column(name = "etabli_nom", nullable = false)
	public String getEtabli_nom() {
		return etabli_nom;
	}

	public void setEtabli_nom(String etabli_nom) {
		this.etabli_nom = etabli_nom;
	}

	@Column(name = "etabli_adr", nullable = false)
	public String getEtabli_adr() {
		return etabli_adr;
	}

	public void setEtabli_adr(String etabli_adr) {
		this.etabli_adr = etabli_adr;
	}

	@Column(name = "etabli_code_post", nullable = false)
	public String getEtabli_code_post() {
		return etabli_code_post;
	}

	public void setEtabli_code_post(String etabli_code_post) {
		this.etabli_code_post = etabli_code_post;
	}

	
	@Override
	public String toString() {
		return "Annee [id_etabli=" +id_etabli+ ", etabli_nom=" +etabli_nom+ ", etabli_adr=" +etabli_adr+ ", etabli_code_post=" +etabli_code_post+ "]";
	}
	
	
}
