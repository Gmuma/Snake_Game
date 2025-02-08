**Snake Game**

**Overview**

This is a classic Snake Game implemented in Java using core Java concepts and Data Structures and Algorithms (DSA). The game features include highest score tracking, random food generation, snake growth on eating food, and collision detection.

**Features**

**Highest Score Updating**: The game tracks and updates the highest score achieved during gameplay.

**Random Food Generation**: Food appears at random locations on the board.

**Snake Growth**: When the snake eats food, a new node is added to the back of the snake, making it grow.

**Collision Detection**: The game ends if the snake collides with itself or the boundaries.

**Files**

The project consists of the following files:

**food.java**: Handles the generation and positioning of food.

**node.java**: Represents each segment of the snake.

**snake.java**: Manages the snake's movement, growth, and interactions.

**snakegame.java**: The main class that initializes and runs the game.

**Compilation and Execution**

To compile and run the game, follow these steps:

Open a terminal or command prompt and navigate to the directory containing the game files.

Compile all the Java files using the following command:

****javac *.java****

Run the game using the following command:

**java snakeGame**

How the Game Works

Initialization: The game initializes the snake, food, and game board.

**Gameplay:**

The snake moves in the specified direction.

When the snake eats the food, its length increases, and a new food item is generated at a random location.

The score is updated whenever the snake eats food.

Game Over: The game ends if the snake collides with itself or the boundaries of the board.

**Requirements**

Java Development Kit (JDK) installed on your system.

Basic knowledge of running Java programs in a terminal/command prompt.

Project Structure

|-- food.java

|-- node.java

|-- snake.java

|-- snakeGame.java

**Additional Notes**

The game is designed to run on the command line and uses basic Java for simplicity.

This project demonstrates the use of object-oriented programming and data structures in Java.

**OutPut** :

**Game Start**

The initial state of the game when it begins.
![Screenshot (11)](https://github.com/user-attachments/assets/cb1af001-fe50-4aea-9f0e-69cb752aeae4)


**Snake Growing**

The snake grows in size after eating food.

**Food Generation Example**

Food appears randomly on the game board.

**Collision Detection**

Game over screen when the snake collides with itself.

**Highest Score Display**

The score tracker shows the current and highest score.
