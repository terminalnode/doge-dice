package com.example.dogedice.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameEngine {
  private int roundsLeft;
  private int totalRounds;
  private int playerIndex;
  private int d6Price;
  private int d20Price;
  private int modifierPrice;
  private List<Player> players;
  private final List<Die> startingDice;
  private final List<Modifier> startingModifiers;
  private Integer numberOfHumans;
  private Integer numberOfCPUs;
  private final HighScore highScore;

  public GameEngine(int totalRounds, int d6Price, int d20Price, int modifierPrice, int[] startingDice, int[] startingModifiers) {
    this.roundsLeft = totalRounds;
    this.totalRounds = totalRounds;
    this.d6Price = d6Price;
    this.d20Price = d20Price;
    this.modifierPrice = modifierPrice;
    this.startingDice = Arrays.stream(startingDice)
        .mapToObj(Die::new)
        .collect(Collectors.toList());
    this.startingModifiers = Arrays.stream(startingModifiers)
        .mapToObj(Modifier::new)
        .collect(Collectors.toList());
    this.numberOfHumans = 1;
    this.numberOfCPUs = 0;
    this.highScore = new HighScore(3);

    // Initializing the game
    this.playerIndex = 0;
    players = new ArrayList<>();
  }

  public void setNumberOfPlayers(int humans, int cpus) {
    numberOfHumans = humans;
    numberOfCPUs = cpus;
  }

  public Integer getNumberOfHumans() {
    return this.numberOfHumans;
  }

  public Integer getNumberOfCPUs() {
    return this.numberOfCPUs;
  }

  public void addHumanPlayer(String name) {
    Player player = new HumanPlayer(name);
    initializePlayer(player);
  }

  public void addCpuPlayer(String name) {
    Player player = new CpuPlayer(name);
    initializePlayer(player);
  }

  private void initializePlayer(Player player) {
    startingDice.forEach(player::addDie);
    startingModifiers.forEach(player::addModifier);
    this.players.add(player);
  }

  public int getD6Price() {
    return d6Price;
  }

  public int getD20Price() {
    return d20Price;
  }

  public int getModifierPrice() {
    return modifierPrice;
  }

  public int getPlayerIndex() {
    return playerIndex;
  }

  public int getRoundsLeft() {
    return roundsLeft;
  }

  public String getRoundsLeftAsString() {
    return "" + roundsLeft;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public Player getPlayer() {
    return this.players.get(playerIndex);
  }

  public int getScore() {
    return getPlayer().getScore();
  }

  public String getScoreAsString() {
    return "" + getPlayer().getScore();
  }

  public String getPlayerName() {
    return getPlayer().getName();
  }

  public boolean canBuyD6() {
    return getPlayer().getScore() >= d6Price;
  }

  public boolean canBuyD20() {
    return getPlayer().getScore() >= d20Price;
  }

  public boolean canBuyModifier() {
    return getPlayer().getScore() >= modifierPrice;
  }

  public int rollDice() {
    return getPlayer().rollAllDice();
  }

  public int sumModifiers() {
    return getPlayer().sumAllModifiers();
  }

  public void resetPlayers() {
    this.players = new ArrayList<>();
  }

  public void resetRounds() {
    this.roundsLeft = this.totalRounds;
  }

  public void buyD6() {
    Player player = getPlayer();
    if (player.removePoints(d6Price)) {
      player.addDie(new Die(6));
    }
  }

  public void buyD20() {
    Player player = getPlayer();
    if (player.removePoints(d20Price)) {
      player.addDie(new Die(20));
    }
  }

  public void buyModifier() {
    Player player = getPlayer();
    if (player.removePoints(modifierPrice)) {
      player.addModifier(new Modifier(1));
    }
  }

  public int incrementPlayer() {
    playerIndex++;
    if (players.size() == playerIndex){
      playerIndex = 0;
      roundsLeft--;
    }
    return playerIndex;
  }

  public void updateHighScore() {
    highScore.addPlayers(players);
    highScore.writeJSON();
  }

  public List<Player> getHighScore() {
    return highScore.getPlayers();
  }

  @Override
  public String toString() {
    return String.format("[<%s> Rounds left: %s/%s, Players: %s]",
        this.getClass().getSimpleName(),
        roundsLeft,
        totalRounds,
        players.size()
    );
  }
}
