package com.example.dogedice.model;

public class CpuPlayer extends Player {
  public CpuPlayer(String name) {
    super(name);
  }

  @Override
  public boolean isBot() {
    return true;
  }
}
