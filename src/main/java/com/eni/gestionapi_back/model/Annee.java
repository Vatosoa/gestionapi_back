package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="annees")
public class Annee {
	
	private long id_annee;
	private String annee_univ;
	
	public Annee() {
		
	}
	
	public Annee(String annee_univ) {
		this.annee_univ = annee_univ;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_annee() {
		return id_annee;
	}

	public void setId_annee(long id_annee) {
		this.id_annee = id_annee;
	}

	@Column(name = "annee_univ", nullable = false)
	public String getAnnee_univ() {
		return annee_univ;
	}

	public void setAnnee_univ(String annee_univ) {
		this.annee_univ = annee_univ;
	}


	@Override
	public String toString() {
		return "Annee [id_annee=" +id_annee+ ", annee_univ=" +annee_univ+ "]";
	}
	
	
}
