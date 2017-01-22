package fr.upec.twitter.web;

import fr.upec.twitter.entities.TwitterUser;

public interface TwitterAPIConnect {

	public void saveUser(Long id) ;
	public void saveUserAndFollowers(Long id);
	public void saveUserFollowers(Long id);
	public void saveTweets(TwitterUser user);
}
