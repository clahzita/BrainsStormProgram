/**
 * 
 */
package br.com.brainstormapp.model;

import java.util.ArrayList;
import java.util.List;

import br.com.brainstormapp.exception.BusinessException;

/**
 * @author clah
 * @since 18.05.2018
 */
public abstract class Idea {
	private String text;
	private User author;
	private List<User> voters = new ArrayList<User>();
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}

	/**
	 * @return the voters
	 */
	public List<User> getVoters() {
		return voters;
	}

	/**
	 * @param voters the voters to set
	 */
	public void setVoters(List<User> voters) {
		this.voters = voters;
	}

	public abstract void vote(User voter) throws BusinessException;
	
	public abstract void unvote(User voter) throws BusinessException;
	
	public abstract void validate();
	
	
}
