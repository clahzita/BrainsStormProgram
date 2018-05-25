/**
 * 
 */
package br.com.brainstormapp.model;

import java.util.List;

import br.com.brainstormapp.exception.BusinessException;

/**
 * @author clah
 * @since 18.05.2018
 */
public abstract class Idea {
	private String text;
	private User author;
	private List<User> voters;
	
	public abstract void vote(User voter) throws BusinessException;
	
	public abstract void unvote(User voter) throws BusinessException;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<User> getVoters() {
		return voters;
	}
	
	
}
