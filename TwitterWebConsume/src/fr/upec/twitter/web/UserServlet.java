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

@WebServlet(name = "cs", urlPatterns = { "*.php" })
public class UserServlet extends HttpServlet {

	@EJB
	private IUserLocal userSession;
	@EJB
	private TwitterAPIConnect twitterAPISession;
	@EJB
	private ITweetLocal twitterSession;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals("add")) {
				Long id = Long.parseLong(req.getParameter("id"));
				try {
					twitterAPISession.saveUser(id);
				} catch (Exception e) {
					req.setAttribute("exception", " Erreur lors de l'ajout ");
				}
			}
			if (action.equals("addAll")) {
				Long id = Long.parseLong(req.getParameter("id"));	
				twitterAPISession.saveUserAndFollowers(id);
			}
			if (action.equals("addFollowers")) {
				Long id = Long.parseLong(req.getParameter("id"));
				twitterAPISession.saveUserFollowers(id);
				TwitterUser user = userSession.getUser(id);
				resp.sendRedirect("/TwitterWebConsume/followers.php?name="+user.getName()+"&id="+id);
			
			}
			if (action.equals("addTweets")) {
				Long id = Long.parseLong(req.getParameter("id"));
				TwitterUser user = userSession.getUser(id);
				twitterAPISession.saveTweets(user);
				resp.sendRedirect("/TwitterWebConsume/tweets.php?name="+user.getName()+"&id="+id);
			}
		}
		req.setAttribute("users", userSession.getAllUsers());
		req.getRequestDispatcher("Vues/Users.jsp").forward(req, resp);
	}
}
