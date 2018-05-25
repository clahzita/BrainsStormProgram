package br.com.brainstormapp;

import br.com.brainstormapp.exception.BusinessException;
import br.com.brainstormapp.model.Idea;
import br.com.brainstormapp.model.User;
import br.com.brainstormapp.model.IdeaImpl;
import br.com.brainstormapp.model.UserImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws BusinessException
    {
        Idea idea = new IdeaImpl();
        
        assert idea.getVoters().isEmpty();
        
        //Inserção de votante com a lista vazia
        User voter1 = new UserImpl();
        voter1.setUsername("clah");
        idea.vote(voter1);
        assert idea.getVoters().get(1).getUsername() == voter1.getUsername();
        
        //Inserção de votante com a lista não vazia
        User voter2 = new UserImpl();
        voter2.setUsername("felipe");
		idea.vote(voter2);
		assert idea.getVoters().size() == 1;
		assert idea.getVoters().contains(voter2);
		
//		//Remoção com elementos na lista
//		idea.unvote(voter1);
//		
//		//Remoção com a lista vazia
//		IIdea idea2 = new Idea();
//		idea2.unvote(voter1);
//		
//		//Remoção com referência errada
//		idea.unvote(new IUser());
//		
//		//Inserção de usuário que já votou na ideia
//        idea.vote(voter1);

        System.out.println("Passou nos testes!");

        
        		
    }
}
