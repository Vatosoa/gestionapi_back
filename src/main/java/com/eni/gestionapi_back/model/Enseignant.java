package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enseignants")
public class Enseignant {
	
	private long id_enseig;
	private String enseig_nom;
	private String enseig_prenom;
	private String enseig_sexe;
	private String enseig_grade;
	private String enseig_adr;
	private String enseig_email;
	private String enseig_tel;
	
	public Enseignant() {
		
	}
	
	public Enseignant(String enseig_nom, String enseig_prenom, String enseig_sexe,String enseig_grade,String enseig_adr,String enseig_email,String enseig_tel) {
		this.enseig_nom = enseig_nom;
		this.enseig_prenom = enseig_prenom;
		this.enseig_sexe = enseig_sexe;
		this.enseig_grade= enseig_grade;
		this.enseig_adr = enseig_adr;
		this.enseig_email= enseig_email ;
		this.enseig_tel= enseig_tel ;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_enseig() {
		return id_enseig;
	}

	public void setId_enseig(long id_enseig) {
		this.id_enseig = id_enseig;
	}

	@Column(name = "enseig_nom", nullable = false)
	public String getEnseig_nom() {
		return enseig_nom;
	}

	public void setEnseig_nom(String enseig_nom) {
		this.enseig_nom = enseig_nom;
	}

	@Column(name = "enseig_prenom", nullable = false)
	public String getEnseig_prenom() {
		return enseig_prenom;
	}

	public void setEnseig_prenom(String enseig_prenom) {
		this.enseig_prenom = enseig_prenom;
	}

	@Column(name = "enseig_sexe", nullable = false)
	public String getEnseig_sexe() {
		return enseig_sexe;
	}

	public void setEnseig_sexe(String enseig_sexe) {
		this.enseig_sexe = enseig_sexe;
	}

	@Column(name = "enseig_grade", nullable = false)
	public String getEnseig_grade() {
		return enseig_grade;
	}

	public void setEnseig_grade(String enseig_grade) {
		this.enseig_grade = enseig_grade;
	}

	@Column(name = "enseig_adr", nullable = false)
	public String getEnseig_adr() {
		return enseig_adr;
	}

	public void setEnseig_adr(String enseig_adr) {
		this.enseig_adr = enseig_adr;
	}

	@Column(name = "enseig_email", nullable = false)
	public String getEnseig_email() {
		return enseig_email;
	}

	public void setEnseig_email(String enseig_email) {
		this.enseig_email = enseig_email;
	}

	@Column(name = "enseig_tel", nullable = false)
	public String getEnseig_tel() {
		return enseig_tel;
	}

	public void setEnseig_tel(String enseig_tel) {
		this.enseig_tel = enseig_tel;
	}

	
	@Override
	public String toString() {
		return "Enseignant [id_enseig=" +id_enseig+ ", enseig_nom=" +enseig_nom+ ", enseig_prenom=" +enseig_prenom+ ", enseig_sexe=" +enseig_sexe+ ", enseig_grade=" +enseig_grade+ ", enseig_adr=" +enseig_adr+ ", enseig_email=" +enseig_email+ ", enseig_tel=" +enseig_tel+ "]";
	}
	
	
}
