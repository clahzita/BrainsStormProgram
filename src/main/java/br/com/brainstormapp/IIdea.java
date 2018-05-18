/**
 * 
 */
package br.com.brainstormapp;

import java.util.List;

/**
 * @author clah
 * @since 18.05.2018
 */
public abstract class IIdea {
	private String text;
	private IUser author;
	private List<IUser> voters;
	
	public void vote(IUser voter) {
	}
	
	public void unvote(IUser voter) {
	}

	public List<IUser> getVoters() {
		return voters;
	}
	
}
