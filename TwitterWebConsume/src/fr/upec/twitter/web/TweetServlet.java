package fr.upec.twitter.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upec.twitter.web.TwitterAPIConnect;
import fr.upec.twitter.entities.Tweet;
import fr.upec.twitter.entities.TwitterUser;
import fr.upec.twitter.session.local.ITweetLocal;
import fr.upec.twitter.session.local.IUserLocal;

@WebServlet(name = "ts", urlPatterns = { "tweets.php" })
public class TweetServlet extends HttpServlet {

	/**
	 * Auto Generated ID
	 */
	private static final long serialVersionUID = -163053623537859118L;
	
	@EJB
	private IUserLocal userSession;
	@EJB
	private TwitterAPIConnect twitterAPISession;
	@EJB
	private ITweetLocal twitterSession;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("name");
		req.setAttribute("tweets", twitterSession.getAllTweetsForUser(id));
		req.setAttribute("name", name);
		req.getRequestDispatcher("Vues/Tweets.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
