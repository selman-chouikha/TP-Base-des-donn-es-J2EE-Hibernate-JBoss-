package fr.upec.twitter.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TWEET")
public class Tweet implements Serializable {

	@Id
	@Column(name = "TWEET_ID")
	private long id;
	@Column(name = "NB_OF_LIKES")
	private int nbOfLikes;
	@Column(name = "TEXT")
	private String text;
	@Column(name = "TYPE")
	private String type; // Type text,jpg,gif..
	@ManyToOne(targetEntity = TwitterUser.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private TwitterUser user;
	
	@ManyToOne(targetEntity = CustomDate.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "DATE", referencedColumnName = "DATE_ID")
	private CustomDate date;

	@ManyToOne(targetEntity = Media.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "LIEN", referencedColumnName = "LIEN_MEDIA")
	private Media lien;

	@ManyToOne(targetEntity = TypeTweet.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_TWEET", referencedColumnName = "TYPE_ID")
	private TypeTweet typeTweet;

	public Tweet() {
		super();
	}

	public Tweet(long id, int nbOfLikes, String text, String type, TwitterUser user, CustomDate date, Media lien,
			TypeTweet typeTweet) {
		super();
		this.id = id;
		this.nbOfLikes = nbOfLikes;
		this.text = text;
		this.type = type;
		this.user = user;
		this.date = date;
		this.lien = lien;
		this.typeTweet = typeTweet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNbOfLikes() {
		return nbOfLikes;
	}

	public void setNbOfLikes(int nbOfLikes) {
		this.nbOfLikes = nbOfLikes;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CustomDate getDate() {
		return date;
	}

	public void setDate(CustomDate date) {
		this.date = date;
	}

	public Media getLien() {
		return lien;
	}

	public void setLien(Media lien) {
		this.lien = lien;
	}

	public TypeTweet getTypeTweet() {
		return typeTweet;
	}

	public void setTypeTweet(TypeTweet typeTweet) {
		this.typeTweet = typeTweet;
	}

	public TwitterUser getUser() {
		return user;
	}


	public void setUser(TwitterUser user) {
		this.user = user;
	}

}
