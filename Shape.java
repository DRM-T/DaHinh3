import java.awt.*;

public abstract class Shape {
    protected int x, y, width, height;
    protected Color color;
    protected int xVelocity, yVelocity;

    public Shape(int x, int y, int width, int height, Color color, int xVelocity, int yVelocity) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public abstract void move();

    public abstract void draw(Graphics g);

    public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle(x, y, width, height);
    }
}
