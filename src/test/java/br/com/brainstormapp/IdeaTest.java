package br.com.brainstormapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.brainstormapp.model.Idea;
import br.com.brainstormapp.model.Session;
import br.com.brainstormapp.model.User;

/**
 * IdeaTest
 */
public class IdeaTest {
  Idea idea1, idea2, idea3, idea4;
  User author1, author2, author3, author4, voter1, voter2;

  @Before
  public void setUp() {
    author1 = new User("joao");
    this.idea1 = new Idea(author1, "An idea");
    author2 = new User("maria");
    this.idea2 = new Idea(author1, "Another idea");
    author3 = new User("jose");    
    this.idea3 = new Idea(author1, "Another idea different");
    author4 = new User("chico");    
    this.idea4 = new Idea(author1, "Another idea different the others");
    
    voter1 = new User("antonio");
    voter2 = new User("dalva");
    
  }
  
  @Test
  public void creation() {
	  //Quando uma ideia é criada seu ator deve ser o mesmo que foi passado na sua criação
	  assertEquals("joao",this.idea1.getAuthor().getUsername());
	  //a lista de votantes na ideia esta vazia
	  assertTrue(idea1.getVoters().isEmpty());
  }
  
  @Test
  public void countVotes() {
	  //os votos permanecem inalterado se a sessão não estiver na fase de votação.
	  Session session =  new Session(author1);
	  session.addParticipant(author1);
	  session.addIdea(idea1);
	  this.idea1.setSession(session);
	  this.idea1.registerVote(voter1);
	  assertTrue(idea1.getVoters().isEmpty());
	  //Os votos permanecem inalterados se o votante não estiver participando da sessão
	  this.idea1.getSession().nextPhase(); //brainstorm
	  this.idea1.getSession().nextPhase(); //voting
	  this.idea1.registerVote(voter1);
	  assertTrue(idea1.getVoters().isEmpty());
	  //Os votos permanecem inalterados se o votante for o autor da ideia
	  this.idea1.registerVote(author1);
	  assertTrue(idea1.getVoters().isEmpty());
	  //Os votos permanecem inalterados se o votante já tiver alcançado o limite de votos
	  session.addParticipant(voter1);
	  this.idea1.registerVote(voter1);// um voto
	  session.addIdea(idea2);
	  this.idea2.setSession(session);
	  this.idea2.registerVote(voter1);// dois votos
	  session.addIdea(idea3);
	  this.idea3.setSession(session);
	  this.idea3.registerVote(voter1);// três votos
	  session.addIdea(idea4);
	  this.idea4.setSession(session);
	  this.idea4.registerVote(voter1);// quarto voto, não pode.
	  assertTrue(idea4.getVoters().isEmpty());
	  //Nos demais casos, a ideia deve ser cadastrada.
	  assertEquals(1,idea1.getVoters().size());
	  
	  
	  
	  
  }

  @Test
  public void shouldConsiderVote() {
  }
  
}