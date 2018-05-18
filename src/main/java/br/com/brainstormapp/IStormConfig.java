/**
 * 
 */
package br.com.brainstormapp;

/**
 * @author clah
 * @since 18.05.2018
 */
public interface IStormConfig {
	
	public boolean isAnonymous();
	public boolean hasVoting();
	public Integer votingLimit();

}
