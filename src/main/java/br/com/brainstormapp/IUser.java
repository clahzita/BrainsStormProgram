/**
 * 
 */
package br.com.brainstormapp;

/**
 * @author clah
 *
 */
public abstract class IUser {
	
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
	public void setFullname(String fullnse) {
		this.fullname = fullname;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
	

}
