package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateurs")
public class Utilisateur {
	
	private long id_login;
	private String login;
	private String password;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_login() {
		return id_login;
	}

	public void setId_login(long id_login) {
		this.id_login = id_login;
	}

	@Column(name = "login", nullable = false)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "Utilisateur [id_login=" +id_login+ ", login=" +login+ ", password=" +password+ "]";
	}
	
	
}
