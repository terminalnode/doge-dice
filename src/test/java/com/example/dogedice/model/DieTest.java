package com.example.dogedice.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {
  private void rollArbitraryDie(int sides) {
    System.out.println(String.format("Testing with %s-sided die", sides));
    Die die = new Die(sides);
    Set<Integer> rolls = new HashSet<>();
    for (int i = 0; i <= sides * 100; i++) {
      rolls.add(die.rollDice());
    }
    assertTrue(rolls.contains(1));
    assertTrue(rolls.contains(sides));
    assertEquals(sides, rolls.size());
  }

  @Test
  void oneSidedDie() { rollArbitraryDie(1); }

  @Test
  void sixSidedDie() { rollArbitraryDie(6); }

  @Test
  void twelveSidedDie() { rollArbitraryDie(12); }

  @Test
  void twentySidedDie() { rollArbitraryDie(20); }
}