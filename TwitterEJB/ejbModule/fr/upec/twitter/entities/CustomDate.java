package fr.upec.twitter.entities;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOM_DATE")
public class CustomDate implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DATE_ID")
	private Long id;
	@Column(name = "JOUR")
	private int jour;
	@Column(name = "MOIS")
	private int mois;
	@Column(name = "ANNEE")
	private int annee;
	@Column(name = "TIME")
	private Time time;

	public CustomDate() {
		super();
	}

	public CustomDate(int jour, int mois, int annee, Time time) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
		this.time = time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
