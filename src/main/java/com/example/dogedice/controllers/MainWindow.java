package com.example.dogedice.controllers;

import com.example.dogedice.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class MainWindow {
  public void startButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.playerSelectionWindowFXML, HelperMethods.playerSelectionWindowTitle, mouseEvent);
  }

  public void highscoreButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.highscoreWindowFXML, HelperMethods.highscoreWindowTitle, mouseEvent);
  }

  public void helpButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.helpWindowFXML, HelperMethods.helpWindowTitle, mouseEvent);
  }

  public void dogecoinButtonClicked(MouseEvent mouseEvent) throws IOException {
    HelperMethods.replaceWindow(HelperMethods.dogeCoinWindowFXML, HelperMethods.dogeCoinWindowTitle, mouseEvent);
  }

  public void spinningDogeClicked(MouseEvent mouseEvent) {
    HelperMethods.spinningDogeClicked(mouseEvent);
  }
}
