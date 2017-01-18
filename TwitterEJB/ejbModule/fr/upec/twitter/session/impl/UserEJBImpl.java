package fr.upec.twitter.session.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.upec.twitter.entities.TwitterUser;
import fr.upec.twitter.session.local.ITweetLocal;
import fr.upec.twitter.session.local.IUserLocal;
import fr.upec.twitter.session.remote.IUserRemote;

@Stateless(name = "UK")
public class UserEJBImpl implements IUserLocal, IUserRemote {

	@PersistenceContext
	private EntityManager em;
	@EJB
	private ITweetLocal twitterSession;
	@Override
	public void addUser(TwitterUser user) {
		TwitterUser tempUser = em.find(TwitterUser.class, user.getId());
		if (tempUser == null)
			em.persist(user);
		else updateUser(tempUser);
		
	}

	@Override
	public List<TwitterUser> getAllUsers() {
		Query query = em.createQuery("select u from TwitterUser u");
		return query.getResultList();
	}

	@Override
	public TwitterUser getUser(Long id) {
		TwitterUser user = em.find(TwitterUser.class, id);
		if (user == null)
			throw new RuntimeException("User Not Found");
		return user;
	}

	@Override
	public void updateUser(TwitterUser user) {
		em.merge(user);
	}

	@Override
	public void remove(Long id) {
		TwitterUser user = getUser(id);
		twitterSession.removeTweetForUser(id);
		em.remove(user);

	}

}
