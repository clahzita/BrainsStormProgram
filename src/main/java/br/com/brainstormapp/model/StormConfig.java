/**
 * 
 */
package br.com.brainstormapp.model;

/**
 * @author clah
 * @since 18.05.2018
 */
public interface StormConfig {
	
	public boolean isAnonymous();
	public boolean hasVoting();
	public Integer votingLimit();

}
