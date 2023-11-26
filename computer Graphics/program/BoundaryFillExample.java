import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Stack;
public class BoundaryFillExample extends JPanel {
    private BufferedImage image;
    private Graphics2D g2;
    private int targetColor;
    private int fillColor;
    public BoundaryFillExample() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.white);
        image = new BufferedImage(getPreferredSize().width, getPreferredSize().height, BufferedImage.TYPE_INT_RGB);
        g2 = image.createGraphics();
        g2.setColor(getBackground());
        g2.fillRect(0, 0, image.getWidth(), image.getHeight());
        drawShape();
        targetColor = Color.blue.getRGB();
        fillColor = Color.green.getRGB();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boundaryFill(e.getX(), e.getY());
                repaint();
            }
        });}
    private void drawShape() {
        g2.setColor(Color.blue);
        g2.fillRect(150, 150, 200, 200);}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);}
    private void boundaryFill(int startX, int startY) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(startX, startY));
        while (!stack.isEmpty()) {
            Point point = stack.pop();
            int x = point.x;
            int y = point.y;
            if (x < 0 || x >= image.getWidth() || y < 0 || y >= image.getHeight()) {
                continue;}
            int currentColor = image.getRGB(x, y);
            if (currentColor == targetColor) {
                image.setRGB(x, y, fillColor);
                stack.push(new Point(x - 1, y));
                stack.push(new Point(x + 1, y));
                stack.push(new Point(x, y - 1));
                stack.push(new Point(x, y + 1));
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("string args[]");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BoundaryFillExample());
        frame.pack();
        frame.setVisible(true);
    }}
