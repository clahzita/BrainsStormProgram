package br.com.brainstormapp;

import org.junit.Before;
import org.junit.Test;

import br.com.brainstormapp.model.Idea;
import br.com.brainstormapp.model.User;

/**
 * IdeaTest
 */
public class IdeaTest {
  Idea idea;
  User user1, user2;

  @Before
  public void setUp() {
    user1 = new User("fulano");
    user2 = new User("cicrano");
    this.idea = new Idea(user1, "An idea");
  }

  @Test
  public void countVotes() {
  }

  @Test
  public void shouldConsiderVote() {
  }
  
}