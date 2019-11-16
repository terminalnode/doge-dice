package com.example.dogedice.model;

import javafx.scene.Group;

public class Modifier {
  private int value;
  private Group image;


  public Modifier(int value) {
    this.value = value;
    this.image = new Group();
    // add svgpath from playWindow to group
    // and a label with the value of the modifier to group
  }

  public int getValue() {
    return this.value;
  }

  public Group getImage() {
    return this.image;
  }
}
