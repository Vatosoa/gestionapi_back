package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jurys")
public class Jury {
	
	private long id_jury;
	private String jury_nom;
	private String jury_prenom;
	private String jury_role;
	
	public Jury() {
		
	}
	
	public Jury(String jury_nom, String jury_prenom, String jury_role) {
		this.jury_nom = jury_nom;
		this.jury_prenom = jury_prenom;
		this.jury_role = jury_role;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_jury() {
		return id_jury;
	}

	public void setId_jury(long id_jury) {
		this.id_jury = id_jury;
	}

	@Column(name = "jury_nom", nullable = false)
	public String getJury_nom() {
		return jury_nom;
	}

	public void setJury_nom(String jury_nom) {
		this.jury_nom = jury_nom;
	}

	@Column(name = "jury_prenom", nullable = false)
	public String getJury_prenom() {
		return jury_prenom;
	}

	public void setJury_prenom(String jury_prenom) {
		this.jury_prenom = jury_prenom;
	}
	
	@Column(name = "jury_role", nullable = false)
	public String getJury_role() {
		return jury_role;
	}

	public void setJury_role(String jury_role) {
		this.jury_role = jury_role;
	}
	
	
	@Override
	public String toString() {
		return "Jury [id_jury=" +id_jury+ ", jury_nom=" +jury_nom+ ", jury_prenom=" +jury_prenom+ ", jury_role=" +jury_role+ "]";
	}
	
	
}
