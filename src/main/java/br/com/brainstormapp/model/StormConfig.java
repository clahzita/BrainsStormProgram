/**
 * 
 */
package br.com.brainstormapp.model;

/**
 * @author clah
 * @since 18.05.2018
 */
public interface StormConfig {
	/**
	 * Configure the storm session as anonymous.
	 * @return true, if is anonumous or false, if not.
	 */
	public boolean isAnonymous();
	
	/**
	 * Set the storm session as anonymous or not.
	 * @param anonymous true if is anonymous, false if not.
	 */
	public void setAnonymous(boolean anonymous);
	
	/**
	 * Show if the idea as open to voting.
	 * @return true, is has voting, or false, if not.
	 */
	public boolean hasVoting();
	
	/**
	 * Set the storm session as open voting, or not.
	 * @param voting true if has voting, false if not.
	 */
	public void setHasVoting(boolean voting);
	
	/**
	 * Shows the limit of voting.
	 * @return the number of limit vote.
	 */
	public Integer votingLimit();
	
	

}
