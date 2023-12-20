import java.awt.*;

public class Circle extends Shape {
    public Circle(int x, int y, int diameter, Color color, int xVelocity, int yVelocity) {
        super(x, y, diameter, diameter, color, xVelocity, yVelocity);
    }

    @Override
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}
