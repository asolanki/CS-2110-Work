package edu.virginia.cs2110;

import java.util.List;

public class Buddy {

	private String screenname;
	private String email;
	List<String> groups;
	
	public Buddy(String screenname, String email, List<String> groups) {
		this.screenname = screenname;
		this.email = email;
		this.groups = groups;
	}
	
	public String getScreenname() {
		return screenname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public List<String> getGroups() {
		return groups;
	}
	
	public String toString() {
		return "Name: " + screenname + " Email: " + email + " Groups: " + groups;
	}
	
}
