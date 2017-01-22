package fr.upec.twitter.session.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.upec.twitter.entities.Follower;
import fr.upec.twitter.entities.TwitterUser;
import fr.upec.twitter.session.local.IFollowLocal;
import fr.upec.twitter.session.local.IUserLocal;
import fr.upec.twitter.session.remote.IFollowRemote;

@Stateless(name = "FEK")
public class FollowEJBImpl implements IFollowLocal, IFollowRemote {

	@PersistenceContext
	private EntityManager em;
	@EJB
	private IUserLocal userSession;

	@Override
	public void addFollower(TwitterUser user, TwitterUser follower) {
		Follower followerInstance = new Follower(user,follower);
		em.merge(followerInstance);
		
	}

	@Override
	public List<TwitterUser> getAllFollowers(Long idUser) {
		Query query = em.createQuery("select f.primaryKey.follower from Follower f where f.primaryKey.user.id=:idFind");
		query.setParameter("idFind", idUser);
		return query.getResultList();
	}

	@Override
	public void updateFollower(TwitterUser user, TwitterUser follower) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(TwitterUser user, TwitterUser follower) {
		Follower followerInstance = new Follower(user,follower);
		em.remove(em.contains(followerInstance) ? followerInstance : em.merge(followerInstance));
		
	}

}
