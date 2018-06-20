package br.com.brainstormapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import br.com.brainstormapp.model.Idea;
import br.com.brainstormapp.model.Session;
import br.com.brainstormapp.model.User;
import org.junit.Before;
import org.junit.Test;


/**
 * Implements tests to the Idea class.
 */
public class IdeaTest {
  Session session;
  Idea idea1;
  Idea idea2;
  Idea idea3;
  Idea idea4;
  User author1;
  User author2;
  User author3;
  User author4;
  User voter1;
  User voter2;

  /**
   * This method is called in the begin of each method test to set up the objects 
   * to use in the test cases.
   */
  
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

    session = new Session(author1);
    configureSession(session);

  }

  /**
   * Configures a session with participants and ideas.
   * @param session the session to be configured.
   */
  private void configureSession(Session session) {
    session.addParticipant(author1);
    session.addParticipant(author2);
    session.addParticipant(author3);
    session.addParticipant(author4);
    session.addParticipant(voter1);
    session.nextPhase(); // brainstorm para adicionar ideias
    session.addIdea(idea1);
    session.addIdea(idea2);
    session.addIdea(idea3);
    session.addIdea(idea4);
    this.idea1.setSession(session);
    this.idea2.setSession(session);
    this.idea3.setSession(session);
    this.idea4.setSession(session);

  }

  /**
   * Performs case tests to session creation. 
   */
  @Test
  public void creation() {
    // Quando uma ideia é criada seu ator deve ser o mesmo que foi passado na sua
    // criação
    assertEquals("joao", this.idea1.getAuthor().getUsername());
    // a lista de votantes na ideia esta vazia
    assertTrue(idea1.getVoters().isEmpty());
  }
  
  /**
   * Performs tests to the registerVote method.
   */
  @Test
  public void registerVote() {

    // os votos permanecem inalterado se a sessão não estiver na fase de votação.

    this.idea1.registerVote(voter1);
    assertTrue(idea1.getVoters().isEmpty());

    // Os votos permanecem inalterados se o votante não estiver participando da
    // sessão
    this.idea1.getSession().nextPhase(); // voting
    this.idea1.registerVote(voter2);
    assertTrue(idea1.getVoters().isEmpty());

    // Os votos permanecem inalterados se o votante for o autor da ideia
    this.idea1.registerVote(author1);
    assertTrue(idea1.getVoters().isEmpty());

    // Casos que a ideia é cadastrada na lista de votantes e tamanho da lista é
    // incrementado
    this.idea1.registerVote(voter1);// um voto
    assertEquals(1, idea1.getVoters().size());
    assertTrue(idea1.alreadyIsVoter(voter1));

    this.idea1.registerVote(author2);
    assertEquals(2, idea1.getVoters().size());
    assertTrue(idea1.alreadyIsVoter(author2));

    this.idea2.registerVote(voter1);// dois votos
    assertEquals(1, idea2.getVoters().size());
    assertTrue(idea2.alreadyIsVoter(voter1));

    this.idea3.registerVote(voter1);// três votos
    assertEquals(1, idea2.getVoters().size());
    assertTrue(idea2.alreadyIsVoter(voter1));

    // Os votos permanecem inalterados se o votante já votou na ideia uma vez.
    this.idea1.registerVote(voter1);
    assertEquals(2, idea1.getVoters().size());

    // Os votos permanecem inalterados se o votante já tiver alcançado o limite de
    // votos da sessão.
    assertEquals(3, voter1.getVotes());
    this.idea4.registerVote(voter1);// quarto voto, não pode.
    assertTrue(idea4.getVoters().isEmpty());

  }

  /**
   * Performs tests to reclainVote method.
   */
  @Test
  public void reclaimVote() {

    session.nextPhase(); // voting
    this.idea1.registerVote(voter1);
    this.idea1.registerVote(author2);
    this.idea1.registerVote(author3);
    assertEquals(3, idea1.countVotes());
    // Caso seja solicitação de um votante da ideia e estiver na fase de votação,
    // deve-se remover-lo
    this.idea1.reclaimVote(voter1);
    assertFalse(idea1.alreadyIsVoter(voter1));
    assertEquals(2, idea1.countVotes());

    // Os votos permanecem inalterados se quem quer remover o voto não estiver na
    // lista de votantes da ideia
    this.idea1.reclaimVote(author4);
    assertEquals(2, idea1.countVotes());

    session.nextPhase();

    // Os votos permanecem inalterados se a sessão não estiver na fase de votação
    this.idea1.reclaimVote(author3);
    assertEquals(2, idea1.countVotes());

  }

}
