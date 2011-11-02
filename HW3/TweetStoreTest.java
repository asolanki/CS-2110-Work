/*
 * /**
	 * Brittany Fuller- brf5hc 
	 * Adarsh Solanki- as5nr
	 * Homework 3: Tweet Tweet
	 * Lab Section: 101
	 * 
 */

package edu.virginia.cs2110;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TweetStoreTest {
	private TweetStore tStore;
	private Tweet t;
	private Tweet t1;
	private Tweet t2;
	private String s;
	private String s1;
	private String s2;
	private String s3;

	@Before
	public void setUp() throws Exception {
		tStore=new TweetStore("Tweet Store");
		t=new Tweet("brittany", "May 07", "lkajsdfoi alkjdfoai");
		t1=new Tweet("bfull","may 08", "water bottle");
		t2=new Tweet("hello", "april 25", "cell phone");
		
		s=" hi";
		s1="hello";
		s2="howare you";
		s3="hello world";
		tStore.addTweet(s,t);
		tStore.addTweet(s,t1);
		tStore.addTweet(s, t2);
		tStore.addTweet(s1, t);
		tStore.addTweet(s2,t2);		
		tStore.addTweet(s1,t);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddTweet1() {
		
		//addTweet1
		assertEquals(3,tStore.getKeys().size());
	}
	@Test
	public void testAddTweet2(){
		
		assertEquals(3,tStore.getTweets(s).size());
		
	}
	@Test
	public void testAddTweet3(){
	
		assertEquals(t,tStore.getTweets(s).get(0));
		
	}
	@Test
	public void testAddTweet4(){
		
		assertEquals(t2,tStore.getTweets(s).get(2));
		
	}
	
	@Test
	public void testGetTweets1() {
		
		assertNotNull(tStore.getTweets(s));
		
	}
	@Test
	public void testGetTweets2(){
		List<Tweet> tList=new ArrayList<Tweet>();
		tList.add(t);
		tList.add(t1);
		tList.add(t2);
	
		assertEquals(tList,tStore.getTweets(s));
		
	}
	@Test
	public void testGetTweets3(){
					
		assertEquals(2,tStore.getTweets(s1).size());
		
	}
	@Test
	public void testGetTweets4(){
		assertNull(tStore.getTweets(s3));
	}
	@Test
	public void testGetTweets5(){
		
		
		assertEquals(t2, tStore.getTweets(s).get(2));
	}
	@Test
	public void testGetTweets6(){
		assertEquals(t,tStore.getTweets(s).get(0));
	}

	@Test
	public void testGetKeys1(){
	assertNotNull(tStore.getKeys());	
	}
	@Test
	public void testGetKeys2(){
		Set<String> tSet=new TreeSet<String>();
		tSet.add(s);
		tSet.add(s1);
		tSet.add(s2);
		assertEquals(tSet,tStore.getKeys());
	}
	@Test
	public void testGetKeys3() {
				
		assertEquals(3,tStore.getKeys().size());

	}

	@Test
	public void testGetKeysByFrequency1() {
		
		assertEquals(s,tStore.getKeysByFrequency().get(0));
	}
	@Test
	public void testGetKeysByFrequency2(){
		
		assertEquals(3,tStore.getKeysByFrequency().size());
		
	}
	@Test
	public void testGetKeysByFrequency3(){
		
		assertEquals(s2,tStore.getKeysByFrequency().get(2));
	}
		


}
