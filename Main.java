import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        setTitle("Đa hình 3 - Nguyễn Thị Ánh Tuyết - 22024523");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DrawingLayer drawingLayer = new DrawingLayer();
        add(drawingLayer);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
