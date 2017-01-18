package fr.upec.twitter.session.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.upec.twitter.entities.Tweet;
import fr.upec.twitter.entities.TwitterUser;
import fr.upec.twitter.session.local.ITweetLocal;
import fr.upec.twitter.session.remote.ITweetRemote;

@Stateless(name = "TK")
public class TweetEJBImpl implements ITweetLocal, ITweetRemote {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addTweet(Tweet tweet) {

			em.merge(tweet);

	}

	@Override
	public List<Tweet> getAllTweetsForUser(Long id) {
		Query query = em.createQuery("select t from Tweet t where t.user="+id);
		return query.getResultList();
	}

	@Override
	public Tweet getTweet(Long id) {
		Tweet tweet = em.find(Tweet.class, id);
		if (tweet == null)
			throw new RuntimeException("tweet Not Found");
		return tweet;
	}

	@Override
	public void removeTweet(Long idTweet) {
		Tweet tweet = getTweet(idTweet);
		em.remove(tweet);
		
	}

	@Override
	public void removeTweetForUser(Long idUser) {
		List<Tweet> tweets = getAllTweetsForUser(idUser);
		for(Tweet tweet: tweets){
			removeTweet(tweet.getId());
		}
		
	}

}
