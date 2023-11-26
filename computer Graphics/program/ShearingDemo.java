import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
public class ShearingDemo extends JPanel {
    private int x, y;        // Top-left corner of the rectangle
    private int width, height; // Dimensions of the rectangle
    private double shearFactor; // Shearing factor
    public ShearingDemo(int x, int y, int width, int height, double shearFactor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shearFactor = shearFactor;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Draw the original rectangle in red
        g2d.setColor(Color.RED);
        g2d.drawRect(x, y, width, height);
        // Apply horizontal shearing transformation
        AffineTransform shearTransform = new AffineTransform();
        shearTransform.setTransform(1, shearFactor, 0, 1, 0, 0);
        // Apply the transformation to the rectangle
        Shape shearedRectangle = shearTransform.createTransformedShape(new Rectangle(x, y, width, height));
        // Draw the sheared rectangle in blue
        g2d.setColor(Color.BLUE);
        g2d.draw(shearedRectangle);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int x = 50;
            int y = 50;
            int width = 100;
            int height = 60;
            double shearFactor = 0.5; // Horizontal shearing factor
            JFrame frame = new JFrame("yesle distort garxa");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            ShearingDemo panel = new ShearingDemo(x, y, width, height, shearFactor);
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
