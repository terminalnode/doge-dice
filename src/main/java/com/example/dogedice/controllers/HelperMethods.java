package com.example.dogedice.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelperMethods {
  // Window titles
  public static final String mainWindowTitle = "Doge Dice";
  public static final String dogeCoinWindowTitle = "Donate!";
  public static final String helpWindowTitle = "How to play";
  public static final String playerSelectionWindowTitle = "Player Selection";
  public static final String highscoreWindowTitle = "Highscore";
  public static final String namePlayersWindowTitle = "Name Players";
  public static final String playWindowTitle = "Game!";

  // FXML paths
  public static final String mainWindowFXML = "fxml/mainWindow.fxml";
  public static final String dogeCoinWindowFXML = "fxml/dogeCoinWindow.fxml";
  public static final String helpWindowFXML = "fxml/helpWindow.fxml";
  public static final String playerSelectionWindowFXML = "fxml/playerSelectionWindow.fxml";
  public static final String highscoreWindowFXML = "fxml/highscoreWindow.fxml";
  public static final String namePlayersWindowFXML = "fxml/namePlayersWindow.fxml";
  public static final String playWindowFXML = "fxml/playWindow.fxml";


  public static void spinningDogeClicked(MouseEvent mouseEvent) {
    ImageView imageView = (ImageView) mouseEvent.getSource();
    Image image = imageView.getImage();

    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
      imageView.setScaleX(imageView.getScaleX() * -1);
    } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
      if (image.getUrl().contains("dogespin")) {
        Image newImage = new Image(getRes("images/rainbowDoge.gif").toExternalForm());
        imageView.setImage(newImage);
      } else {
        Image newImage = new Image(getRes("images/dogespin.gif").toExternalForm());
        imageView.setImage(newImage);
      }
    }
  }

  public static URL getRes(String fileName) {
    return Thread.currentThread().getContextClassLoader().getResource(fileName);
  }

  public static void replaceWindow(String fxmlPath, String windowTitle, MouseEvent mouseEvent) throws IOException {
    Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
    stage.setTitle(windowTitle);
    Parent root = FXMLLoader.load(getRes(fxmlPath));
    Scene scene = new Scene(root);
    stage.setScene(scene);
  }

  public static FXMLLoader getLoader(String fxmlPath) {
    return new FXMLLoader(getRes(fxmlPath));
  }

  public static void replaceStage(MouseEvent mouseEvent, Scene scene, String title) {
    Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
    stage.setTitle(title);
    stage.setScene(scene);
  }
}
