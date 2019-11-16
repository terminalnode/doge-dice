package com.example.dogedice.model;

import java.awt.*;

public class Die {

  private int numOfSides;
  private Image image;


  public Die(int numOfSides) {
    this.numOfSides = numOfSides;
    // if (numOfSides == 6) {
    //   this.image = new Image(path-to-six-sided-die-image)
    // } else if...
    // Add images for 6-sided, 20-sided and a
    // question mark image or something for other-sided dice.
  }

  public int roll() {
    return (int) (1 + Math.random() * numOfSides);
  }

  public Image getImage() {
    return this.image;
  }
}
