package fr.upec.twitter.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEDIA")
public class Media implements Serializable {

	@Id
	@Column(name = "LIEN_MEDIA")
	private String lien;
	@Column(name = "TYPE")
	private String type;

	public Media() {
		super();
	}

	public Media(String lien, String type) {
		super();
		this.lien = lien;
		this.type = type;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
