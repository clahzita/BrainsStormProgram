/**
 * 
 */
package br.com.brainstormapp.model;

import br.com.brainstormapp.exception.BusinessException;

/**
 * @author clarissa - clahzita@gmail.com
 * @since 02.25.2018
 */
public class IdeaImpl extends Idea {

	@Override
	public void vote(User voter) throws BusinessException {
		if(super.getVoters().contains(voter)) {
			throw new BusinessException ("Your vote had already compute in this idea");
		}else {
			super.getVoters().add(voter);
		}
		
	}

	@Override
	public void unvote(User voter) throws BusinessException {
		if(super.getVoters().contains(voter)) {
			throw new BusinessException ("You can't unvote in an idea that you not vote");
		}else {
			super.getVoters().remove(voter);
		}
		
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}
	

}
