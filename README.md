# Doge Dice
A simple dice game using JavaFX, written by me and three class mates as a project for our first programming course. The duration of the project was two weeks.

# Rules
Each turn a player may roll their dice. Once they've accumulated enough points they can invest these points in more dice or modifiers that will add +1 to every dice throw for every dice. The game goes on for 30 rounds and then a winner is crowned.

# Features
- Highscores are saved to file and read at startup.
- Follows a fairly strict MVC pattern using FXML and CSS to render the view, controller classes to add functions to buttons and to dynamically generate items in the window and a model which handles all game logic.
- Some testing. Incomplete coverage of the UI and mostly complete coverage of the model.
- Built using gradle with configurations for running specific tests and packaging as a .jar-file.
- Some free-for-private-use music that can be muted by pressing the m-key on your keyboard.
- A competent AI-player that can be tweaked to make less than optimal decisions with a stupidity modifier.
- Variable number of players with customisable names.
- Bought items are added to the player panels live (though this can get messy because at the end of the game players will have an extraordinary number of items).

If the AI is set to 0 stupidity it will always pick the best possible die for that turn, it is however limited in that it can only predict the best possible move one move at a time and thus doesn't take into account things like variance. In the AI's mind three six-sided dice are exactly equal to one twenty-sided die, while in reality three six-sided dice will never roll below 3.
