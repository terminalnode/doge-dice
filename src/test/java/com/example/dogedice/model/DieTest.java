package com.example.dogedice.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {
  private void rollArbitraryDie(int sides) {
    Die die = new Die(sides);
    Set<Integer> rolls = new HashSet<>();
    for (int i = 0; i <= sides * 100; i++) {
      rolls.add(die.rollDice());
    }
    assertTrue(rolls.contains(1));
    assertTrue(rolls.contains(sides));
    assertEquals(sides, rolls.size());
  }

  @Tag("OneSided")
  @Test
  void oneSidedDie() {
    rollArbitraryDie(1);
  }

  @Tag("SixSided")
  @Test
  void sixSidedDie() {
    rollArbitraryDie(6);
  }

  @Tag("TwentySided")
  @Test
  void twentySidedDie() {
    rollArbitraryDie(20);
  }
}