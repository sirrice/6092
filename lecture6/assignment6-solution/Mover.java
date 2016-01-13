import java.awt.Graphics;

public interface Mover {
    public void draw(Graphics surface);
    public void setMovementVector(int x, int y);
}
