package fr.upec.twitter.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE_TWEET")
public class TypeTweet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TYPE_ID")
	private long id;
	@Column(name = "TYPE_TWEET")
	private TweetType type;

	public TypeTweet() {
		super();
	}

	public TypeTweet(TweetType type) {
		super();
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TweetType getType() {
		return type;
	}

	public void setType(TweetType type) {
		this.type = type;
	}

}
