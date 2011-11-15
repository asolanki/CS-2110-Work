package edu.virginia.cs2110;

import java.util.ArrayList;
import java.util.Collection;
import org.jivesoftware.smack.*;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.*;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public class Client {
	private String username;
	private String password;

	private Roster roster;
	private Collection<RosterEntry> buddies;
	private Collection<RosterGroup> groups;

	private ArrayList<Buddy> buddyList;

	public Client(String user, String pass) {
		username = user;
		password = pass;
		connectClient(username, password);
	}

	private void connectClient(String user, String pass) {
		System.out.println("Welcome to Gtalk app");

		ConnectionConfiguration test = new ConnectionConfiguration(
				"talk.google.com", 5222, "gmail.com");

		XMPPConnection connection = new XMPPConnection(test);

		// "cs2110test@gmail.com" :: "softwaredevelopment"

		try {
			System.out.println("Attempting to connect...");
			connection.connect();

			System.out.println("Attempting to login...");
			connection.login(user, pass);

			System.out.println("   Login successful? "
					+ connection.isAuthenticated());
		} catch (XMPPException e1) {
			System.out.println("Error connecting");
			e1.printStackTrace();
		}

		buddyList = new ArrayList<Buddy>();
		
		roster = connection.getRoster();
		buddies = roster.getEntries();
//		groups = roster.getGroups();

		ArrayList<String> groupList;
		
		//populate buddyList
		for (RosterEntry entry : buddies) {
			groupList = new ArrayList<String>();
			groups = entry.getGroups();
			
			
			for (RosterGroup group : groups) {
				groupList.add(group.getName());
				
			}
			
			if (groupList.size() > 0) System.out.println(groupList);
			

			Buddy buddy = new Buddy(entry.getName(), entry.getUser(), groupList);
			buddyList.add(buddy);
			groupList.removeAll(groupList);
		}
		
		System.out.println("buddylist:");
		
		for (Buddy b : buddyList) {
			System.out.println(b.getScreenname());
		}
		
		MainGui gui = new MainGui();
		
		
		//now pass buddyList to MainGui?  Then make a JList from the list?

				// System.out.println("Initializing Chat Manager...");
				// ChatManager chatmanager = connection.getChatManager();
				//
				// System.out.println("Starting chat...");
				// Chat newChat = chatmanager.createChat(chat, new MessageListener() {
				// public void processMessage(Chat chat, Message message) {
				// System.out.println("\n[From: " + message.getFrom() + "] " +
				// message.getBody());
				// }
				// });
				//
				//
				// System.out.print("Enter message: ");
				// String msg = in.nextLine();
				// while ( ! msg.startsWith("bye")) {
				// try {
				// newChat.sendMessage(msg);
				// } catch (XMPPException e) {
				// System.out.println("Error Delivering message");
				// }
				// System.out.print("Enter message: ");
				// msg = in.nextLine();
				// }

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roster getRoster() {
		return roster;
	}

	public void setRoster(Roster roster) {
		this.roster = roster;
	}

	public Collection<RosterEntry> getBuddies() {
		return buddies;
	}

	public void setBuddies(Collection<RosterEntry> buddies) {
		this.buddies = buddies;
	}

	public Collection<RosterGroup> getGroups() {
		return groups;
	}

	public void setGroups(Collection<RosterGroup> groups) {
		this.groups = groups;
	}

}
