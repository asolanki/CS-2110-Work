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

	@Before
	public void setUp() throws Exception {
		tStore=new TweetStore("Tweet Store");
		t=new Tweet("brittany", "May 07", "lkajsdfoi alkjdfoai");
		t1=new Tweet("bfull","may 08", "water bottle");
		t2=new Tweet("hello", "april 25", "cell phone");
		s=" hi";
		s1="hello";
		s2="howare you";
		tStore.addTweet(s,t);
		tStore.addTweet(s,t1);
		tStore.addTweet(s, t2);
		tStore.addTweet(s1, t);
		tStore.addTweet(s2,t2);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddTweet() {
		
		//addTweet1
		assertEquals(3,tStore.getKeys().size());
		
		//addTweet2
		assertEquals(3,tStore.getTweets(s).size());
		
		//addTweet3
		assertEquals(t,tStore.getTweets(s).get(0));
		
		//addTweet4
		assertEquals(t2,tStore.getTweets(s).get(2));
		
	}

	@Test
	public void testGetTweets() {
		List<Tweet> tList=new ArrayList<Tweet>();
		tList.add(t);
		tList.add(t1);
		tList.add(t2);
		
		
		assertEquals(t,tStore.getTweets(s).get(0));
		assertEquals(tList,tStore.getTweets(s));
		assertEquals(tList.size(),tStore.getTweets(s).size());
		assertEquals(t2, tStore.getTweets(s).get(2));
		
		
		
	}

	@Test
	public void testGetKeys() {
		Set<String> tSet=new TreeSet<String>();
		tSet.add(s);
		tSet.add(s1);
		tSet.add(s2);
		
		assertEquals(tSet,tStore.getKeys());
		assertEquals(tSet.size(),tStore.getKeys().size());
		
		
		
	}

	@Test
	public void testGetKeysByFrequency() {
		tStore.addTweet(s1,t);
		
		assertEquals(s,tStore.getKeysByFrequency().get(0));
		assertEquals(3,tStore.getKeysByFrequency().size());
		assertEquals(s2,tStore.getKeysByFrequency().get(2));
		
		
	}

}
