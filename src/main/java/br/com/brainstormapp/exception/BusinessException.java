/**
 * 
 */
package br.com.brainstormapp.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author req_04
 * @since 05.25.2018
 */
public class BusinessException extends Exception {
	private List<String> errors = new ArrayList<String>();
	
	public BusinessException(String msg) {
		
		super(msg);
	}
	
	public BusinessException() {
	}

	public void addMensageToList(String errorMensage) {
		this.errors.add(errorMensage);
	}
	
	public List<String> getErrorsMensages() {
		return this.errors;
	}

}
