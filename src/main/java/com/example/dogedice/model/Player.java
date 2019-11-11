package com.example.dogedice.model;

import java.util.List;

abstract class Player {
  Player(String name) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  public abstract boolean isBot();

  public void addDie(Die die) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  public void addModifier(Modifier modifier) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  public List<Die> getDice() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  public List<Modifier> getModifiers() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  public int getScore() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  public String getName() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  public int rollAllDice() {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
