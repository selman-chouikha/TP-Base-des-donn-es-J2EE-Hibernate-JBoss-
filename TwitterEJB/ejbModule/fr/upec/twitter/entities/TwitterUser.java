package fr.upec.twitter.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TWITTER_USER")
public class TwitterUser implements Serializable {

	@Id
	@Column(name = "USER_ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SCREEN_NAME")
	private String screenName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "URL")
	private String url;

	@ManyToOne(targetEntity = CustomDate.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "DATE", referencedColumnName = "DATE_ID")
	private CustomDate date;

	public TwitterUser() {
		super();
	}


	public TwitterUser(Long id, String name, String screenName, String description, String location, String url,
			 CustomDate date) {
		super();
		this.id = id;
		this.name = name;
		this.screenName = screenName;
		this.description = description;
		this.location = location;
		this.url = url;
		this.date = date;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getScreenName() {
		return screenName;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public CustomDate getDate() {
		return date;
	}


	public void setDate(CustomDate date) {
		this.date = date;
	}


}
