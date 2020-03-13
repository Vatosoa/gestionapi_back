package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="niveaux")
public class Niveau {
	
	private long id_niveau;
	private String niveau_nom;
	
	public Niveau() {
		
	}
	
	public Niveau(String niveau_nom) {
		this.niveau_nom = niveau_nom;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_niveau() {
		return id_niveau;
	}

	public void setId_niveau(long id_niveau) {
		this.id_niveau = id_niveau;
	}

	@Column(name = "niveau_nom", nullable = false)
	public String getNiveau_nom() {
		return niveau_nom;
	}

	public void setNiveau_nom(String niveau_nom) {
		this.niveau_nom = niveau_nom;
	}

	
	@Override
	public String toString() {
		return "Niveau [id_niveau=" +id_niveau+ ", niveau_nom=" +niveau_nom+ "]";
	}
	
	
}
