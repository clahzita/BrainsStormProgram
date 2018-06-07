package br.com.brainstormapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Session
 */
public class Session {

  private User owner;
  private String description;
  private SessionPhase phase;
  public final int votingLimit = 3;
  private List<Idea> ideas;
  private List<User> participants;

  public Session(User owner) {
	  this.setOwner(owner);
	  this.phase = SessionPhase.WELCOME;
	  this.ideas = new ArrayList<>();
	  this.participants = new ArrayList<>();
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
	 if(this.phase == SessionPhase.BRAINSTORM && this.isParticipant(idea.getAuthor())) {
		 System.out.println("ideia vai inseririr?");
		 return this.ideas.add(idea);
	 }
	  return false;
  }

  public List<Idea> getIdeas() {
    return ideas;
  }

  public List<Idea> rankIdeas() {
	  List<Idea> rank = new ArrayList<>();
	  for (Idea idea : rank) {
		if(idea.countVotes()>0) {
			rank.add(idea);
		}
	  }
	 //TODO ordenar a lista de rank em ordem decrescente de número de votos
    return rank;
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
  
  public boolean isParticipant(User user) {
	  if(this.participants.isEmpty() || this.participants == null) {
		  return false;
	  }
	  
	  System.out.println("oi");
	  
	  for (User participant : participants) {
		  if(participant.getUsername().equals(user.getUsername())) {
			  return true;
		  }
	}
	  
	  return false;
  }

  public List<User> getParticipants() {
    return participants;
  }

  

	


}