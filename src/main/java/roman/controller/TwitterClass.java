package roman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import roman.model.User;
import roman.service.UserService;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterClass {
	
	public static void twit(User user){
			Twitter twitter = new TwitterFactory().getInstance();
	// Twitter Consumer key & Consumer Secret
	twitter.setOAuthConsumer("", "");
	// Twitter Access token & Access token Secret
	twitter.setOAuthAccessToken(new AccessToken("", ""));
	try {
		// Getting Twitter Timeline using Twitter4j API
		ResponseList statusReponseList = twitter.getUserTimeline(new Paging(1, 5));

		// Post a Tweet using Twitter4j API
		Status status = twitter.updateStatus("New User " + user.getName() + " Successfully added");
	} catch (Exception e) {
	}
	}

}
