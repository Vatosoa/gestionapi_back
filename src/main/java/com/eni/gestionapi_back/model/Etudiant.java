package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etudiants")
public class Etudiant {
	
	private long id_etud;
	private long etud_num;
	private String etud_matricule;
	private String etud_nom;
	private String etud_prenom;
	private String etud_sexe;
	private String etud_adr;
	private String etud_email;
	private String etud_tel;
	
	public Etudiant() {
		
	}
	
	public Etudiant(long etud_num, String etud_matricule, String etud_nom, String etud_prenom, String etud_sexe, String etud_adr, String etud_email, String etud_tel) {
		this.etud_num = etud_num;
		this.etud_matricule = etud_matricule;
		this.etud_nom = etud_nom;
		this.etud_prenom = etud_prenom;
		this.etud_sexe = etud_sexe;
		this.etud_adr = etud_adr;
		this.etud_email = etud_email;
		this.etud_tel = etud_tel;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_etud() {
		return id_etud;
	}

	public void setId_etud(long id_etud) {
		this.id_etud = id_etud;
	}

	@Column(name = "etud_num", nullable = false)
	public long getEtud_num() {
		return etud_num;
	}

	public void setEtud_num(long etud_num) {
		this.etud_num = etud_num;
	}

	@Column(name = "etud_matricule", nullable = false)
	public String getEtud_matricule() {
		return etud_matricule;
	}

	public void setEtud_matricule(String etud_matricule) {
		this.etud_matricule = etud_matricule;
	}

	@Column(name = "etud_nom", nullable = false)
	public String getEtud_nom() {
		return etud_nom;
	}

	public void setEtud_nom(String etud_nom) {
		this.etud_nom = etud_nom;
	}

	@Column(name = "etud_prenom", nullable = false)
	public String getEtud_prenom() {
		return etud_prenom;
	}

	public void setEtud_prenom(String etud_prenom) {
		this.etud_prenom = etud_prenom;
	}

	@Column(name = "etud_sexe", nullable = false)
	public String getEtud_sexe() {
		return etud_sexe;
	}

	public void setEtud_sexe(String etud_sexe) {
		this.etud_sexe = etud_sexe;
	}

	@Column(name = "etud_adr", nullable = false)
	public String getEtud_adr() {
		return etud_adr;
	}

	public void setEtud_adr(String etud_adr) {
		this.etud_adr = etud_adr;
	}

	@Column(name = "etud_email", nullable = false)
	public String getEtud_email() {
		return etud_email;
	}

	public void setEtud_email(String etud_email) {
		this.etud_email = etud_email;
	}

	@Column(name = "etud_tel", nullable = false)
	public String getEtud_tel() {
		return etud_tel;
	}

	public void setEtud_tel(String etud_tel) {
		this.etud_tel = etud_tel;
	}

	
	@Override
	public String toString() {
		return "Etudiant [id_etud=" +id_etud+ ", etud_num=" +etud_num+ ", etud_matricule = " +etud_matricule+ ", etud_nom=" +etud_nom+ ", etud_prenom=" +etud_prenom+", etud_sexe=" +etud_sexe+ ", etud_adr=" +etud_adr+ ", etud_email=" +etud_email+ ", etud_tel=" +etud_tel+ "]";
	}
	
	
}
