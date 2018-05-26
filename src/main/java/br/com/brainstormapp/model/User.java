/**
 * 
 */
package br.com.brainstormapp.model;

import br.com.brainstormapp.exception.BusinessException;

/**
 * @author clarissa - clahzita@gmail.com
 *
 */
public abstract class User {
	
	private String username;
	private String fullname;
	private String photoUrl;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public abstract void validate() throws BusinessException;
	
	

}
