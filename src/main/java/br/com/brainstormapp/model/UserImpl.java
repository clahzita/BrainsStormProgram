/**
 * 
 */
package br.com.brainstormapp.model;

import br.com.brainstormapp.exception.BusinessException;

/**
 * @author clah
 * @since 18.05.2018
 */
public class UserImpl extends User {
	private BusinessException businessException = new  BusinessException();
	
	@Override
	public void validate() throws BusinessException {
		if(this.getUsername().isEmpty() || this.getUsername() == null) {
			businessException.addMensageToList("Username is not defined.");
		}
		
		if(this.getFullname().isEmpty() || this.getFullname() == null) {
			businessException.addMensageToList("Fullname is not defined.");			
		}
		
		if(!businessException.getErrorsMensages().isEmpty()) {
			throw new BusinessException();
		}
	}

}
