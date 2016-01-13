import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<Bouncer> bouncers = new ArrayList<Bouncer>();

    /** Initializes this class for drawing. */
    public DrawGraphics() throws IOException {
        Rectangle box = new Rectangle(15, 20, Color.RED);
        Bouncer bouncer = new Bouncer(100, 170, box); 
        bouncer.setMovementVector(3, 1);
        bouncers.add(bouncer);
        
        box = new Rectangle(20, 15, Color.BLUE);
        bouncer = new Bouncer(20, 20, box); 
        bouncer.setMovementVector(1, 3);
        bouncers.add(bouncer);
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for (Bouncer bouncer : bouncers) {
        	bouncer.draw(surface);
        }
    }
}
