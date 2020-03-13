package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="themes")
public class Theme {
	
	private long id_theme;
	private String theme_nom;
	
	public Theme() {
		
	}

	public Theme(String theme_nom) {
		this.theme_nom = theme_nom;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public long getId_theme() {
		return id_theme;
	}

	public void setId_theme(long id_theme) {
		this.id_theme = id_theme;
	}

	@Column(name = "theme_nom", nullable = false)
	public String getTheme_nom() {
		return theme_nom;
	}

	public void setTheme_nom(String theme_nom) {
		this.theme_nom = theme_nom;
	}

	
	@Override
	public String toString() {
		return "Theme [id_theme=" +id_theme+ ", theme_nom=" +theme_nom+ "]";
	}
	
	
}
