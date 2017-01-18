package fr.upec.twitter.session.local;

import java.util.List;

import javax.ejb.Local;

import fr.upec.twitter.entities.TwitterUser;

@Local
public interface IUserLocal {
	public void addUser(TwitterUser user);

	public List<TwitterUser> getAllUsers();

	public TwitterUser getUser(Long id);

	public void updateUser(TwitterUser user);

	public void remove(Long id);
}
