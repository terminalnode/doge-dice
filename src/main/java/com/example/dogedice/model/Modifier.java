package com.example.dogedice.model;

import java.awt.*;

public class Modifier {
  private int value;
  private Image modImage;


  public Modifier(int value, Image modImage) {
    this.value = value;
    this.modImage = modImage;
  }

  public int getValue() {
    return this.value;
  }

  public Image getModImage() { return this.modImage;}

}
