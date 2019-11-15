package com.example.dogedice.model;

import java.awt.*;

public class Die {

  private int numOfSides;
  private Image dieImage;


  public Die(int numOfSides, Image dieImage) {
    this.numOfSides = numOfSides;
    this.dieImage = dieImage;
  }

  public int roll() { return (int) (1 + Math.random() * numOfSides); }

 public Image getImage() { return this.dieImage; }

}
