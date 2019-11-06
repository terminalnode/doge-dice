package com.example.dogedice;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {
  public static void main(String[] args) {
    // Start the JavaFX application by calling launch().
    launch(args);
  }
  // Override the start() method.
  public void start(Stage myStage) throws FileNotFoundException{
    myStage.setResizable(false);
    // DogeSpin
    Image image = new Image (new FileInputStream("res/dogespin.gif"));
    ImageView dogeSpin = new ImageView(image);
    dogeSpin.setX(10);
    dogeSpin.setY(10);
    dogeSpin.setPreserveRatio(true);
    dogeSpin.setFitWidth(30);
    //dogeSpin.setFitHeight(30);

    //DogeSpin2
    Image image2 = new Image (new FileInputStream("res/dogespin.gif"));
    ImageView dogeSpin2 = new ImageView(image2);
    dogeSpin2.setX(10);
    dogeSpin2.setY(10);
    dogeSpin2.setFitWidth(30);
    dogeSpin2.setFitHeight(30);
    dogeSpin2.setPreserveRatio(true);


    //Dogelogo
    Image image1 = new Image (new FileInputStream("res/dogelogo.png"));
    ImageView dogeLogo = new ImageView(image1);
    dogeLogo.setFitWidth(365);
    dogeLogo.setFitHeight(271);
    dogeLogo.setPreserveRatio(true);

    //DogeCoin
    Image image3 = new Image (new FileInputStream("res/dogecoin.png"));
    ImageView dogeCoin = new ImageView(image3);
    dogeCoin.setFitWidth(25);
    dogeCoin.setFitHeight(25);
    dogeCoin.setPreserveRatio(true);
    dogeCoin.setLayoutX(440);


    //Help
    Image image4 = new Image (new FileInputStream("res/help.png"));
    ImageView help = new ImageView(image4);
    help.setFitWidth(25);
    help.setFitHeight(25);
    help.setPreserveRatio(true);
    help.setLayoutX(100);

    Group group2 = new Group();
    group2.getChildren().addAll(dogeCoin, help);


    Button btnStart = new Button("START");
    Button btnHighScore = new Button ("HIGHSCORE");
    btnStart.setLayoutX(50);
    btnHighScore.setLayoutX(110);

    Group group1 = new Group();
    group1.getChildren().addAll(btnStart, btnHighScore);

    BorderPane bPane = new BorderPane();
    bPane.setPadding(new Insets(5,5,5,5));
    bPane.setTop(dogeLogo);
    bPane.setBottom(group2);
    bPane.setLeft(dogeSpin);
    bPane.setRight(dogeSpin2);
    bPane.setCenter(group1);



    Scene myScene = new Scene(bPane);

    // Give the stage a title.
    myStage.setTitle("Dogedice");

    // Set the scene on the stage.
    myStage.setScene(myScene);

    // Show the stage and its scene.
    myStage.show();
  }
}

