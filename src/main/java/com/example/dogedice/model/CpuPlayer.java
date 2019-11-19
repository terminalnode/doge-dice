package com.example.dogedice.model;

public class CpuPlayer extends Player {
  private final GameEngine gameEngine;
  private BotAction desiredAction;

  public CpuPlayer(String name, GameEngine gameEngine) {
    super(name);
    this.gameEngine = gameEngine;
    this.desiredAction = BotAction.PASS;
  }

  @Override
  public boolean isBot() {
    return true;
  }

  public BotAction getDesiredAction() {
    int roundsLeft = gameEngine.getRoundsLeft();
    double pointsPerTurn = (3.5 * numD6) + (10.5 * numD20) + (numModifiers * (numD6 + numD20));

    // How many rounds until we can purchase any given item
    long turnsUntilD6 = getTurnsUntil(gameEngine.getD6Price(), pointsPerTurn);
    long turnsUntilD20 = getTurnsUntil(gameEngine.getD6Price(), pointsPerTurn);
    long turnsUntilModifier = getTurnsUntil(gameEngine.getModifierPrice(), pointsPerTurn);

    // Expected earnings from any given purchase.
    double d6Gain = (3.5 + numModifiers) * (roundsLeft - turnsUntilD6) - gameEngine.getD6Price();
    double d20Gain = (10.5 + numModifiers) * (roundsLeft - turnsUntilD20) - gameEngine.getD20Price();
    double modifierGain = (numD6 + numD20) * (roundsLeft - turnsUntilModifier) - gameEngine.getModifierPrice();

    if (d6Gain > d20Gain && d6Gain > modifierGain && d6Gain > 0) {
      return gameEngine.canBuyD6() ? BotAction.BUYD6 : BotAction.PASS;
    } else if (d20Gain > modifierGain && d20Gain > 0) {
      return gameEngine.canBuyD20() ? BotAction.BUYD20 : BotAction.PASS;
    } else if (modifierGain > 0) {
      return gameEngine.canBuyModifier() ? BotAction.BUYMODIFIER : BotAction.PASS;
    } else {
      return BotAction.PASS;
    }
  }

  private long getTurnsUntil(int price, double pointsPerTurn) {
    double exactTurns = (getScore() - price) / pointsPerTurn;
    if (exactTurns < 0) {
      return Math.round(Math.ceil(exactTurns));
    } else {
      return 0;
    }
  }

  private long numberOfNSidedDice(int n) {
    return getDice()
        .stream()
        .filter(x -> x.getNumOfSides() == n)
        .count();
  }
}
