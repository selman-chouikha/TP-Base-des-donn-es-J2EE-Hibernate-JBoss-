package fr.upec.twitter.web;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.upec.twitter.entities.CustomDate;
import fr.upec.twitter.entities.Media;
import fr.upec.twitter.entities.Tweet;
import fr.upec.twitter.entities.TwitterUser;
import fr.upec.twitter.session.local.IFollowLocal;
import fr.upec.twitter.session.local.ITweetLocal;
import fr.upec.twitter.session.local.IUserLocal;
import twitter4j.MediaEntity;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.User;

@Stateless(name = "TACK")
public class TwitterAPIConnectImpl implements TwitterAPIConnect {
	@EJB
	private IUserLocal userSession;
	@EJB
	private ITweetLocal tweetSession;
	@EJB
	private IFollowLocal followSession;
	private Calendar calendar = Calendar.getInstance();
	private Twitter twitterConnection = SingletonTwitterConnection.getTwitterConnection();

	public void saveUser(Long id) {
		User twitterProfile;
		try {
			twitterProfile = twitterConnection.showUser(id);
		} catch (Exception e) {
			throw new RuntimeException("Cannot connect to Twitter API");
		}
		TwitterUser user = new TwitterUser();
		calendar.setTime(twitterProfile.getCreatedAt());
		CustomDate customDateUser = new CustomDate(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.YEAR), Time.valueOf(calendar.get(Calendar.HOUR_OF_DAY) + ":"
						+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND)));
		user = new TwitterUser(twitterProfile.getId(), twitterProfile.getName(), twitterProfile.getScreenName(),
				twitterProfile.getDescription(), twitterProfile.getLocation(), twitterProfile.getURL(), customDateUser);
		userSession.addUser(user);

	}

	@Override
	public void saveUserAndFollowers(Long id) {
		long[] resp;
		long cursor = -1;
		try {
			saveUser(id);
			resp = Arrays.stream(twitterConnection.getFollowersIDs(id, cursor).getIDs()).distinct().toArray();
			
			do {

				for (long idUser : resp) {
					saveUser(idUser);
					followSession.addFollower(userSession.getUser(id), userSession.getUser(idUser));
					/*long[] resp1 = Arrays.stream(twitterConnection.getFollowersIDs(idUser, cursor).getIDs()).distinct()
							.toArray();
					for (long id1 : resp1) {
						saveUser(id1);
					}*/

				}

			} while ((cursor = resp.length) != 0);
		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveTweets(TwitterUser user) {
		List<Status> statuses;
		try {
			statuses = twitterConnection.getUserTimeline(user.getId());
			System.out.println("getting timeline");
		} catch (Exception e) {
			throw new RuntimeException("Cannot connect to Twitter API");
		}

		for (Status status : statuses) {
			calendar.setTime(status.getCreatedAt());
			CustomDate customDate = new CustomDate(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH),
					calendar.get(Calendar.YEAR), Time.valueOf(calendar.get(Calendar.HOUR_OF_DAY) + ":"
							+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND)));
			String type = "TWEET";
			if (status.getQuotedStatusId() > 0) {
				type = "RETWEET";
			}
			MediaEntity[] media = status.getMediaEntities();
			String tweetType = "";
			if(media.length == 0){ 
				tweetType = "Text";
			}
			Media mediaEntity = null;
			for(MediaEntity m : media){ 
				mediaEntity = new Media(m.getMediaURL(),m.getType());
				tweetType = m.getType() ; 
			}
			Tweet tweet = new Tweet(status.getId(), status.getFavoriteCount(), status.getText(),tweetType, user, customDate, mediaEntity,
					type);
			tweetSession.addTweet(tweet);
		}

	}

	@Override
	public void saveUserFollowers(Long id) {
		long[] resp;
        long cursor = -1;
		try {
			/*
			long[] test=Arrays.stream(twitterConnection.getFollowersIDs(id, cursor).getIDs()).distinct().toArray();
			List<Long> listTest = Arrays.asList(test);
			Set<Long> treesetTest = new TreeSet<Long>(test);
			
			Long[] respObjects = Array.getLong(twitterConnection.getFollowersIDs(id, cursor).getIDs(), 0);
					 Long.valueOf(twitterConnection.getFollowersIDs(id, cursor).getIDs());
			resp = (List<Long>) Arrays.stream();
			Set<Long> hashsetList = new HashSet<Long>(resp);
			*/
			resp = Arrays.stream(twitterConnection.getFollowersIDs(id, cursor).getIDs()).distinct().distinct().toArray();
			cursor = resp.length;
			do {
				for (long idUser : resp) {
					saveUser(idUser);
					followSession.addFollower(userSession.getUser(id), userSession.getUser(idUser));
				System.out.println("Saving "+idUser+" ..! cursor ="+cursor);
				}
				cursor --;
			} while (cursor != 0 );
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		
	}

}
