package fr.upec.twitter.session.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.upec.twitter.entities.Media;
import fr.upec.twitter.entities.Tweet;
import fr.upec.twitter.entities.TwitterUser;
import fr.upec.twitter.session.local.IMediaLocal;
import fr.upec.twitter.session.local.ITweetLocal;
import fr.upec.twitter.session.remote.IMediaRemote;
import fr.upec.twitter.session.remote.ITweetRemote;

@Stateless(name = "MK")
public class MediaEJBImpl implements IMediaLocal, IMediaRemote {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addMedia(Media media) {
		em.merge(media);
		
	}

	@Override
	public List<Media> getAllMediaForTweet(Long idTweet) {
		Query query = em.createQuery("select m from Media m, Tweet t where t.id="+idTweet);
		return query.getResultList();
	}

}
