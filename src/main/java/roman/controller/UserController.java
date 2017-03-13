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

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("user/list");
		model.addObject("listUser", userService.listUser());
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("userForm", new User());
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") String id) {
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("userForm", userService.findUserById(id));
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("userForm") User user) {
		if (user.getId() != null && !user.getId().trim().equals("")) {

			userService.update(user);
		} else {
			userService.add(user);
		}

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

		return "redirect:/user/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id) {
		User user = userService.findUserById(id);
		userService.delete(user);

		return "redirect:/user/list";
	}
}
