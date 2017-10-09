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
public class CollectController {

	@RequestMapping(value="/collect", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
		System.out.println("★★★★★★★★★★ index()");
		mav.setViewName("collect");
		return mav;
	}
	
	@RequestMapping(value="/collect", method=RequestMethod.POST)
	public ModelAndView tweetCollect(@RequestParam("tweetText")String str, ModelAndView mav) throws TwitterException{
		System.out.println("★★★★★★★★★★ tweetCollect()");
		
		// このファクトリインスタンスは再利用可能でスレッドセーフです
	    Twitter twitter = TwitterFactory.getSingleton();
	    List<Status> statuses = twitter.getHomeTimeline();
	    ArrayList<String> nameList = new ArrayList<String>();
	    ArrayList<String> tweetList = new ArrayList<String>();
	    for (Status status : statuses) {
	        System.out.println(status.getUser().getName() + ":" +
	                           status.getText());
	        nameList.add(status.getUser().getName().toString());
	        tweetList.add(status.getText().toString());
	    }

		mav.addObject("nameList", nameList);
		mav.addObject("tweetList", tweetList);
		mav.addObject("tweetResult", "タイムラインを表示します！");
		mav.setViewName("collect");
		return mav;
	}
}
