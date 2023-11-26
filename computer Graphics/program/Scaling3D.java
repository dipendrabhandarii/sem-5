import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Scaling3D extends JFrame implements ActionListener {
JLabel l1, l2, l3, l4, l5, l6;
JTextField t1, t2, t3, t4, t5, t6,t7;
Graphics g; Scaling3D()
{
this.setTitle("Scaling ko Frame");
this.setSize(800, 700);
this.setLayout(null);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
l1 = new JLabel("X:");
t1 = new JTextField();
l2 = new JLabel("Y:");
t2 = new JTextField();
l3 = new JLabel("Length:");
t3 = new JTextField();
l4 = new JLabel("Shift:");
t4 = new JTextField();
l5 = new JLabel("sx:");
t5 = new JTextField();
l6 = new JLabel("sy:");
t6 = new JTextField();
t7= new JTextField("Dipendra Bhandari");
JButton btn = new JButton("Scale");
l1.setBounds(10, 10, 80, 25); t1.setBounds(100, 10,100, 25);
l2.setBounds(10, 50, 80, 25);
t2.setBounds(100, 50, 100, 25); l3.setBounds(10, 90,80, 25);
t3.setBounds(100, 90, 100, 25);
l4.setBounds(10, 130, 80, 25);
t4.setBounds(100, 130, 100, 25);
l5.setBounds(250, 10, 50, 25);
t5.setBounds(320, 10, 100, 25);
l6.setBounds(250, 50, 50, 25);
t6.setBounds(320, 50, 100, 25);
t7.setBounds(600,700,30,20);

btn.setBounds(10, 170, 100, 25);
btn.addActionListener(this);
this.add(t7);
this.add(l1);
this.add(t1);
this.add(l2);
this.add(t2);
this.add(l3);
this.add(t3);
this.add(l4);
this.add(t4);
this.add(l5);
this.add(t5);
this.add(l6);
this.add(t6);
this.add(btn);
this.setVisible(true);
g = this.getGraphics();
}
Point[] getCubeOnePoints(int x, int y, int length) {
Point[] points = new Point[4];
points[0] = new Point(x, y);
points[1] = new Point(x + length, y); points[2]
= new Point(x + length, y + length); points[3]
= new Point(x, y + length);
return points;
}
Point[] getCubeTwoPoints(int x, int y, int length, int shift) {
int newX = x + shift;
int newY = y + shift;
Point[] points = new Point[4];
points[0] = new Point(newX, newY);
points[1] = new Point(newX + length, newY);
points[2] = new Point(newX + length, newY + length);
points[3] = new Point(newX, newY + length);
return points;
}
Point[] drawCubeOnePointsAfterScaling(int x, int y, int length, int sx, int sy) {
Point[] points = new Point[4];
points[0] = new Point(x * sx, y * sy);
points[1] = new Point((x + length) * sx, y * sy);
points[2] = new Point((x + length) * sx, (y + length) * sy);
points[3] = new Point(x * sx, (y + length) * sy);
int x1 = points[0].x;
int y1 = points[0].y;
int x2 = points[1].x;
int y2 = points[1].y;
int x3 = points[2].x;
int y3 = points[2].y;
int x4 = points[3].x;
int y4 = points[3].y;
g.drawLine(x1, y1, x2, y2);
g.drawLine(x2, y2, x3, y3);
g.drawLine(x3, y3, x4, y4);
g.drawLine(x4, y4, x1, y1); return
points;
}
Point[] drawCubeTwoPointsAfterScaling(int x, int y, int length, int shift, int sx, int sy) {
int newX = x + shift;
int newY = y + shift;
Point[] points = new Point[4];
points[0] = new Point(newX * sx, newY * sy);
points[1] = new Point((newX + length) * sx, newY * sy); points[2]
= new Point((newX + length) * sx, (newY + length) * sy); points[3]
= new Point(newX * sx, (newY + length) * sy);
int x1 = points[0].x;
int y1 = points[0].y;
int x2 = points[1].x;
int y2 = points[1].y;
int x3 = points[2].x;
int y3 = points[2].y;
int x4 = points[3].x;
int y4 = points[3].y;
g.drawLine(x1, y1, x2, y2);
g.drawLine(x2, y2, x3, y3);
g.drawLine(x3, y3, x4, y4);
g.drawLine(x4, y4, x1, y1); return
points;
}
@Override
public void actionPerformed(ActionEvent e) { int x
= Integer.parseInt(t1.getText());
int y = Integer.parseInt(t2.getText()); int
length = Integer.parseInt(t3.getText()); int
shift = Integer.parseInt(t4.getText()); int
sx = Integer.parseInt(t5.getText()); int sy
= Integer.parseInt(t6.getText());
Point[] cubeOnePoints = getCubeOnePoints(x, y, length); Point[]
cubeTwoPoints = getCubeTwoPoints(x, y, length, shift);
g.drawRect(x, y, length, length);
g.drawRect(x + shift, y + shift, length, length);
g.drawString("Before Scaling", 100, 360); for
(int i = 0; i < 4; i++) {
g.drawLine(cubeOnePoints[i].x, cubeOnePoints[i].y, cubeTwoPoints[i].x,
cubeTwoPoints[i].y);
}
Point[] finalCubeOnePoints = drawCubeOnePointsAfterScaling(x, y, length, sx, sy);
Point[] finalCubeTwoPoints = drawCubeTwoPointsAfterScaling(x, y, length, shift, sx, sy);
for (int i = 0; i < 4; i++) {

g.drawLine(finalCubeOnePoints[i].x, finalCubeOnePoints[i].y, finalCubeTwoPoints[i].x,
finalCubeTwoPoints[i].y);
}
g.drawString("After Scaling", 560, 620);
g.drawString("dipendra bhandari",580,650);
}

public static void main(String[] args) {
new Scaling3D();
}
}
