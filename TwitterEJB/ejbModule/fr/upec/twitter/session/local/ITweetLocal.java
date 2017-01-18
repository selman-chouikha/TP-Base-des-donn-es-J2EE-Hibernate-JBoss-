package fr.upec.twitter.session.local;

import java.util.List;

import javax.ejb.Local;

import fr.upec.twitter.entities.Tweet;

@Local
public interface ITweetLocal {
	public void addTweet(Tweet tweet);

	public List<Tweet> getAllTweetsForUser(Long idUser);

	public Tweet getTweet(Long idTweet);
	
	public void removeTweet(Long idTweet);
	
	public void removeTweetForUser(Long idUser);
}
