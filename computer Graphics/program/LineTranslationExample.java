import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class LineTranslationExample extends JFrame {
    private int x1, y1, x2, y2;
    private int dx, dy;

    public LineTranslationExample() {
        super("Line Translation Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        // Translate the line coordinates
        int translatedX1 = x1 + dx;
        int translatedY1 = y1 + dy;
        int translatedX2 = x2 + dx;
        int translatedY2 = y2 + dy;

        // Draw the translated line
        g2d.drawLine(translatedX1, translatedY1, translatedX2, translatedY2);
    }

    public void setTranslation(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LineTranslationExample example = new LineTranslationExample();
            example.setVisible(true);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter x1: ");
            example.x1 = scanner.nextInt();
            System.out.print("Enter y1: ");
            example.y1 = scanner.nextInt();
            System.out.print("Enter x2: ");
            example.x2 = scanner.nextInt();
            System.out.print("Enter y2: ");
            example.y2 = scanner.nextInt();
            System.out.print("Enter dx (translation along x-axis): ");
            int dx = scanner.nextInt();
            System.out.print("Enter dy (translation along y-axis): ");
            int dy = scanner.nextInt();
            scanner.close();

            example.setTranslation(dx, dy);
        });
    }
}
