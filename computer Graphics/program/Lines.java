
import javax.swing.*;
import java.awt.*;
public class Lines extends JFrame {
Lines() {
this.setTitle("Various Lines");
this.setSize(500, 500);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
}
@Override
public void paint(Graphics g) {
super.paint(g);
Graphics2D g2D = (Graphics2D) g;
//straight line
g2D.setStroke(new BasicStroke(4f));
g2D.drawLine(50, 100, 150, 100);
g2D.drawString("Normal Line", 50, 130);

g2D.setStroke(new BasicStroke(10f));
g2D.drawLine(50, 200, 150, 200);
g2D.drawString("Thick Line", 50, 230);

g2D.setStroke(new BasicStroke(1f));
g2D.drawLine(50, 300, 150, 300);
g2D.drawString("Thin Line", 50, 330);
g2D.setColor(Color.RED);

float[] dash = {2f, 0f, 2f};
BasicStroke bs1 = new BasicStroke(4f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND, 1.0f, dash, 3f);
g2D.setStroke(bs1);
g2D.drawLine(250, 100, 400, 100);
g2D.drawString("Dotted Line", 250, 130);

BasicStroke bs2 = new BasicStroke(10f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND, 1.0f, dash, 2f);
g2D.setStroke(bs2);
g2D.drawLine(250, 200, 400, 200); g2D.drawString("Thick Dotted Line", 250, 230);

BasicStroke bs3 = new BasicStroke(1f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND, 1.0f, dash, 2f);
g2D.setStroke(bs3);
g2D.drawLine(250, 300, 400, 300); g2D.drawString("DashedLine", 250, 330);
}
public static void main(String[] args) {
new Lines();
}
}