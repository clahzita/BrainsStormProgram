package br.com.brainstormapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.brainstormapp.model.Session;
import br.com.brainstormapp.model.SessionPhase;
import br.com.brainstormapp.model.User;

/**
 * SessionTest
 */
public class SessionTest {
  User[] users = {
    new User("Fulano"),
    new User("Cicrano"),
    new User("Beltrano")
  };
  private Session session = new Session(users[0]);
  private User participant1;
  
   @Before
   public void setUp() {
     User owner = new User("Fulano");
     this.session = new Session(owner);   
     participant1 = new User("joao");
   }

  /**
   * Na criação de um objeto
   */
  @Test
  public void creation() {
	  String expected = "Fulano";
	  String actual = session.getOwner().getUsername();
	  //A sessão deve ser criada com o proprietário igual o passado na sua criação
	  assertEquals(expected, actual);
	  //A sessão deve ser criada na fase de acolhimento (welcome)
	  assertEquals(SessionPhase.WELCOME,session.getPhase());
	  //A lista de ideias deve estar vazia
	  assertTrue(session.getIdeas().isEmpty());
	  //A lista de participantes deve estar vazia
	  assertTrue(session.getParticipants().isEmpty());
	  
  }

  @Test
  public void nextPhase() {
	  session.nextPhase();
	  //Se estiver na fase de acolhimento de participantes (welcome), a sessão passa para a fase de brainstorm
	  assertEquals(SessionPhase.BRAINSTORM,session.getPhase());
	  //Se estiver na fase de brainstorm, a sessão passa para a fase de votação
	  session.nextPhase();
	  assertEquals(SessionPhase.VOTING,session.getPhase());
	  //Se estiver na fase de votação, a sessão passa para a fase de encerramento (ranking)
	  session.nextPhase();
	  assertEquals(SessionPhase.RANK,session.getPhase());
	  //Se estiver na fase de encerramento, não ocorre nada, permanece na fase de encerramento.
	  session.nextPhase();
	  assertEquals(SessionPhase.RANK,session.getPhase());
	  
  }

  @Test
  public void addParticipant() {
  	  //Usuário passa a fazer parte da lista de participantes e tamanho da lista é incrementado de 1.
	  session.addParticipant(participant1);
	  assertTrue(session.getParticipants().contains(participant1));
	  assertEquals(1,session.getParticipants().size());	  
	  //Não há alteração da lista se o particpante já foi registrado.
	  session.addParticipant(participant1);
	  assertEquals(1, session.getParticipants().size());
	  //Não há alteração da lista se a sessão não está na fase de acolhimento.  
	  session.nextPhase();
	  session.addParticipant(new User("Maria"));	 
	  assertEquals(1, session.getParticipants().size());
	
	  
  }
  
  @Test
  public void removeParticipant() {
	  //A lista permanece inalterada quando se tenta remover um participante que não está registrado.
	  assertFalse(session.removeParticipant(participant1));
	  //Usuário deixa de fazer parte da lista de participantes e tamaho é decrementado de 1.
	  session.addParticipant(participant1);
	  assertEquals(1, session.getParticipants().size());
	  session.removeParticipant(participant1);
	  assertEquals(0, session.getParticipants().size());
	  
	  
  }
}