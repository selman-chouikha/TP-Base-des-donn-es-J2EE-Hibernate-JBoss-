package fr.upec.twitter.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FOLLOWER")
public class Follower implements Serializable {

	@EmbeddedId
	FollowerPK primaryKey;

	public Follower() {
		super();
	}

	public Follower(FollowerPK primaryKey) {
		super();
		this.primaryKey = primaryKey;
	}

	public FollowerPK getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(FollowerPK primaryKey) {
		this.primaryKey = primaryKey;
	}

}
