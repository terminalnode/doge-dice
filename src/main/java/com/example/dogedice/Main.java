package com.example.dogedice;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
  public static void main(String[] args) {
    // Start the JavaFX application by calling launch().
    launch(args);
  }

  private URL getRes(String fileName) {
    return Thread.currentThread().getContextClassLoader().getResource(fileName);
  }

  // Override the start() method.
  public void start(Stage mainWindow) throws IOException {
    mainWindow.setTitle("Dogedice");  // Give the stage a title.

    BorderPane root = FXMLLoader.load(getRes("fxml/mainWindow.fxml"));
    Scene scene = new Scene(root);
    mainWindow.setScene(scene);
    mainWindow.show();
  }
}

