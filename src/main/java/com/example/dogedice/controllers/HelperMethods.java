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
  public static String mainWindowTitle = "Doge Dice";
  public static String dogeCoinWindowTitle = "Donate!";
  public static String helpWindowTitle = "How to play";
  public static String playerSelectionWindowTitle = "Player Selection";
  public static String highscoreWindowTitle = "Highscore";
  public static String namePlayersWindowTitle = "Name Players";

  // FXML paths
  public static String mainWindowFXML = "fxml/mainWindow.fxml";
  public static String dogeCoinWindowFXML = "fxml/dogeCoinWindow.fxml";
  public static String helpWindowFXML = "fxml/helpWindow.fxml";
  public static String playerSelectionWindowFXML = "fxml/playerSelectionWindow.fxml";
  public static String highscoreWindowFXML = "fxml/highscoreWindow.fxml";
  public static String namePlayersWindowFXML = "fxml/namePlayersWindow.fxml";


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
