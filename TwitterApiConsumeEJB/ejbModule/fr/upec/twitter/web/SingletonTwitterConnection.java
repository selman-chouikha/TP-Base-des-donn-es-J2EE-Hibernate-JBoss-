package fr.upec.twitter.web;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class SingletonTwitterConnection {

	private static Twitter twitterConnection;
	static {

		String consumerKey = "uWiZKK8TsT7Xxq5aRz9nxv00o"; // The application's
															// consumer key
		String consumerSecret = "075olTUi7qTbAVtvBG1azDNO1dSbaXGjdoYwvI8rZGowkM6isE"; // The
																						// application's
																						// consumer
																						// secret
		String accessToken = "296444126-ukjdyxHKt6Tbwz7ix9bPrvOFCzPA5gTbK9mCKXa2"; // The
																					// access
																					// token
																					// granted
																					// after
																					// OAuth
																					// authorization
		String accessTokenSecret = "f61mJfhf3bdO8YEKK7xDTHjZ8QUCKZkGg3BAyOx2GDkuE"; // The
																					// access
																					// token
																					// secret
																					// granted
																					// after
																					// OAuth
																					// authorization

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);

		TwitterFactory tf = new TwitterFactory(cb.build());
		twitterConnection = tf.getInstance();
	}

	public static Twitter getTwitterConnection() {
		return twitterConnection;
	}

}
