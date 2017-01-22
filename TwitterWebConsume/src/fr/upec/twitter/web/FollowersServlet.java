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
import fr.upec.twitter.session.local.IFollowLocal;
import fr.upec.twitter.session.local.ITweetLocal;
import fr.upec.twitter.session.local.IUserLocal;

@WebServlet(name = "fs", urlPatterns = { "followers.php" })
public class FollowersServlet extends HttpServlet {

	/**
	 * Auto Generated ID
	 */
	private static final long serialVersionUID = -169536238859118L;
	
	@EJB
	private IFollowLocal followSession;
	@EJB
	private IUserLocal userSession;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("name");
		req.setAttribute("name", name);
		req.setAttribute("followers", followSession.getAllFollowers(id));
		req.getRequestDispatcher("Vues/Followers.jsp").forward(req, resp);
	}
}
