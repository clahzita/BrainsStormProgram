package br.com.brainstormapp;

import br.com.brainstormapp.model.Idea;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IIdea idea = new Idea();
        
        assert idea.getVoters().isEmpty();
        
        //Inserção de votante com a lista vazia
        IUser voter1 = new User();
        voter1.setUsername("clah");
        idea.vote(voter1);
        assert idea.getVoters().get(1).getUsername() == voter1.getUsername();
        
        //Inserção de votante com a lista não vazia
        IUser voter2 = new User();
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
