package br.com.brainstormapp.model;

/**
 * User
 */
public class User {
  private String username;
  int votes;

  public User(String username) {
	  this.setUsername(username);
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
}