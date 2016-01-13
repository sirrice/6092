import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<Drawable> sprites = new ArrayList<Drawable>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box = new Rectangle(15, 20, Color.RED);
        sprites.add(new Bouncer(100, 170, box)); 
        sprites.get(0).setMovementVector(3, 1);
        Oval oval = new Oval(10, 25, Color.GREEN);
        sprites.add(new Bouncer(200, 5, oval));
        sprites.get(1).setMovementVector(-1, 5);

        box = new Rectangle(10, 15, Color.LIGHT_GRAY);
        sprites.add(new StraightMover(10, 150, box)); 
        sprites.get(2).setMovementVector(3, -1);
        oval = new Oval(100, 100, Color.CYAN);
        sprites.add(new StraightMover(50, 50, oval));
        sprites.get(3).setMovementVector(3, 5);        
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for (Drawable d : sprites) {
            d.draw(surface);
        }
    }
}
