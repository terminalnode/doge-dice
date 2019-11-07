package com.example.dogedice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class FXMLMain extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  private URL getRes(String fileName) {
    return Thread.currentThread().getContextClassLoader().getResource(fileName);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane root = FXMLLoader.load(getRes("fxml/mainWindow.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
