package fr.upec.twitter.session.remote;

import java.util.List;

import javax.ejb.Remote;

import fr.upec.twitter.entities.Media;

@Remote
public interface IMediaRemote {
	public void addMedia(Media media);

	public List<Media> getAllMediaForTweet(Long idTweet);


}
