import java.awt.*;
import javax.swing.*;

public class WindowToViewportLineExample extends JFrame {
    public WindowToViewportLineExample() {
        setTitle("Window to Viewport Transformation for Line");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        int windowXMin = -10;
        int windowXMax = 10;
        int windowYMin = -10;
        int windowYMax = 10;

        int viewportXMin = 50;
        int viewportXMax = 450;
        int viewportYMin = 50;
        int viewportYMax = 450;

        // Draw the window
        g2d.drawRect(viewportXMin, viewportYMin, viewportXMax - viewportXMin, viewportYMax - viewportYMin);

        // Draw the viewport
        g2d.drawRect(windowXMin, windowYMin, windowXMax - windowXMin, windowYMax - windowYMin);

        // Set the line coordinates in the window
        double lineX1 = -8;
        double lineY1 = -8;
        double lineX2 = 8;
        double lineY2 = 8;

        // Calculate the scaling factors
        double scaleX = (viewportXMax - viewportXMin) / (windowXMax - windowXMin);
        double scaleY = (viewportYMax - viewportYMin) / (windowYMax - windowYMin);

        // Calculate the translation factors
        double translateX = -windowXMin * scaleX + viewportXMin;
        double translateY = -windowYMin * scaleY + viewportYMin;

        // Apply the transformation to the line coordinates
        int viewportLineX1 = (int) (lineX1 * scaleX + translateX);
        int viewportLineY1 = (int) (lineY1 * scaleY + translateY);
        int viewportLineX2 = (int) (lineX2 * scaleX + translateX);
        int viewportLineY2 = (int) (lineY2 * scaleY + translateY);

        // Draw the line in the viewport
        g2d.drawLine(viewportLineX1, viewportLineY1, viewportLineX2, viewportLineY2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WindowToViewportLineExample example = new WindowToViewportLineExample();
            example.setVisible(true);
        });
    }
}
