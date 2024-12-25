import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SnakeGame extends JPanel {
    private Snake snake;
    private Food food;
    private String direction;
    private Timer gameTimer;
    private int score;
    private int highestScore;
    private final int TILE_SIZE = 10; // Size of each snake segment
    private final static int BOARD_WIDTH = 800; // Board width
    private final static int BOARD_HEIGHT = 500; // Board height
    private final int SPEED_DELAY = 100; // Normal speed delay

    public SnakeGame() {
        this.snake = new Snake();
        this.food = new Food(BOARD_WIDTH, BOARD_HEIGHT);
        this.direction = "right";
        this.score = 0;
        this.highestScore = 0;

        // Set up the game timer with normal speed
        gameTimer = new Timer(SPEED_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveSnake();
                checkCollisions();
                checkFood();
                repaint();
            }
        });
        gameTimer.start();

        // Listen for key presses to change direction
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP && !direction.equals("down")) {
                    direction = "up";
                } else if (key == KeyEvent.VK_DOWN && !direction.equals("up")) {
                    direction = "down";
                } else if (key == KeyEvent.VK_LEFT && !direction.equals("right")) {
                    direction = "left";
                } else if (key == KeyEvent.VK_RIGHT && !direction.equals("left")) {
                    direction = "right";
                }
            }
        });

        setFocusable(true);
    }

    // Move the snake
    private void moveSnake() {
        snake.move(direction);
    }

    // Check for collisions (snake with itself or boundaries)
    private void checkCollisions() {
        if (snake.checkCollision() || snake.head.x < 0 || snake.head.y < 0 ||
                snake.head.x >= BOARD_WIDTH / TILE_SIZE || snake.head.y >= BOARD_HEIGHT / TILE_SIZE) {
            // Update highest score if the current score is higher
            if (score > highestScore) {
                highestScore = score;
            }

            // Show Game Over message
            JOptionPane.showMessageDialog(this, "Game Over! Your score: " + score);

            // Reset the game
            resetGame();
        }
    }

    // Reset game to initial state
    private void resetGame() {
        // Reset the snake to its initial state
        this.snake = new Snake();
        this.food = new Food(BOARD_WIDTH, BOARD_HEIGHT);
        this.direction = "right";
        this.score = 0;

        // Restart the timer
        gameTimer.restart();
    }

    // Check if the snake eats food
    private void checkFood() {
        if (snake.head.x == food.x && snake.head.y == food.y) {
            snake.grow();
            food.generateNewFood(BOARD_WIDTH, BOARD_HEIGHT);
            score += 5; // Normal score per food eaten
        }
    }

    // Render the game board
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the background color
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);

        // Draw the snake
        List<int[]> body = snake.getBodyCoordinates();
        for (int i = 0; i < body.size(); i++) {
            int[] segment = body.get(i);
            if (i == 0) {
                // Head of the snake (distinguished by blue color)
                g.setColor(Color.BLUE);
            } else {
                // Body of the snake (green color)
                g.setColor(Color.GREEN);
            }
            g.fillRect(segment[0] * TILE_SIZE, segment[1] * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        // Draw the food
        g.setColor(Color.RED);
        g.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Draw the current score
        g.setColor(Color.PINK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, 10, 30);

        // Draw the highest score
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("High Score: " + highestScore, BOARD_WIDTH - 150, 30);

        // Draw the border
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, BOARD_WIDTH - 1, BOARD_HEIGHT - 1);
    }

    // Main method to set up the game window
    public static void main(String[] args) {
        JFrame frame = new JFrame("Welcome To Snake Game");
        SnakeGame game = new SnakeGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.add(game);
        frame.setVisible(true);
    }
}
