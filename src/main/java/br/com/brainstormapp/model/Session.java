package br.com.brainstormapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Session entity, that is a place to practice brainstorm, 
 * that is a dynamic group technique to explore the creativity of an individual or group.
 */
public class Session {
  static final int VOTING_LIMIT = 3;

  private User owner;
  private String description;
  private SessionPhase phase;

  private List<Idea> ideas;
  private List<User> participants;
  
  /**
   * The session has to initialize with an owner and the phase is set to be "Welcome".
   * @param owner It's the user who manage the session.
   */
  public Session(User owner) {
    this.setOwner(owner);
    this.phase = SessionPhase.WELCOME;
    this.ideas = new ArrayList<>();
    this.participants = new ArrayList<>();
  }

  /**
   *  Returns the owner.
   *  @return the session owner.
   */ 
  public User getOwner() {
    return owner;
  }

  /**
   *  Sets the owner. 
   *  @param owner the new owner.
   */
  public void setOwner(User owner) {
    this.owner = owner;
  }

  /**
   *  Returns the description. 
   *  @return the idea description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description. 
   * @param description the new description of the idea.
   */
  public void setDescription(String description) {
    this.description = description;
  }
  
  /**
   * Returns the session participants list.
   * @return the User list of participants.
   */
  public List<User> getParticipants() {
    return participants;
  }

  /**
   * Returns the phase where session is.
   * @return the phase of the session.
   */
  public SessionPhase getPhase() {
    return phase;
  }

  /**
   * Returns the session ideas list.
   * @return the Idea list of the session.
   */
  public List<Idea> getIdeas() {
    return ideas;
  }


  /**
   * Calls the next session phase.
   * @return The phase correspondent to the next phase after the current one.
   */
  public SessionPhase nextPhase() {
    if (this.phase != SessionPhase.RANK) {
      this.phase = SessionPhase.values()[this.phase.ordinal() + 1];
    }
    return this.phase;
  }



  /**
   * Tries to add the idea to the session when it's in the "Brainstorm" phase.
   * @param idea It's the idea that the author is session participant.
   * @return true, if the idea was iserted successfully, false, if not.
   */
  public boolean addIdea(Idea idea) {
    if (this.phase == SessionPhase.BRAINSTORM && this.isParticipant(idea.getAuthor())) {
      return this.ideas.add(idea);
    }
    return false;
  }


  /**
   * Returns an idea list sorted by number of votes, in descending order.
   * @return the sorted idea list.
   */
  public List<Idea> rankIdeas() {

    List<Idea> rank = new ArrayList<>();
    for (Idea idea : ideas) {
      if (idea.countVotes() > 0) {
        rank.add(idea);
      }
    }
    
    rank.sort((a,b) -> a.compareTo(b));
    
    rank.forEach(i -> System.out.printf("%d,%s\n",i.countVotes(),i.getDescription()));
    
    return rank;
  }

  /**
   * Adds a user in the session as a participant in the participants list.
   * @param participant the user who participates in the session.
   * @return true, if the user has been added, false if not.
   */
  public boolean addParticipant(User participant) {
    if (this.phase == SessionPhase.WELCOME && !this.participants.contains(participant)) {
      this.participants.add(participant);
      return true;
    }
    return false;
  }
  
  /**
   * Removes a participant from the participants list.
   * @param participant the user to be removed..
   * @return true, if the user has been removed, false if not.
   */
  public boolean removeParticipant(User participant) {
    if (this.participants.isEmpty()) {
      return false;
    }
    return participants.remove(participant);
  }

  /**
   * Verifies if an user is a session participant.
   * @param user the user to verify if is or not a participant of this session.
   * @return true, if the user is a session participant, false, if  doesn't.
   */
  public boolean isParticipant(User user) {
    if (this.participants.isEmpty()) {
      return false;
    }

    for (User participant : participants) {
      if (participant.getUsername().equals(user.getUsername())) {
        return true;
      }
    }

    return false;
  }



}
