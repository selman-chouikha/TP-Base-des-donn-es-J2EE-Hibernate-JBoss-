package fr.upec.twitter.session.local;

import java.util.List;

import javax.ejb.Local;

import fr.upec.twitter.entities.TwitterUser;

@Local
public interface IFollowLocal {
	public void addFollower(TwitterUser user,TwitterUser follower);

	public List<TwitterUser> getAllFollowers(Long idUser);

	public void updateFollower(TwitterUser user,TwitterUser follower);

	public void remove(TwitterUser user,TwitterUser follower);
}
