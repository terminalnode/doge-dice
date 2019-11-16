package com.example.dogedice.controllers;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DogeCoinWindow {

  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.mainWindowFXML, HelperMethods.mainWindowTitle, mouseEvent);
  }
}

