package com.example.dogedice;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage mainWindow) throws IOException {
    mainWindow.setTitle("Doge Dice");  // Give the stage a title.
    Parent root = FXMLLoader.load(getRes("fxml/mainWindow.fxml"));
    Scene scene = new Scene(root);
    mainWindow.setScene(scene);
    mainWindow.show();
  }

  // Static helper methods used throughout the program
  private static URL getRes(String fileName) {
    return Thread.currentThread().getContextClassLoader().getResource(fileName);
  }

  public static void openWindow(String fxmlPath, String windowTitle) throws IOException {
    Stage newWindow = new Stage();
    Parent root = FXMLLoader.load(Main.getRes(fxmlPath));
    Scene scene = new Scene(root);
    newWindow.setTitle(windowTitle);
    newWindow.setScene(scene);
    newWindow.show();
  }

  public static FXMLLoader getLoader(String fxmlPath) {
    return new FXMLLoader(getRes(fxmlPath));
  }

  public static void hideParentWindow(MouseEvent mouseEvent) {
    ((Node)mouseEvent.getSource()).getScene().getWindow().hide();
  }
}

