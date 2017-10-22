package com.study.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

@Controller
public class SearchController {

	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
		System.out.println("★★★★★★★★★★ index()");
		mav.setViewName("search");
		return mav;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView search(@RequestParam("search-text")String str, ModelAndView mav) throws TwitterException{
		System.out.println("★★★★★★★★★★ search()");
		
		Twitter twitter = TwitterFactory.getSingleton();
//	    Query query = new Query("source:twitter4j yusukey");
		if(str == null || "".equals(str)){
			str = "";
		}
	    Query query = new Query(str);
	    QueryResult result = twitter.search(query);

	    ArrayList<String> tweetList = new ArrayList<String>();
	    for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	        tweetList.add(status.getText().toString());
	    }
		mav.addObject("tweetList", tweetList);
		mav.setViewName("search");
		return mav;
	}
}
