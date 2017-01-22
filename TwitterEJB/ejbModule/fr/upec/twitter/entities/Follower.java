package fr.upec.twitter.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FOLLOWER")
public class Follower implements Serializable {

	/**
	 * AUTO GENERATED ID
	 */
	private static final long serialVersionUID = 4733674142030838656L;
	
	@EmbeddedId
	private FollowerPK primaryKey;

	public Follower() {
		super();
	}

	public Follower(TwitterUser user, TwitterUser follower) {
		super();
		primaryKey = new FollowerPK(user, follower);
	}

	public TwitterUser getUser() {
		return primaryKey.getUser();
	}


	public TwitterUser getFollower() {
		return primaryKey.getFollower();
	}

}
