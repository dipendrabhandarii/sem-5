import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillDemo extends JPanel {
    private BufferedImage image;
    private Graphics2D g2;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ghumi Ghumi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FloodFillDemo demo = new FloodFillDemo();
        frame.add(demo);
        frame.pack();
        frame.setVisible(true);
    }
    public FloodFillDemo() {
        image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        setMinimumSize(getPreferredSize());
        g2 = image.createGraphics();
        g2.setColor(Color.white);
        g2.fillRect(0, 0, image.getWidth(), image.getHeight());
        drawShape();

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                floodFill(e.getX(), e.getY(), image.getRGB(e.getX(), e.getY()), Color.yellow.getRGB());
                repaint();
            }
        });
    }

    private void drawShape() {
        g2.setColor(Color.red);
        g2.fillRect(150, 150, 200, 200);
    }
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
    public void floodFill(int startX, int startY, int targetColor, int replacementColor) {
        if (targetColor == replacementColor) {
            return;
        }
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            if (x < 0 || x >= image.getWidth() || y < 0 || y >= image.getHeight()) {
                continue;
            }
            int currentColor = image.getRGB(x, y);
            if (currentColor == targetColor) {
                image.setRGB(x, y, replacementColor);
                queue.offer(new Point(x - 1, y));
                queue.offer(new Point(x + 1, y));
                queue.offer(new Point(x, y - 1));
                queue.offer(new Point(x, y + 1));
            }}}}
