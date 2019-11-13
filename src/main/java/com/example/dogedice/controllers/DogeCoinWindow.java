package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static com.example.dogedice.controllers.HelperMethods.replaceWindow;

public class DogeCoinWindow {

  public void backIconClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.mainWindowFXML, HelperMethods.mainWindowTitle, mouseEvent);
  }
}

