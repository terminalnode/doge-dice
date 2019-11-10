package com.example.dogedice.model;

public class Die {
  private int numOfSides;

  public Die(int numOfSides) {
    this.numOfSides = numOfSides;
  }

  public int rollDice() {
    return (int) (1 + Math.random() * numOfSides);
  }
}
