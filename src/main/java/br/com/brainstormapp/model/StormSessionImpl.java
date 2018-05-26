/**
 * 
 */
package br.com.brainstormapp.model;

import br.com.brainstormapp.exception.BusinessException;

/**
 * @author clarissa - clahzita@gmail.com
 *
 */
public class StormSessionImpl extends StormSession {
	
	/* (non-Javadoc)
	 * @see br.com.brainstormapp.model.StormSession#addIdeas(br.com.brainstormapp.model.Idea)
	 */
	@Override
	public void addIdea(Idea idea) {
		idea.validate();
		getIdeas().add(idea);

	}


	/* (non-Javadoc)
	 * @see br.com.brainstormapp.model.StormSession#addParticipant(br.com.brainstormapp.model.User)
	 */
	@Override
	public void addParticipant(User participant) throws BusinessException {
		participant.validate();
		getParticipants().add(participant);
	}

	/* (non-Javadoc)
	 * @see br.com.brainstormapp.model.StormSession#removeParticipant(br.com.brainstormapp.model.User)
	 */
	@Override
	public void removeParticipant(User participant) throws BusinessException {
		if(getParticipants().contains(participant)) {
			getParticipants().remove(participant);
		}else {
			throw new BusinessException("Participant do not register at this session.");
		}
	}


}
