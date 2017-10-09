package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

@Controller
public class TwitterController {

	@RequestMapping(value="/tweet", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
		System.out.println("★★★★★★★★★★ index()");
		mav.addObject("tweetResult", "ツイートする文字を入力してください");
		mav.setViewName("tweet");
		return mav;
	}
	
	@RequestMapping(value="/tweet", method=RequestMethod.POST)
	public ModelAndView tweet(@RequestParam("tweetText")String str, ModelAndView mav) throws TwitterException{
		System.out.println("★★★★★★★★★★ tweet()");

		Twitter twitter = TwitterFactory.getSingleton();
        User user = twitter.verifyCredentials();
        System.out.println(user.getName());
        System.out.println(user.getScreenName());
        System.out.println(user.getFriendsCount());
        System.out.println(user.getFollowersCount());
        System.out.println(str);

        Status status = twitter.updateStatus(str);
  
		mav.addObject("tweetResult", "ツイートしました！");
		mav.setViewName("tweet");
		return mav;
	}
}
