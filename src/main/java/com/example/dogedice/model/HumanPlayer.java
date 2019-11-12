package com.example.dogedice.model;

import java.util.List;
public class HumanPlayer extends Player {

  public HumanPlayer(String name) {
    super("abc");

    throw new UnsupportedOperationException("Not implemented yet");
  }

  public static HumanPlayer createHumanPlayer (String name) {
    return new HumanPlayer(name);
  }

  @Override
  public boolean isBot() {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
