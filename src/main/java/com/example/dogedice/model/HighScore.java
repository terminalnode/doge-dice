package com.example.dogedice.model;

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class HighScore {
  private final Gson gson;
  private final List<Player> players;
  private final int playersToSave;
  private final String jsonPath;


  HighScore(int playersToSave) {
    this.gson = new Gson();
    this.players = new ArrayList<>();
    this.playersToSave = playersToSave;
    this.jsonPath = "highscores.json";

    try {
      Path settingsPath = Paths.get(jsonPath);
      String json = Files.readString(settingsPath);
      // This should work, but doesn't at the moment
      // Type highScoreType = new TypeToken<ArrayList<Player>>() {}.getType();
      List<Player> highScoreFromFile = gson.fromJson(json, ArrayList.class);
      players.addAll(highScoreFromFile);
    } catch (Exception e) {
      System.out.println("Something went wrong when trying to load json.");
    }
  }

  void addPlayers(List<Player> newPlayers) {
    players.addAll(newPlayers);
    Collections.sort(players);
    System.out.println(players.subList(playersToSave, players.size()).size());
  }

  List<Player> getPlayers() {
    return players;
  }

  void writeJSON() {
    String json = gson.toJson(players);
    try {
      PrintStream out = new PrintStream(new FileOutputStream(jsonPath));
      out.print(json);
      out.flush();
    } catch (Exception e) {
      System.out.println("Error: Failed to write " + jsonPath + " to disk:");
      System.out.println(e.toString());
    }
  }

}
