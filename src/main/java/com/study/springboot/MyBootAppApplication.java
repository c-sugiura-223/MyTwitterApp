package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

@SpringBootApplication
public class MyBootAppApplication {

	public static void main(String[] args)  throws TwitterException{
		SpringApplication.run(MyBootAppApplication.class, args);
/*
		Twitter twitter = TwitterFactory.getSingleton();
        User user = twitter.verifyCredentials();
        System.out.println(user.getName());
        System.out.println(user.getScreenName());
        System.out.println(user.getFriendsCount());
        System.out.println(user.getFollowersCount());

        Status status = twitter.updateStatus("パチューカ！2");
        System.out.println(status.toString());
*/
	}
}
