package fr.upec.twitter.session.remote;

import java.util.List;

import javax.ejb.Remote;

import fr.upec.twitter.entities.Tweet;

@Remote
public interface ITweetRemote {
	public void addTweet(Tweet tweet);

	public List<Tweet> getAllTweetsForUser(Long idUser);

	public Tweet getTweet(Long idTweet);
	
	public void removeTweet(Long idTweet);
	
	public void removeTweetForUser(Long idUser);

}
