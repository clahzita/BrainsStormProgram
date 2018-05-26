/**
 * 
 */
package br.com.brainstormapp.model;

/**
 * @author clarissa - clahzita@gmail.com
 *
 */
public class StormConfigImpl implements StormConfig {
	private boolean anonymous;
	private boolean voting;

	/* (non-Javadoc)
	 * @see br.com.brainstormapp.model.StormConfig#isAnonymous()
	 */
	public boolean isAnonymous() {
		return anonymous;
	}

	/* (non-Javadoc)
	 * @see br.com.brainstormapp.model.StormConfig#hasVoting()
	 */
	public boolean hasVoting() {
		return voting;
	}

	/* (non-Javadoc)
	 * @see br.com.brainstormapp.model.StormConfig#votingLimit()
	 */
	public Integer votingLimit() {
		return null;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public void setHasVoting(boolean voting) {
		this.voting = voting;
	}

}
