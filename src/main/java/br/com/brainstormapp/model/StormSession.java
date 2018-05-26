/**
 * 
 */
package br.com.brainstormapp.model;

import java.util.ArrayList;
import java.util.List;

import br.com.brainstormapp.exception.BusinessException;

/**
 * @author clarissa - clahzita@gmail.com
 * @since 05.25.2018
 */
public abstract class StormSession {
	
	private List<Idea> ideas = new ArrayList<Idea>();
	private List<User> participants =  new ArrayList<User>();
	private User owner;
	private StormConfig config;
	private String goal;
	private String description;
	
	
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

	/**
	 * @return the config
	 */
	public StormConfig getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(StormConfig config) {
		this.config = config;
	}

	
	
	/**
	 * @return the ideas
	 */
	public List<Idea> getIdeas() {
		return ideas;
	}


	/**
	 * @param ideas the ideas to set
	 */
	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

	/**
	 * @return the participants
	 */
	public List<User> getParticipants() {
		return participants;
	}
	
	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}
	
	/**
	 * @return the goal
	 */
	public String getGoal() {
		return goal;
	}

	/**
	 * @param goal the goal to set
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Add idea in the storm session.
	 * @param idea to be add in the storm session.
	 */
	public abstract void addIdea(Idea idea);
	
	/**
	 * Add participant in the storm session.
	 * @param participant the participant to be added.
	 * @throws BusinessException 
	 */
	public abstract void addParticipant(User participant) throws BusinessException;
	
	/**
	 * Remove a participant from storm idea.
	 * @param participant
	 * @throws BusinessException If the participant is not register in the storm session.
	 */
	public abstract void removeParticipant(User participant) throws BusinessException;


}
