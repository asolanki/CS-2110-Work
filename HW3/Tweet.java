import java.util.ArrayList;
import java.util.List;

public class Tweet {

	/**
	 * @param args
	 */
	private String date;
	private static int idCount = 0;
	private String text;
	private String author;
	private int id;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tweet t = new Tweet("brittany", "10/26", "hello hello, hi!");
		System.out.println(t.extractWords());

		Tweet t2 = new Tweet("b", "10/27", "alskjdfoaisdn");
		System.out.println(t.getId());
		System.out.println(t2.getId());
		System.out.println(idCount);

	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getAuthor() {
		return author;
	}

	public String getDate() {
		return date;
	}

	public Tweet(String author1, String date1, String text1) {
		if (text1.length() > 140) {
			text = text1.substring(0, 139);
		} else {
			text = text1;
		}
		idCount += 1;
		this.id = Tweet.idCount;
		author = author1;
		date = date1;

	}

	public String toString() {
		return "[" + id + ",@" + author + "," + date + "," + text + "]";
	}

	public List<String> extractWords() {


		List<String> wordtokens = new ArrayList<String>();
		String[] words = this.text.split("//s+");

		for (String s : words) {
			s = stripPunctuation(s);
			wordtokens.add(s);

		}

		return wordtokens;

	}

	public String stripPunctuation(String s) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 65 && s.charAt(i) <= 90)
					|| (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {

				sb = sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}

}
