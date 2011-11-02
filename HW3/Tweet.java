import java.util.ArrayList;
import java.util.List;

public class Tweet {

	/**
	 * @param args
	 */
	private String date;
	private int id = 0;
	private static int idCount=0;
	private String text;
	private String author;
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tweet t = new Tweet("brittany", "10/26", "hello hello, hi!");
		System.out.println(t.extractWords());

		Tweet t2 = new Tweet("b", "10/27", "als kjd-foai! #sdn");
		System.out.println(t2.extractWords());
		
		System.out.println(t.getId());
	
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
		idCount++;
		id=Tweet.idCount;
		
		author = author1;
		date = date1;

	}

	public String toString() {
		return "[" + id + ",@" + author + "," + date + "," + text + "]";
	}

	public List<String> extractWords() {


		List<String> wordtokens = new ArrayList<String>();
		String[] words = this.text.split(" ");
		
		for (int i=0; i<words.length;i++) {
			String s=stripPunctuation(words[i]);
			
			if(s==null){
				continue;
			}else{
				s = s.toLowerCase();
				wordtokens.add(s);
			}
			

		}

		return wordtokens;

	}

	public String stripPunctuation(String s) {

		String sb = null;
		if (s.equals(":-)") || s.equals("(:") || s.equals("(;")) {
			return s;
		} else {

			for (int i = 0; i < s.length(); i++) {

				if ((s.charAt(i) >= 64 && s.charAt(i) <= 90)
						|| (s.charAt(i) >= 97 && s.charAt(i) <= 122)
						|| s.charAt(i) == 35) {

					sb = s.substring(i, s.length());
					break;
				}
			}
		}
		String sb2 = null;
		if (sb == null) {
			return null;
		} else {
			for (int i = sb.length() - 1; i > 0; i--) {
				if ((sb.charAt(i) >= 65 && sb.charAt(i) <= 90)
						|| (sb.charAt(i) >= 97 && sb.charAt(i) <= 122)) {

					sb2 = sb.substring(0, i+1);
					break;
				}
			}
		}
		return sb2;
	}

}
