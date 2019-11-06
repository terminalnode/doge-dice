package com.example.dogedice;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javax.swing.text.StyleConstants.Background;

public class Main extends Application {
  public static void main(String[] args) {
    // Start the JavaFX application by calling launch().
    launch(args);
  }

  // Override the start() method.
  public void start(Stage mainWindow) throws FileNotFoundException{
    mainWindow.setResizable(false);

    // DogeSpin
    Image image = new Image (new FileInputStream("res/dogespin.gif"));
    ImageView dogeSpin = new ImageView(image);
    ImageView dogeSpin2 = new ImageView(image);
    dogeSpin.setPreserveRatio(true);
    dogeSpin2.setPreserveRatio(true);
    dogeSpin.setFitWidth(30);
    dogeSpin2.setFitWidth(30);

    //Dogelogo
    Image image1 = new Image (new FileInputStream("res/dogelogo.png"));
    ImageView dogeLogo = new ImageView(image1);
    dogeLogo.setPreserveRatio(true);
    dogeLogo.setFitWidth(365);

    //DogeCoin
    Image image3 = new Image (new FileInputStream("res/dogecoin.png"));
    ImageView dogeCoin = new ImageView(image3);
    dogeCoin.setPreserveRatio(true);
    dogeCoin.setFitWidth(25);
    dogeCoin.setLayoutX(440);

    //Help
    Image image4 = new Image (new FileInputStream("res/help.png"));
    ImageView help = new ImageView(image4);
    help.setPreserveRatio(true);
    help.setFitWidth(25);
    help.setLayoutX(100);

    Group helpCoinGroup = new Group();
    helpCoinGroup.getChildren().addAll(dogeCoin, help);

    Button btnStart = new Button("START");
    Button btnHighScore = new Button ("HIGHSCORE");
    btnStart.setLayoutX(50);
    btnHighScore.setLayoutX(150);

    Group buttonGroup = new Group();
    buttonGroup.getChildren().addAll(btnStart, btnHighScore);

    BorderPane bPane = new BorderPane();
    bPane.setPadding(new Insets(5,5,5,5));
    bPane.setTop(dogeLogo);
    bPane.setBottom(helpCoinGroup);
    bPane.setCenter(buttonGroup);
    bPane.setLeft(dogeSpin);
    bPane.setRight(dogeSpin2);

    Scene myScene = new Scene(bPane);

    mainWindow.setTitle("Dogedice");  // Give the stage a title.
    mainWindow.setScene(myScene);     // Set the scene on the stage.
    mainWindow.show();                // Show the stage and its scene.
  }
}

