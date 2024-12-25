import java.util.ArrayList;
import java.util.List;

public class Snake {
    Node head, tail;
    int length;

    // Constructor to initialize the snake with 3 segments
    public Snake() {
        this.head = new Node(5, 5);
        Node second = new Node(4, 5);
        Node third = new Node(3, 5);

        this.head.next = second;
        second.next = third;
        this.tail = third;
        this.length = 3;
    }

    // Move the snake in the given direction
    public void move(String direction) {
        Node newHead;

        // Create a new head based on the direction
        if (direction.equals("up")) {
            newHead = new Node(this.head.x, this.head.y - 1);
        } else if (direction.equals("down")) {
            newHead = new Node(this.head.x, this.head.y + 1);
        } else if (direction.equals("left")) {
            newHead = new Node(this.head.x - 1, this.head.y);
        } else if (direction.equals("right")) {
            newHead = new Node(this.head.x + 1, this.head.y);
        } else {
            return;
        }

        // Move the snake: Insert new head at the beginning
        newHead.next = this.head;
        this.head = newHead;

        // Remove the tail (last segment)
        Node current = this.head;
        while (current.next != null && current.next != this.tail) {
            current = current.next;
        }
        current.next = null;
        this.tail = current;
    }

    // Add a new segment to the snake (growth)
    public void grow() {
        Node newSegment = new Node(this.tail.x, this.tail.y);
        this.tail.next = newSegment;
        this.tail = newSegment;
        this.length++;
    }

    // Check if the snake collides with itself
    public boolean checkCollision() {
        Node current = this.head;
        Node checker = this.head.next;

        // Check if the head collides with any of the body segments
        while (checker != null) {
            if (current.x == checker.x && current.y == checker.y) {
                return true; // Collision detected
            }
            checker = checker.next;
        }

        return false; // No collision
    }

    // Get the snake body as a list of points for rendering
    public List<int[]> getBodyCoordinates() {
        List<int[]> body = new ArrayList<>();
        Node current = this.head;
        while (current != null) {
            body.add(new int[] { current.x, current.y });
            current = current.next;
        }
        return body;
    }
}
