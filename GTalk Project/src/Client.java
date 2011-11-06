import java.util.Collection;
import java.util.Scanner;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.*;


public class Client {
	
	public static void main(String[] args) {
		System.out.println("Welcome to prototype Gtalk app");
		System.out.println("To continue enter 1");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		if (!input.equals("1")){
			System.exit(0);
		}
		
		ConnectionConfiguration test = new ConnectionConfiguration(
				"talk.google.com", 5222, "gmail.com");
		
		XMPPConnection connection = new XMPPConnection(test);
		
		
		
		try {
			System.out.println("Attempting to connect...");
			connection.connect();
			
			//"cs2110test@gmail.com" :: "softwaredevelopment"
			
			System.out.println("Enter username: ");
			String user = in.next();
			
			System.out.println("Enter password: ");
			String pass = in.next();
			
			System.out.println("Attempting to login...");
			connection.login(user, pass);
			
			System.out.println("   Login successful? " + connection.isAuthenticated());
		} catch (XMPPException e1) {
			System.out.println("Error connecting");
			e1.printStackTrace();
		}
		
		Roster roster = connection.getRoster();
		Collection<RosterEntry> buddies = roster.getEntries();	//possibly add group 
																//functionality here                           
		for (RosterEntry buddy : buddies) {
			System.out.println(buddy);
		}
		
		
		
//		System.out.print("Chat with whom? ");
//		String myBuddy = stdin.next() + "@gmail.com";
//		String myBuddy = "someuser@gmail.com";
//		
//		System.out.println("Instantiating ChatManager...");
//		ChatManager chatmanager = connection.getChatManager();
//		
//		System.out.println("Starting new chat...");
//		Chat newChat = chatmanager.createChat(myBuddy, new MessageListener() {
//			public void processMessage(Chat chat, Message message) {
//				System.out.println("\n[From: " + message.getFrom() + "] " + message.getBody());
//			}
//		});
//
//		System.out.print("Enter message: ");
//		String msg = stdin.nextLine();
//		while ( ! msg.startsWith("bye")) {
//			try {
//				newChat.sendMessage(msg);
//			} catch (XMPPException e) {
//				System.out.println("Error Delivering message");
//			}
//			System.out.print("Enter message: ");
//			msg = stdin.nextLine();
//		}
	}

}
