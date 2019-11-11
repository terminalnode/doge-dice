// This class is supposed to test both HumanPlayer and CPU Player
package com.example.dogedice.model;

import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
  private Random r = new Random();

  private String randomString() {
    String characters = "abcdefghijklmnopqrstuvwxyzåäöæœþđłçô" +
        "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖÆŒÞĐŁÇÔ" +
        "1234567890 {}[]$\"'/^|\\#:=@!%`≠";
    StringBuilder randomString = new StringBuilder();

    for (int i = 0; i < 30; i++) {
      randomString.append(characters.charAt(r.nextInt(characters.length())));
    }
    return randomString.toString();
  }

  @Test
  void setName() {
    System.out.println("Testing creating a few players with random names.");
    for (int i = 0; i < 100; i++) {
      String str = randomString();
      Player human = new HumanPlayer(str);
      Player cpu = new CpuPlayer(str);
      assertEquals(str, human.getName());
      assertEquals(str, cpu.getName());
    }
  }

  @Test
  void rollDice() {
    Player human = new HumanPlayer("Human");
    Player cpu = new CpuPlayer("CPU");

    System.out.println("Testing that dice are added properly.");
    for (int i = 1; i <= 100; i++) {
      Die die = new Die(1);
      human.addDie(die);
      cpu.addDie(die);

      assertEquals(i, human.getDice().size());
      assertEquals(i, cpu.getDice().size());
    }
  }

  @Test
  void isBot() {
    System.out.println("Testing that HumanPlayer isn't a bot and that CpuPlayer is a bot.");
    assertFalse(new HumanPlayer("").isBot());
    assertTrue(new CpuPlayer("").isBot());
  }

  @Test
  void getPoints() {
    System.out.println("Testing that points are added and summed up correctly.");
    Player human = new HumanPlayer("");
    Player cpu = new CpuPlayer("");
    for (int i = 0; i < 10; i++) {
      Die die = new Die(6);
      human.addDie(die);
      cpu.addDie(die);
    }

    int humanScore = 0;
    int cpuScore = 0;
    int minimumRoll = 10; // All ones
    int maximumRoll = 60; // All sixes
    for (int j = 1; j <= 10; j++) {
      int humanRoll = human.rollAllDice();
      int cpuRoll= cpu.rollAllDice();
      humanScore += humanRoll;
      cpuScore += cpuRoll;

      assertTrue(humanRoll >= minimumRoll && humanRoll <= maximumRoll);
      assertTrue(cpuRoll >= minimumRoll && cpuRoll <= maximumRoll);

      assertEquals(humanScore, human.getScore());
      assertEquals(cpuScore, cpu.getScore());
    }
  }

  @Test
  void addModifiers() {
    System.out.println("Testing that modifiers are added correctly.");
    Player human = new HumanPlayer("");
    Player cpu = new CpuPlayer("");
    for (int i = 0; i < 10; i++) {
      Modifier mod = new Modifier(5);
      human.addModifier(mod);
      cpu.addModifier(mod);
    }

    assertEquals(10, human.getModifiers().size());
    assertEquals(10, cpu.getModifiers().size());
  }
}