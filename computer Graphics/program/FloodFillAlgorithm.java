import java.awt.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class FloodFillAlgorithm extends JFrame {
FloodFillAlgorithm() {
this.setTitle("10408/19 - Flood Fill Algorithm"); this.setSize(500,
500);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); this.setVisible(true);
}
@Override
public void paint(Graphics g) {
BufferedImage image1, image2;
try {
image1 = ImageIO.read(new File("D:\\image12.jpg"));
image2 = ImageIO.read(new File("D:\\image13.jpg"));
Color bc1 = new Color(image1.getRGB(35, 35));
floodFill4(image1, 35, 35, bc1, Color.red);
g.drawImage(image1, 50, 50, this);
g.drawString("4-Fill Method", 60, 150); Color
bc2 = new Color(image2.getRGB(35, 35));
floodFill8(image2, 35, 35, bc2, Color.green);
g.drawImage(image2, 250, 50, this);
g.drawString("8-Fill Method", 270, 150); }
catch (IOException e) {
throw new RuntimeException(e);
}
}
void floodFill4(BufferedImage image, int x, int y, Color boundaryColor, Color fillColor) {
Color c2 = new Color(image.getRGB(x, y));
if (Math.abs(c2.getGreen() - boundaryColor.getGreen()) < 30
&& Math.abs(c2.getRed() - boundaryColor.getRed()) < 30
&& Math.abs(c2.getBlue() - boundaryColor.getBlue()) < 30
) {
image.setRGB(x, y, fillColor.getRGB()); floodFill4(image,
x, y + 1, boundaryColor, fillColor); floodFill4(image, x +
1, y, boundaryColor, fillColor); floodFill4(image, x - 1, y,
boundaryColor, fillColor); floodFill4(image, x, y - 1,
boundaryColor, fillColor);
}
}
void floodFill8(BufferedImage image, int x, int y, Color boundaryColor, Color fillColor) {
Color c2 = new Color(image.getRGB(x, y));
if (Math.abs(c2.getGreen() - boundaryColor.getGreen()) < 30
&& Math.abs(c2.getRed() - boundaryColor.getRed()) < 30
&& Math.abs(c2.getBlue() - boundaryColor.getBlue()) < 30
) {
image.setRGB(x, y, fillColor.getRGB()); floodFill8(image,
x + 1, y, boundaryColor, fillColor); floodFill8(image, x -
1, y, boundaryColor, fillColor); floodFill8(image, x, y + 1,
boundaryColor, fillColor); floodFill8(image, x, y - 1,
boundaryColor, fillColor); floodFill8(image, x + 1, y + 1,
boundaryColor, fillColor); floodFill8(image, x - 1, y + 1,
boundaryColor, fillColor); floodFill8(image, x + 1, y - 1,
boundaryColor, fillColor); floodFill8(image, x - 1, y - 1,
boundaryColor, fillColor); }
}
public static void main(String[] args) {
new FloodFillAlgorithm();
}
}