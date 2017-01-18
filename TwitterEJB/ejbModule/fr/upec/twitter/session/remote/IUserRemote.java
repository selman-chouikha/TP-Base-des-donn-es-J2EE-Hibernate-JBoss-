package fr.upec.twitter.session.remote;

import java.util.List;

import javax.ejb.Remote;

import fr.upec.twitter.entities.TwitterUser;

@Remote
public interface IUserRemote {
	public void addUser(TwitterUser user);

	public List<TwitterUser> getAllUsers();

	public TwitterUser getUser(Long id);

	public void updateUser(TwitterUser user);

	public void remove(Long id);
}
