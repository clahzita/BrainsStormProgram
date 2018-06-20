package br.com.brainstormapp.model;

/**
 * This class implements the entity User, who is the person who uses the program.
 */
public class User {
  private String username;
  private int votes;

  public User(String username) {
    this.setUsername(username);
    this.votes = 0;
  }
  
  /**
   * Returns the user name.
   * @return the user name.
   */
  public String getUsername() {
    return username;
  }
  
  /**
   * Sets the user name.
   * @param username the new user name to be set.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Returns the amount of times the user voted on ideas.
   * @return the number of votes that the user done.
   */
  public int getVotes() {
    return votes;
  }

  /**
   * Sets the number of votes.
   * @param votes the number of votes to be set.
   */
  public void setVotes(int votes) {
    this.votes = votes;
  }

}
