package com.eni.gestionapi_back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calendriers")
public class Calendrier {
	
	private long id_cal;
	private String cal_lieu_stage;
	private String cal_type_memoire;
	private String cal_lieu_sout;
	private String cal_date_sout;
	private String cal_heure_sout;
	private long cal_sale_sout;
	private String cal_note_sout;
	
	public Calendrier() {
		
	}
	
	public Calendrier(String cal_lieu_stage, String cal_type_memoire, String cal_lieu_sout,String cal_date_sout,String cal_heure_sout,long cal_sale_sout,String cal_note_sout) {
		this.cal_lieu_stage = cal_lieu_stage;
		this.cal_type_memoire = cal_type_memoire;
		this.cal_lieu_sout = cal_lieu_sout;
		this.cal_date_sout = cal_date_sout;
		this.cal_heure_sout = cal_heure_sout;
		this.cal_sale_sout = cal_sale_sout;
		this.cal_note_sout = cal_note_sout;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId_cal() {
		return id_cal;
	}

	public void setId_cal(long id_cal) {
		this.id_cal = id_cal;
	}

	@Column(name = "cal_lieu_stage", nullable = false)
	public String getCal_lieu_stage() {
		return cal_lieu_stage;
	}

	public void setCal_lieu_stage(String cal_lieu_stage) {
		this.cal_lieu_stage = cal_lieu_stage;
	}
	
	@Column(name = "cal_type_memoire", nullable = false)
	public String getCal_type_memoire() {
		return cal_type_memoire;
	}

	public void setCal_type_memoire(String cal_type_memoire) {
		this.cal_type_memoire = cal_type_memoire;
	}

	@Column(name = "cal_lieu_sout", nullable = false)
	public String getCal_lieu_sout() {
		return cal_lieu_sout;
	}

	public void setCal_lieu_sout(String cal_lieu_sout) {
		this.cal_lieu_sout = cal_lieu_sout;
	}

	@Column(name = "cal_date_sout", nullable = false)
	public String getCal_date_sout() {
		return cal_date_sout;
	}

	public void setCal_date_sout(String cal_date_sout) {
		this.cal_date_sout = cal_date_sout;
	}

	@Column(name = "cal_heure_sout", nullable = false)
	public String getCal_heure_sout() {
		return cal_heure_sout;
	}

	public void setCal_heure_sout(String cal_heure_sout) {
		this.cal_heure_sout = cal_heure_sout;
	}

	@Column(name = "cal_sale_sout", nullable = false)
	public long getCal_sale_sout() {
		return cal_sale_sout;
	}

	public void setCal_sale_sout(long cal_sale_sout) {
		this.cal_sale_sout = cal_sale_sout;
	}

	@Column(name = "cal_note_sout", nullable = false)
	public String getCal_note_sout() {
		return cal_note_sout;
	}

	public void setCal_note_sout(String cal_note_sout) {
		this.cal_note_sout = cal_note_sout;
	}

	
	@Override
	public String toString() {
		return "Calendrier [id_cal=" +id_cal+ ", cal_lieu_stage=" +cal_lieu_stage+ ", cal_type_memoire=" +cal_type_memoire+ ", cal_lieu_sout=" +cal_lieu_sout+ ", cal_date_sout=" +cal_date_sout+ ", cal_heure_sout =" +cal_heure_sout+ ", cal_sale_sout =" +cal_sale_sout+", cal_note_sout =" +cal_note_sout+ "]";
	}
	
}
