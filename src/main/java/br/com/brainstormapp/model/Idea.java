package br.com.brainstormapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Idea
 */
public class Idea {
  private Session session;
  private String description;
  private User author;
  private List<User> voters;

  public Idea(User author, String description) {
	  this.author = author;
	  this.description = description;
	  voters = new ArrayList<>();
  }
  
  public Session getSession() {
	return session;
  }
  
  public void setSession(Session session) {
	this.session = session;
  }
  
  public String getDescription() {
	return description;
  }
  
  public List<User> getVoters() {
	return voters;
  }
  
  public void registerVote(User voter) {
	  if(session.getPhase() == SessionPhase.VOTING
			  && this.session.isParticipant(voter) 
			  && !voter.getUsername().equals(this.author.getUsername()) 
			  && voter.getVotes() < Session.VOTING_LIMIT
			  && !this.alreadyIsVoter(voter)) {
		  voter.setVotes(voter.getVotes()+1);
		  voters.add(voter);
	  }
	 	  
  }

  public void reclaimVote(User voter) {
	  if(alreadyIsVoter(voter) && this.session.getPhase() == SessionPhase.VOTING) {
		  voters.remove(voter);
	  }

  }
  
  
  public int countVotes() {
    return voters.size();
  }
  
  public User getAuthor() {
	return author;
  }
  
  public boolean alreadyIsVoter(User user) {
	  if(this.voters.isEmpty() || this.voters == null) {
		  return false;
	  }
	  
	  for (User voter : voters) {
		  if(voter.getUsername().equals(user.getUsername())) {
			  return true;
		  }
	}
	  
	  return false;
  }

  
}