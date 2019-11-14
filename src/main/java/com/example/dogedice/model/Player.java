package com.example.dogedice.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Comparable<Player> {
  private String name;
  private int score;
  private List<Die> dice;
  private List<Modifier> modifiers;

  public Player(String name) {
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

  // TODO summera alla modifiers från this.modifiers, multiplicera med antalet tärningar.
  // TODO För att få värdet på en modifier använd metoden `.getValue()`
  // TODO Lägg till summan till this.score och returnera sedan summan.
  // TODO ta bort alla kommentarer där det står TODO när du är klar.
  public int sumAllModifiers() {
    return 1; // TODO Ändra till faktiska summan
  }

  public int compareTo(Player comparePlayer){
    int compareScore = ((Player) comparePlayer).getScore();

    return compareScore - this.score;
  }
}
