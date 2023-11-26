import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Translation3D extends JFrame implements ActionListener {
JLabel l1, l2, l3, l4, l5, l6;
JTextField t1, t2, t3, t4, t5, t6;
Graphics g; 
Translation3D()
{
this.setTitle("hello hello");
this.setSize(800, 800);
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
l5 = new JLabel("tx:");
t5 = new JTextField();
l6 = new JLabel("ty:");
t6 = new JTextField();
JButton btn = new JButton("Draw");
l1.setBounds(10, 10, 80, 25);
t1.setBounds(100, 10, 100, 25);
l2.setBounds(10, 50, 80, 25);
t2.setBounds(100, 50,100, 25);
l3.setBounds(10, 90, 80, 25);
t3.setBounds(100, 90, 100, 25);
l4.setBounds(10, 130, 80, 25);
t4.setBounds(100, 130, 100, 25);
l5.setBounds(250, 10, 50, 25);
t5.setBounds(320, 10, 100, 25);
l6.setBounds(250, 50, 50, 25);
t6.setBounds(320, 50, 100, 25);
btn.setBounds(10, 170, 100, 25);
btn.addActionListener(this);
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
@Override
public void actionPerformed(ActionEvent e) {
int x = Integer.parseInt(t1.getText());


int y = Integer.parseInt(t2.getText());
int length = Integer.parseInt(t3.getText());
int shift = Integer.parseInt(t4.getText());
int tx = Integer.parseInt(t5.getText());
int ty= Integer.parseInt(t6.getText());
Point[] cubeOnePoints = getCubeOnePoints(x, y, length);
Point[] cubeTwoPoints = getCubeTwoPoints(x, y, length, shift);
g.setColor(Color.blue);
g.drawRect(x, y, length, length);
g.drawRect(x + shift, y + shift, length, length); 
for (int i = 0; i < 4; i++) {
g.drawLine(cubeOnePoints[i].x, cubeOnePoints[i].y, cubeTwoPoints[i].x,
cubeTwoPoints[i].y);
}
g.setColor(Color.red);
g.drawString("Before Translation", 150, 540);
g.drawRect(x + tx, y + ty, length, length);
g.drawRect(x + shift + tx, y + shift + ty, length, length); for
(int i = 0; i < 4; i++) {
g.drawLine(cubeOnePoints[i].x + tx, cubeOnePoints[i].y + ty, cubeTwoPoints[i].x + tx,
cubeTwoPoints[i].y + ty);
}

g.drawString("After Translation", 560, 640);
}
public static void main(String[] args) {
new Translation3D();
}
}