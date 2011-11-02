import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class TweetStore {

	/**
	 * @param args
	 */
	private String name;
	private TreeMap<String, List<Tweet>> TMap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TweetStore ts = new TweetStore("t1");
		Tweet t = new Tweet("brittany", "10/26", "hello hello, hi!");
		Tweet t2 = new Tweet("b", "10/27", "alskjdfoaisdn");
		Tweet t3 = new Tweet("b", "10/29", "hello there hello hello");
		
		ts.addTweet("hello", t);
		
		
		ts.addTweet("hello", t);		
		ts.addTweet("hello", t2);		
		ts.addTweet("hi", t);		
		ts.addTweet("brittany", t);		
		ts.addTweet("k", t2);		
		ts.addTweet("k", t);		
		ts.addTweet("k", t3);		
		System.out.println(ts.getKeysByFrequency());		
		ts.report();
		
	}

	public TweetStore(String name1) {
		name = name1;
		TMap = new TreeMap<String, List<Tweet>>();
	}

	String getName() {
		return name;
	}

	public void addTweet(String k, Tweet t) {
		if (TMap.containsKey(k)) {
			TMap.get(k).add(t);
		} else {
			List<Tweet> tList = new ArrayList<Tweet>();
			tList.add(t);
			TMap.put(k, tList);
		}
		// stores t in the list of Tweets associated with key k
		// if the key does not exist it must be created
	}

	public List<Tweet> getTweets(String key) {
		return TMap.get(key);
		// return list of tweets associated with key k
	}

	public Set<String> getKeys() {
		// returns set storing all keys that have been added into TweetStore
		return TMap.keySet();
	}

	public List<String> getKeysByFrequency() {
		// return list of keys sorted in order of descending frequency of tweets
		// stored for key
		//either map 
		//more than one tweetstore 
		//one tweet store where the keys are author, one with hashtag,

		Set<String> keys = TMap.keySet();
		List<StringCount> sorter = new ArrayList<StringCount>();
		for (String key : keys) {
			List<Tweet> tList = TMap.get(key);
			int size = tList.size();
			StringCount sc = new StringCount(key, size, tList);
			sorter.add(sc);
			}
		Collections.sort(sorter, compare);
			List<String> result = new ArrayList<String>();
			for (StringCount sc : sorter) {
				result.add(sc.getWord());
		}		
		return result;
		
		

	}

	public final Comparator<StringCount> compare = new Comparator<StringCount>() {
		public int compare(StringCount s1, StringCount s2) {
		return s2.getCount() - s1.getCount();		
		}
		};
		
		
	public void report() {
		System.out.println("Name of Store: " + name);
		System.out.println(TMap.entrySet());
		

		//get the key set and get the list for each key and print them
		// prints the contents of tweet store to system.out in easy to read
		// format
	}

}
