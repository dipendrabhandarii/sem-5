import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.Scanner;
import java.util.Scanner.*;

public class LineRotationExample extends JFrame {
    

    public LineRotationExample() {
        setTitle("Line Rotation Example");
        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
       // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the initial line coordinates
        int initialX = 50;
        int initialY = 50;
        int finalX = 200;
        int finalY = 200;
       

        // Draw the initial line
        g2d.setColor(Color.BLACK);
        g2d.drawLine(initialX, initialY, finalX, finalY);

        // Rotate the line
        double rotationAngle = Math.PI / 4; // 45 degrees in radians
        AffineTransform transform = new AffineTransform();
        transform.rotate(rotationAngle, (initialX + finalX) / 2, (initialY + finalY) / 2);
        Shape rotatedLine = transform.createTransformedShape(new Line2D.Double(initialX, initialY, finalX, finalY));

        // Draw the rotated line
        g2d.setColor(Color.RED);
        g2d.draw(rotatedLine);
    }

    public static void main(String[] args) {
        
            new LineRotationExample();
        };
    }

