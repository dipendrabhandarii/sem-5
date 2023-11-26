 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.Scanner; // Import Scanner

public class FixedPointRotationDemo extends JPanel {
    private int x, y;        // Top-left corner of the rectangle
    private int width, height; // Dimensions of the rectangle
    private double angle;     // Rotation angle in degrees

    public FixedPointRotationDemo(int x, int y, int width, int height, double angle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.angle = angle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the original rectangle in red
        g2d.setColor(Color.RED);
        g2d.drawRect(x, y, width, height);

        // Apply fixed-point rotation transformation
        double centerX = x + width / 2.0;
        double centerY = y + height / 2.0;
        AffineTransform rotationTransform = AffineTransform.getRotateInstance(Math.toRadians(angle), centerX, centerY);

        // Apply the transformation to the rectangle
        Shape rotatedRectangle = rotationTransform.createTransformedShape(new Rectangle(x, y, width, height));

        // Draw the rotated rectangle in blue
        g2d.setColor(Color.BLUE);
        g2d.draw(rotatedRectangle);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int x, y, width, height;
            double angle;

            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);

            // Get user input for coordinates and dimensions
            System.out.print("Enter X-coordinate of the rectangle: ");
            x = scanner.nextInt();

            System.out.print("Enter Y-coordinate of the rectangle: ");
            y = scanner.nextInt();

            System.out.print("Enter width of the rectangle: ");
            width = scanner.nextInt();

            System.out.print("Enter height of the rectangle: ");
            height = scanner.nextInt();

            // Get user input for rotation angle
            System.out.print("Enter rotation angle in degrees: ");
            angle = scanner.nextDouble();

            JFrame frame = new JFrame("fixxed pooint Rottattion");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            FixedPointRotationDemo panel = new FixedPointRotationDemo(x, y, width, height, angle);
            frame.add(panel);
            frame.setVisible(true);

            // Close the Scanner after using it
            scanner.close();
        });
    }
}
