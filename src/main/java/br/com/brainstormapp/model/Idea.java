package br.com.brainstormapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Idea entity, that is an idea added on the session.
 */
public class Idea implements Comparable<Idea> {
  private Session session;
  private String description;
  private User author;
  private List<User> voters;

  /**
   * Creates an Idea object.
   * @param author The user that is the idea author.
   * @param description A text with idea description
   */
  public Idea(User author, String description) {
    this.author = author;
    this.description = description;
    voters = new ArrayList<>();
  }

  /**
   * Gets the object session idea.
   * @return session The session idea object where it's in.
   */
  public Session getSession() {
    return session;
  }

  /**
   * Sets the session idea.
   * @param session The session to be set.
   */
  public void setSession(Session session) {
    this.session = session;
  }

  /** Returns the idea description.
   * @return description that is a text with idea detail.
   */
  public String getDescription() {
    return description;
  }
 
  /** Returns a list with all users who voted for the idea.
   * @return description that is a text with idea detail.
   */
  public List<User> getVoters() {
    return voters;
  }

  /**
   * Registers the vote for the idea when the session is in the Voting Phase.
   * @param voter   It's the voter who not can be the idea author and must to be a session 
   *                participant.The voter can not register vote more than once in the idea and more
   *                than three times on the session.
   */
  public void registerVote(User voter) {
    if (session.getPhase() == SessionPhase.VOTING && this.session.isParticipant(voter)
        && !voter.getUsername().equals(this.author.getUsername())
        && voter.getVotes() < Session.VOTING_LIMIT && !this.alreadyIsVoter(voter)) {
      voter.setVotes(voter.getVotes() + 1);
      voters.add(voter);
    }

  }

  /**
   * Reclaims the vote for the idea when the session is in the Voting Phase.
   * @param voter the user that already is a voter in the idea.
   */
  public void reclaimVote(User voter) {
    if (alreadyIsVoter(voter) && this.session.getPhase() == SessionPhase.VOTING) {
      voters.remove(voter);
    }

  }
  
  /**
   * Counts the number of votes for the idea.
   * @return The quantity of votes.
   */
  public int countVotes() {
    return voters.size();
  }

  /**
   * Returns the idea author user.
   * @return the idea author.
   */
  public User getAuthor() {
    return author;
  }
  
  /**
   * Checks if the user is or not a voter.
   * @param user the user that's going to be checked.
   * @return true, if it's a voter, false it's not.
   */
  public boolean alreadyIsVoter(User user) {
    if (this.voters.isEmpty()) {
      return false;
    }

    for (User voter : voters) {
      if (voter.getUsername().equals(user.getUsername())) {
        return true;
      }
    }
    return false;
  }
  /**
   * Compares the idea by number of votes.
   * @param otherIdea the other idea idea do compare to.
   * @return the number that represents the order.
   */
  
  @Override
  public int compareTo(Idea otherIdea) {
    if (this.countVotes() > otherIdea.countVotes()) {
      return -1;
    }
    
    if (this.countVotes() < otherIdea.countVotes()) {
      return 1;
    }
    return 0;
  }
}
