import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingLayer extends JPanel implements KeyListener {
    private List<Shape> shapes;

    public DrawingLayer() {
        shapes = new ArrayList<>();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        Timer timer = new Timer(16, e -> {
            for (Shape shape : shapes) {
                shape.move();
            }
            checkCollision();
            repaint();
        });
        timer.start();
    }

    public void addRandomCircle() {
        Random rand = new Random();
        int x = -1, y = -1, diameter = -1;
        while (x < 0 || y < 0) {
            diameter = rand.nextInt(50) + 20;
            x = rand.nextInt(getWidth() - diameter);
            y = rand.nextInt(getHeight() - diameter);
        }
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        int xVelocity = rand.nextInt(5) + 1;
        int yVelocity = rand.nextInt(5) + 1;

        Circle circle = new Circle(x, y, diameter, color, xVelocity, yVelocity);
        shapes.add(circle);
    }

    public void addRandomRectangle() {
        Random rand = new Random();
        int x = -1, y = -1, height = -1, width = -1;
        while (x < 0 || y < 0) {
            width = rand.nextInt(50) + 20;
            height = rand.nextInt(50) + 20;
            x = rand.nextInt(getWidth()) - width;
            y = rand.nextInt(getHeight()) - height;
        }

        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        int xVelocity = rand.nextInt(5) + 1;
        int yVelocity = rand.nextInt(5) + 1;

        Rectangle rectangle = new Rectangle(x, y, width, height, color, xVelocity, yVelocity);
        shapes.add(rectangle);
    }

    public void addRandomTriangle() {
        Random rand = new Random();

        int x = rand.nextInt(getWidth());
        int y = rand.nextInt(getHeight());
        int base = rand.nextInt(50) + 20;
        int height = rand.nextInt(50) + 20;
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        int xVelocity = rand.nextInt(5) + 1;
        int yVelocity = rand.nextInt(5) + 1;

        Triangle triangle = new Triangle(x, y, base, height, color, xVelocity, yVelocity);
        shapes.add(triangle);
    }

    public void removeCircle() {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i) instanceof Circle) {
                shapes.remove(i);
                break;
            }
        }
    }

    public void removeRectangle() {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i) instanceof Rectangle) {
                shapes.remove(i);
                break;
            }
        }
    }

    public void removeTriangle() {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i) instanceof Triangle) {
                shapes.remove(i);
                break;
            }
        }
    }

    public void checkCollision() {
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            if (shape.x + shape.width >= getWidth() || shape.x <= 0) {
                shape.xVelocity = -shape.xVelocity;
            }

            if (shape.y + shape.height >= getHeight() || shape.y <= 0) {
                shape.yVelocity = -shape.yVelocity;
            }
            for (int j = i + 1; j < shapes.size(); j++) {
                Shape shape1 = shapes.get(i);
                Shape shape2 = shapes.get(j);

                if (shape1.getBounds().intersects(shape2.getBounds())) {
                    shape1.xVelocity = -shape1.xVelocity;
                    shape1.yVelocity = -shape1.yVelocity;
                    shape2.xVelocity = -shape2.xVelocity;
                    shape2.yVelocity = -shape2.yVelocity;
                }

            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case '1':
                addRandomCircle();
                break;
            case '2':
                addRandomRectangle();
                break;
            case '3':
                addRandomTriangle();
                break;
            case 'q':
                removeCircle();
                break;
            case 'w':
                removeRectangle();
                break;
            case 'e':
                removeTriangle();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
