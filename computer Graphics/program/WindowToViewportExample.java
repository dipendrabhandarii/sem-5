import java.awt.*;
import javax.swing.*;

public class WindowToViewportExample extends JFrame {
    public WindowToViewportExample() {
        setTitle("Window to Viewport Transformation");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        // Set the window coordinates
        double windowXMin = -10;
        double windowXMax = 10;
        double windowYMin = -10;
        double windowYMax = 10;

        // Set the viewport coordinates
        int viewportXMin = 50;
        int viewportXMax = 450;
        int viewportYMin = 50;
        int viewportYMax = 450;

        // Calculate the scaling factors
        double scaleX = (viewportXMax - viewportXMin) / (windowXMax - windowXMin);
        double scaleY = (viewportYMax - viewportYMin) / (windowYMax - windowYMin);

        // Calculate the translation factors
        double translateX = -windowXMin * scaleX + viewportXMin;
        double translateY = -windowYMin * scaleY + viewportYMin;

        // Apply the transformation
        g2d.translate(translateX, translateY);
        g2d.scale(scaleX, scaleY);

        // Draw a rectangle in the window coordinates
        g2d.drawRect(-5, -5, 10, 10);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WindowToViewportExample example = new WindowToViewportExample();
            example.setVisible(true);
        });
    }
}
