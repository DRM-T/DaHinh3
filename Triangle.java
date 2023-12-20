import java.awt.*;

public class Triangle extends Shape {
    public Triangle(int x, int y, int width, int height, Color color, int xVelocity, int yVelocity) {
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

        int[] xPoints = { x, x + width / 2, x + width }; // đỉnh(x, y)
        int[] yPoints = { y + height, y, y + height };

        g.fillPolygon(xPoints, yPoints, 3);
    }
}
