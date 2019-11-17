package com.example.dogedice.controllers;

import com.example.dogedice.model.GameEngine;

public abstract class GenericController {
  GameEngine gameEngine;

  GenericController() {
    gameEngine = null;
  }

  public void setGameEngine(GameEngine gameEngine) {
    this.gameEngine = gameEngine;
  }

  public void postInitialization() {
    // Does nothing by default
  }
}
