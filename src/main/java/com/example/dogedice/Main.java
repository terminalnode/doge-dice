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
    //mainWindow.setResizable(false);
  }

  // Static helper methods used throughout the program
  public static URL getRes(String fileName) {
    return Thread.currentThread().getContextClassLoader().getResource(fileName);
  }

  public static void replaceWindow(String fxmlPath, String windowTitle, MouseEvent mouseEvent) throws IOException {
    Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
    stage.setTitle(windowTitle);
    Parent root = FXMLLoader.load(Main.getRes(fxmlPath));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    System.out.println(scene.lookup(".spinningDoge"));
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

