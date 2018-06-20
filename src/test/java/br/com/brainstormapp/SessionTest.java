package br.com.brainstormapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import br.com.brainstormapp.model.Idea;
import br.com.brainstormapp.model.Session;
import br.com.brainstormapp.model.SessionPhase;
import br.com.brainstormapp.model.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;




/**
 * Implements tests to the Session class.
 */
public class SessionTest {
  User[] users = {new User("Fulano"), new User("Cicrano"), new User("Beltrano")};
  private Session session = new Session(users[0]);
  private User participant1;

  @Before
  public void setUp() {

    participant1 = new User("joao");
  }

  /**
   * Performs tests to the session creation.
   */
  @Test
  public void creation() {
    String expected = "Fulano";
    String actual = session.getOwner().getUsername();
    // A sessão deve ser criada com o proprietário igual o passado na sua criação
    assertEquals(expected, actual);
    // A sessão deve ser criada na fase de acolhimento (welcome)
    assertEquals(SessionPhase.WELCOME, session.getPhase());
    // A lista de ideias deve estar vazia
    assertTrue(session.getIdeas().isEmpty());
    // A lista de participantes deve estar vazia
    assertTrue(session.getParticipants().isEmpty());

  }

  /**
   * Performs tests to the nextPhase method.
   */
  @Test
  public void nextPhase() {
    session.nextPhase();
    // Se estiver na fase de acolhimento de participantes (welcome), a sessão passa
    // para a fase de brainstorm
    assertEquals(SessionPhase.BRAINSTORM, session.getPhase());
    // Se estiver na fase de brainstorm, a sessão passa para a fase de votação
    session.nextPhase();
    assertEquals(SessionPhase.VOTING, session.getPhase());
    // Se estiver na fase de votação, a sessão passa para a fase de encerramento
    // (ranking)
    session.nextPhase();
    assertEquals(SessionPhase.RANK, session.getPhase());
    // Se estiver na fase de encerramento, não ocorre nada, permanece na fase de
    // encerramento.
    session.nextPhase();
    assertEquals(SessionPhase.RANK, session.getPhase());

  }

  /**
   * Performs tests to addParticipant method. 
   */
  @Test
  public void addParticipant() {
    // Usuário passa a fazer parte da lista de participantes e tamanho da lista é
    // incrementado de 1.
    session.addParticipant(participant1);
    assertTrue(session.getParticipants().contains(participant1));
    assertEquals(1, session.getParticipants().size());
    // Não há alteração da lista se o particpante já foi registrado.
    session.addParticipant(participant1);
    assertEquals(1, session.getParticipants().size());
    // Não há alteração da lista se a sessão não está na fase de acolhimento.
    session.nextPhase();
    session.addParticipant(new User("Maria"));
    assertEquals(1, session.getParticipants().size());

  }
  
  /**
   * Performs tests to removeParticipant method. 
   */
  @Test
  public void removeParticipant() {
    // A lista permanece inalterada quando se tenta remover um participante que não
    // está registrado.
    assertFalse(session.removeParticipant(participant1));
    // Usuário deixa de fazer parte da lista de participantes e tamaho é
    // decrementado de 1.
    session.addParticipant(participant1);
    assertEquals(1, session.getParticipants().size());
    session.removeParticipant(participant1);
    assertTrue(session.getParticipants().isEmpty());
  }

  /**
   * Performs tests to addIdea method. 
   */
  @Test
  public void addIdea() {
    // A lista de ideias é inalterada se a sessão não estiver na fase de brainstorm.
    session.addParticipant(participant1);
    Idea idea1 = new Idea(participant1, "Contar numero de participantes");
    session.addIdea(idea1);
    assertTrue(session.getIdeas().isEmpty());
    // A lista de ideias é inalterada se o autor da ideia não for uns dos
    // participantes.
    session.nextPhase();
    User participant2 = new User("Jose");
    Idea idea2 = new Idea(participant2, "Contar numero de ideias");
    session.addIdea(idea2);
    assertTrue(session.getIdeas().isEmpty());
    // Caso contrário a lista de ideias recebe a ideia e seu tamanho é incrementado de 1.
    System.out.println(session.getPhase().toString());
    assertTrue(session.addIdea(idea1));
    assertEquals(1, session.getIdeas().size());

  }

  /**
   * Performs tests to the rankIdeas method.
   */
  @Test
  public void rankideas() {
    System.out.println("fase da sessao: " + session.getPhase().name());
    session.addParticipant(participant1);
    User participant2 = new User("Jose");
    session.addParticipant(participant2);
    
    for (User user : users) {
      session.addParticipant(user);
    }
    
    //fase BRAINSTORM
    session.nextPhase();
    Idea idea1 = new Idea(participant1, "Ideia maravigold");
    idea1.setSession(session);
    session.addIdea(idea1);
    Idea idea2 = new Idea(participant1, "Ideia muito boa");
    idea2.setSession(session);
    session.addIdea(idea2);
    Idea idea3 = new Idea(participant1, "Ideia boa demais");
    idea3.setSession(session);
    session.addIdea(idea3);
    
    //Fase VOTING
    session.nextPhase();     
    //Atribuindo votos as ideias
    for (User participant : session.getParticipants()) {
      idea1.registerVote(participant);
    }
    
    int i = 0;
    for (User participant : session.getParticipants()) {
      if (i < 3) {
        idea2.registerVote(participant);
      }
      i++;
    }
    
    i = 0;
    for (User participant : session.getParticipants()) {
      if (i < 4) {
        idea3.registerVote(participant);
      }
      i++;
    }
        
    List<Idea> actuals = session.rankIdeas();
    List<String> ideasDescriptions = new ArrayList<>();
    for (Idea idea : session.getIdeas()) {
      ideasDescriptions.add(idea.getDescription());
    }
    
    assertEquals(idea1.getDescription(), actuals.get(0).getDescription());
    assertEquals(idea3.getDescription(), actuals.get(1).getDescription());
    assertEquals(idea2.getDescription(), actuals.get(2).getDescription());
  }

  
}
