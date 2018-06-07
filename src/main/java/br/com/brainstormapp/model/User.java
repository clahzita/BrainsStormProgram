package br.com.brainstormapp.model;

/**
 * User
 */
public class User {
  private String username;
  private int votes;

  public User(String username) {
	  this.setUsername(username);
	  this.votes = 0;
  }

/**
 * @return the username
 */
public String getUsername() {
	return username;
}

/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}

public int getVotes() {
	return votes;
}

public void setVotes(int votes) {
	this.votes = votes;
}

}