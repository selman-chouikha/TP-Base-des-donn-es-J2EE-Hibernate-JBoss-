package fr.upec.twitter.session.remote;

import java.util.List;

import javax.ejb.Remote;

import fr.upec.twitter.entities.TwitterUser;

@Remote
public interface IFollowRemote {
	public void addFollower(TwitterUser user,TwitterUser follower);

	public List<TwitterUser> getAllFollowers(Long idUser);

	public void updateFollower(TwitterUser user,TwitterUser follower);

	public void remove(TwitterUser user,TwitterUser follower);
}
