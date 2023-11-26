import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class BoundaryFillDemo extends JPanel { 
private BufferedImage image;
private Graphics2D g2;
public static void main(String[] args) {
JFrame frame = new JFrame("Boundary Fill--12080/20");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 BoundaryFillDemo demo = new BoundaryFillDemo();
 frame.add(demo);
  frame.pack();
   frame.setVisible(true); }
  public BoundaryFillDemo() {
  image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
  setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
  setMinimumSize(getPreferredSize());
  g2 = image.createGraphics();
  g2.setColor(Color.white);
   g2.fillRect(0, 0, image.getWidth(), image.getHeight());
   drawShape();
    addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
   boundaryFill(e.getX(), e.getY(), Color.yellow.getRGB(), Color.green.getRGB());
 repaint();
 }}); }
private void drawShape() {
g2.setColor(Color.blue);
g2.fillRect(150, 150, 200, 200); }
@Override
public void paintComponent(Graphics g) {
g.drawImage(image, 0, 0, null);
}
public void boundaryFill(int x, int y, int targetColor, int fillColor) {
int currentColor = image.getRGB(x, y);
if (currentColor != targetColor && currentColor != fillColor) {
image.setRGB(x, y, fillColor);
boundaryFill(x - 1, y, targetColor, fillColor);
boundaryFill(x + 1, y, targetColor, fillColor);
 boundaryFill(x, y - 1, targetColor, fillColor);
boundaryFill(x, y + 1, targetColor, fillColor);
  }}}
