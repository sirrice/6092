import java.awt.Graphics;

public class Bouncer {
    private int x;
    private int y;
    private int xDirection;
    private int yDirection;
    private Rectangle rect;

    /** Create a Bouncer that positions rect at (startX, startY). */
    public Bouncer(int startX, int startY, Rectangle rect) {
        x = startX;
        y = startY;
        this.rect = rect; 
    }

    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }

    /** Draws the rectangle at its current position on to surface. */
    public void draw(Graphics surface) {
        // Draw the rectangle
        rect.draw(surface, x, y);

        // Move the object each time we draw it
        x += xDirection;
        y += yDirection;

        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
        if ((x <= 0 && xDirection < 0) ||
                (x + rect.getWidth() >= SimpleDraw.WIDTH && xDirection > 0)) {
            xDirection = -xDirection;
        }
        if ((y <= 0 && yDirection < 0) ||
                (y + rect.getHeight() >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
        }
    }
}
