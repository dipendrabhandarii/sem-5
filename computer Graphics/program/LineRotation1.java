import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Scanner;
import java.awt.geom.Line2D;

public class LineRotation1 extends JFrame {
    private int startX, startY, endX, endY;
    private double rotationAngle;

    public LineRotation1(int startX, int startY, int endX, int endY, double rotationAngle) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.rotationAngle = rotationAngle;

        setTitle("Line Rotation Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the initial line
        int fontSize = 24;
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(startX, startY, endX, endY);
        g2d.drawString("Before Rotation", startX, startY);

        // Rotate the line
        AffineTransform transform = new AffineTransform();
        transform.rotate(rotationAngle, (startX + endX) / 2, (startY + endY) / 2);
        Shape rotatedLine = transform.createTransformedShape(new Line2D.Double(startX, startY, endX, endY));

        // Draw the rotated line
        g2d.setColor(Color.RED);
        g2d.draw(rotatedLine);
        g2d.drawString("After Rotation", 20, 250);
        // String text = "After Rotation";
        // g2d.setColor(Color.BLUE);
        // g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        // FontMetrics fm = g2d.getFontMetrics();
        // int textWidth = fm.stringWidth(text);
        // int textHeight = fm.getHeight();
        // int centerX = (startX + endX - textWidth) / 2;
        // int centerY = (startY + endY - textHeight) / 2;
        // g2d.drawString(text, centerX, centerY);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial X coordinate: ");
        int initialX = scanner.nextInt();

        System.out.print("Enter the initial Y coordinate: ");
        int initialY = scanner.nextInt();

        System.out.print("Enter the final X coordinate: ");
        int finalX = scanner.nextInt();

        System.out.print("Enter the final Y coordinate: ");
        int finalY = scanner.nextInt();

        System.out.print("Enter the rotation angle (in radians): ");
        double rotationAngle = scanner.nextDouble();

        SwingUtilities.invokeLater(() -> {
            new LineRotation1(initialX, initialY, finalX, finalY, rotationAngle);
        });

        scanner.close();
    }
}
