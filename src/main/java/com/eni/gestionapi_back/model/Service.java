package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="services")
public class Service {
	
	private long id_service;
	private String service_nom;
	private String service_prenom;
	private String service_sexe;
	private String service_resp;
	private String service_adr;
	private String service_email;
	private String service_tel;
	
	public Service() {
		
	}
	
	public Service(String service_nom, String service_prenom, String service_sexe, String service_resp, String service_adr, String service_email, String service_tel) {
		this.service_nom = service_nom;
		this.service_prenom = service_prenom;
		this.service_sexe = service_sexe;
		this.service_resp = service_resp;
		this.service_adr = service_adr;
		this.service_email = service_email;
		this.service_tel = service_tel;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_service() {
		return id_service;
	}

	public void setId_service(long id_service) {
		this.id_service = id_service;
	}

	@Column(name = "service_nom", nullable = false)
	public String getService_nom() {
		return service_nom;
	}

	public void setService_nom(String service_nom) {
		this.service_nom = service_nom;
	}

	@Column(name = "service_prenom", nullable = false)
	public String getService_prenom() {
		return service_prenom;
	}

	public void setService_prenom(String service_prenom) {
		this.service_prenom = service_prenom;
	}

	@Column(name = "service_sexe", nullable = false)
	public String getService_sexe() {
		return service_sexe;
	}

	public void setService_sexe(String service_sexe) {
		this.service_sexe = service_sexe;
	}

	@Column(name = "service_resp", nullable = false)
	public String getService_resp() {
		return service_resp;
	}

	public void setService_resp(String service_resp) {
		this.service_resp = service_resp;
	}

	@Column(name = "service_adr", nullable = false)
	public String getService_adr() {
		return service_adr;
	}

	public void setService_adr(String service_adr) {
		this.service_adr = service_adr;
	}

	@Column(name = "service_email", nullable = false)
	public String getService_email() {
		return service_email;
	}

	public void setService_email(String service_email) {
		this.service_email = service_email;
	}

	@Column(name = "service_tel", nullable = false)
	public String getService_tel() {
		return service_tel;
	}

	public void setService_tel(String service_tel) {
		this.service_tel = service_tel;
	}

	
	@Override
	public String toString() {
		return "Service [id_service=" +id_service+ ", service_nom=" +service_nom+ ", service_prenom=" +service_prenom+ ", service_sexe=" +service_sexe+ ", service_resp=" +service_resp+ ", service_adr=" +service_adr+ ", service_email=" +service_email+ ", service_tel=" +service_tel+ "]";
	}
	
	
}
