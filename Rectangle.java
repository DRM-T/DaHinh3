import java.awt.*;


public class Rectangle extends Shape {
    public Rectangle(int x, int y, int width, int height, Color color, int xVelocity, int yVelocity) {
        super(x, y, width, height, color, xVelocity, yVelocity);
    }

    @Override
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
