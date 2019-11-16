package com.example.dogedice.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Comparable<Player> {
  private String name;
  private int score;
  private List<Die> dice;
  private List<Modifier> modifiers;

  Player(String name) {
    this.name = name;
    this.score = 0;
    this.dice = new ArrayList<>();
    this.modifiers = new ArrayList<>();
  }

  public abstract boolean isBot();

  public void addDie(Die die) {
    this.dice.add(die);
  }

  public void addModifier(Modifier modifier) {
    this.modifiers.add(modifier);
  }

  public List<Die> getDice() {
    return this.dice;
  }

  public List<Modifier> getModifiers() {
    return this.modifiers;
  }

  public int getScore() {
    return this.score;
  }

  public String getName() {
    return this.name;
  }

  public int rollAllDice() {
    int sum = 0;
    for (Die die : this.dice) {
      int outcome = die.roll();
      sum += outcome;
    }
    score += sum;
    return sum;
  }

  public int sumAllModifiers() {
    int sum = 0;
    for (Modifier modifier : this.modifiers) {
      sum += modifier.getValue();
    }
    sum *= this.dice.size();
    this.score += sum;
    return sum;
  }

  public int compareTo(Player comparePlayer){
    return this.score - comparePlayer.getScore();
  }
}
