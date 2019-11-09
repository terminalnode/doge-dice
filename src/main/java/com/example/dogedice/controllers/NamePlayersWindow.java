package com.example.dogedice.controllers;

import javafx.scene.input.MouseEvent;

public class NamePlayersWindow {
  private int humPlayers = 0;
  private int cpuPlayers = 0;

  void setHumPlayers(int humPlayers) {
    this.humPlayers = humPlayers;
  }

  void setCpuPlayers(int cpuPlayers) {
    this.cpuPlayers = cpuPlayers;
  }

  public void confirmButtonClicked(MouseEvent mouseEvent) {
  }
}
