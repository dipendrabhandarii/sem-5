import javax.swing.*;
import java.awt.*;

public class LineDrawingExample extends JFrame {

    public LineDrawingExample() {
        setTitle("Line Drawing Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw a thick line
        g2d.setStroke(new BasicStroke(5)); // Set the stroke width to 5 pixels
        g2d.drawLine(50, 50, 350, 50); // Draw a line from (50, 50) to (350, 50)

        // Draw a dashed line
        float[] dashPattern = {10, 5}; // Set the dash pattern to 10 pixels on, 5 pixels off
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0));
        g2d.drawLine(50, 100, 350, 100); // Draw a line from (50, 100) to (350, 100)
    }

    public static void main(String[] args) {
    
            LineDrawingExample example = new LineDrawingExample();
           
        }
    }

