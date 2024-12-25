public class Food {
    int x, y;

    // Constructor to generate food at a random position
    public Food(int boardWidth, int boardHeight) {
        this.x = (int) (Math.random() * (boardWidth / 20));
        this.y = (int) (Math.random() * (boardHeight / 20));
    }

    // Generate a new food position
    public void generateNewFood(int boardWidth, int boardHeight) {
        this.x = (int) (Math.random() * (boardWidth / 20));
        this.y = (int) (Math.random() * (boardHeight / 20));
    }
}
