package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parcours")
public class Parcours {
	
	private long id_parcours;
	private String parcours_nom;
	
	public Parcours() {
		
	}
	
	public Parcours(String parcours_nom) {
		this.parcours_nom = parcours_nom;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_parcours() {
		return id_parcours;
	}

	public void setId_parcours(long id_parcours) {
		this.id_parcours = id_parcours;
	}
	
	@Column(name = "parcours_nom", nullable = false)
	public String getParcours_nom() {
		return parcours_nom;
	}

	public void setParcours_nom(String parcours_nom) {
		this.parcours_nom = parcours_nom;
	}


	@Override
	public String toString() {
		return "Parcours [id_parcours=" +id_parcours+ ", parcours_nom=" +parcours_nom+ "]";
	}
	
	
}
