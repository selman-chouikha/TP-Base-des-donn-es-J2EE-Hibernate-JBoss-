package fr.upec.twitter.session.local;

import java.util.List;

import javax.ejb.Local;

import fr.upec.twitter.entities.Media;

@Local
public interface IMediaLocal {
	public void addMedia(Media media);

	public List<Media> getAllMediaForTweet(Long idTweet);
}
