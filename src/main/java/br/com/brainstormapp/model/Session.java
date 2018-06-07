package br.com.brainstormapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Session
 */
public class Session {

  private User owner;
  String description;
  SessionPhase phase;
  int votingLimit = 3;
  List<Idea> ideas;
  List<User> participants;

  public Session(User owner) {
	  this.setOwner(owner);
	  this.phase = SessionPhase.WELCOME;
	  this.ideas = new ArrayList<>();
	  this.participants = new ArrayList<>();
  }

  public SessionPhase nextPhase() {
	  if(this.phase != SessionPhase.RANK) {
		  this.phase = this.phase.values()[this.phase.ordinal()+1];
	  }
    return this.phase;
  }

  public SessionPhase getPhase() {
    return phase;
  }
  
  public boolean addIdea(Idea idea) {
    return false;
  }

  public List<Idea> getIdeas() {
    return ideas;
  }

  public List<Idea> rankIdeas() {
    return null;
  }

  public boolean addParticipant(User participant) {
	  if(this.phase == SessionPhase.WELCOME && !this.participants.contains(participant)) {
		  this.participants.add(participant);
		  return true;
	  }
    return false;
  }

  public boolean removeParticipant(User participant) {
    return participants.remove(participant);
  }

  public List<User> getParticipants() {
    return participants;
  }

/**
 * @return the owner
 */
public User getOwner() {
	return owner;
}

/**
 * @param owner the owner to set
 */
public void setOwner(User owner) {
	this.owner = owner;
}

}