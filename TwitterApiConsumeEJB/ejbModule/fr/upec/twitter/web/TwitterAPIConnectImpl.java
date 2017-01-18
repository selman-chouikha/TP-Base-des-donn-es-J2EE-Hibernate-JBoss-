package fr.upec.twitter.web;

import java.sql.Time;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.upec.twitter.entities.CustomDate;
import fr.upec.twitter.entities.Tweet;
import fr.upec.twitter.entities.TweetType;
import fr.upec.twitter.entities.TwitterUser;
import fr.upec.twitter.entities.TypeTweet;
import fr.upec.twitter.session.local.ITweetLocal;
import fr.upec.twitter.session.local.IUserLocal;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.User;

@Stateless(name = "TACK")
public class TwitterAPIConnectImpl implements TwitterAPIConnect {
	@EJB
	private IUserLocal userSession;
	@EJB
	private ITweetLocal tweetSession;
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
			resp = Arrays.stream(twitterConnection.getFollowersIDs(id, cursor).getIDs()).distinct().toArray();
			do {

				for (long idUser : resp) {
					saveUser(idUser);
					long[] resp1 = Arrays.stream(twitterConnection.getFollowersIDs(idUser, cursor).getIDs()).distinct()
							.toArray();
					for (long id1 : resp1) {
						saveUser(id1);
					}

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
			TweetType type = TweetType.TWEET;
			if (status.getInReplyToStatusId() > 0) {
				type = TweetType.RETWEET;
			}
			Tweet tweet = new Tweet(status.getId(), status.getFavoriteCount(), status.getText(),null, user, customDate, null,
					new TypeTweet(type));
			tweetSession.addTweet(tweet);
		}

	}

}
