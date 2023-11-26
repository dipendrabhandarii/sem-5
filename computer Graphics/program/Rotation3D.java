import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Rotation3D extends JFrame implements ActionListener {
JLabel l1, l2, l3, l4, l5;
JTextField t1, t2, t3, t4, t5;
Graphics g; Rotation3D()
{
this.setTitle("Rotation ho hai 3D wala");
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
l5 = new JLabel("Angle:");
t5 = new JTextField();
JButton btn = new JButton("Draw");
l1.setBounds(10, 10, 80, 25);
t1.setBounds(100, 10, 100, 25);
l2.setBounds(10, 50, 80, 25);
t2.setBounds(100, 50, 100, 25);
l3.setBounds(10, 90, 80, 25);
t3.setBounds(100, 90, 100, 25);
l4.setBounds(10, 130, 80, 25);
t4.setBounds(100, 130, 100, 25);
l5.setBounds(250, 10, 50, 25);
t5.setBounds(320, 10, 100, 25);
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
this.add(btn);
this.setVisible(true);
g = this.getGraphics();
}
Point[] getCubeOnePoints(int x, int y, int length) {
Point[] points = new Point[4];
points[0] = new Point(x, y);
points[1] = new Point(x + length, y);
points[2] = new Point(x + length, y + length);
points[3] = new Point(x, y + length);
return points;
}
Point[] getCubeTwoPoints(int x, int y, int length, int shift) { int newX = x + shift;
int newY = y + shift; Point[] points = new Point[4];
points[0] = new Point(newX, newY);
points[1] = new Point(newX + length, newY);
points[2] = new Point(newX + length, newY + length);
points[3] = new Point(newX, newY + length);
return points;
}
Point[] drawCubeOnePointsAfterRotation(int x, int y, int length, double rad) {
int[][] orgMatrix = {
{x, x + length, x + length, x}, {y,
y, y + length, y + length},
{1, 1, 1, 1}
};
double[][] rotationVector = {
{Math.cos(rad), -Math.sin(rad), 0},
{Math.sin(rad), Math.cos(rad), 0},
{0, 0, 1}
};
int[][] finalMatrix = new int[3][4];
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 4; j++) {
finalMatrix[i][j] = 0;
for (int k = 0; k < 3; k++) {
finalMatrix[i][j] += rotationVector[i][k] * orgMatrix[k][j];
}
}
}
int x1 = finalMatrix[0][0];
int y1 = finalMatrix[1][0]; int
x2 = finalMatrix[0][1];
int y2 = finalMatrix[1][1]; int
x3 = finalMatrix[0][2];
int y3 = finalMatrix[1][2];
int x4 = finalMatrix[0][3];
int y4 = finalMatrix[1][3];
Point[] points = new Point[4];
points[0] = new Point(x1, y1);
points[1] = new Point(x2, y2);
points[2] = new Point(x3, y3);
points[3] = new Point(x4, y4);
g.drawLine(x1, y1, x2, y2);
g.drawLine(x2, y2, x3, y3);
g.drawLine(x3, y3, x4, y4);
g.drawLine(x4, y4, x1, y1); return
points;
}
Point[] drawCubeTwoPointsAfterRotation(int x, int y, int length, int shift, double rad) {
int newX = x + shift;
int newY = y + shift;
int[][] orgMatrix = {
{newX, newX + length, newX + length, newX},
{newY, newY, newY + length, newY + length},
{1, 1, 1, 1}
};
double[][] rotationVector = {
{Math.cos(rad), -Math.sin(rad), 0},
{Math.sin(rad), Math.cos(rad), 0},
{0, 0, 1}
};
int[][] finalMatrix = new int[3][4];
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 4; j++) {
finalMatrix[i][j] = 0;
for (int k = 0; k < 3; k++) {
finalMatrix[i][j] += rotationVector[i][k] * orgMatrix[k][j];
}
}
}
int x1 = finalMatrix[0][0]; int
y1 = finalMatrix[1][0];
int x2 = finalMatrix[0][1]; int
y2 = finalMatrix[1][1];
int x3 = finalMatrix[0][2]; int
y3 = finalMatrix[1][2];
int x4 = finalMatrix[0][3];
int y4 = finalMatrix[1][3];
Point[] points = new Point[4];
points[0] = new Point(x1, y1);
points[1] = new Point(x2, y2);
points[2] = new Point(x3, y3);
points[3] = new Point(x4, y4);
g.drawLine(x1, y1, x2, y2);
g.drawLine(x2, y2, x3, y3);
g.drawLine(x3, y3, x4, y4);
g.drawLine(x4, y4, x1, y1); return
points;
}
@Override
public void actionPerformed(ActionEvent e) {
int x = Integer.parseInt(t1.getText());
int y = Integer.parseInt(t2.getText());
int length = Integer.parseInt(t3.getText());
int shift = Integer.parseInt(t4.getText());
int angle = Integer.parseInt(t5.getText());
double rad = Math.toRadians(angle);
Point[] cubeOnePoints = getCubeOnePoints(x, y, length); Point[]
cubeTwoPoints = getCubeTwoPoints(x, y, length, shift);
g.drawRect(x, y, length, length);
g.drawRect(x + shift, y + shift, length, length);
g.drawString("Before Rotation", 370, 530); for
(int i = 0; i < 4; i++) {
g.drawLine(cubeOnePoints[i].x, cubeOnePoints[i].y, cubeTwoPoints[i].x,
cubeTwoPoints[i].y);
}
g.drawString("Rotation in Counter-Clockwise", 200, 650);
Point[] finalCubeOnePoints = drawCubeOnePointsAfterRotation(x, y, length, rad);
Point[] finalCubeTwoPoints = drawCubeTwoPointsAfterRotation(x, y, length, shift, rad);
for (int i = 0; i < 4; i++) {
g.drawLine(finalCubeOnePoints[i].x,
finalCubeOnePoints[i].y,
finalCubeTwoPoints[i].x,
finalCubeTwoPoints[i].y);
}
Point[] finalCubeOnePointsClockwise = drawCubeOnePointsAfterRotation(x, y, length, -
rad);
Point[] finalCubeTwoPointsClockwise = drawCubeTwoPointsAfterRotation(x, y, length,
shift, -rad);
for (int i = 0; i < 4; i++) {
g.drawLine(
finalCubeOnePointsClockwise[i].x, finalCubeOnePointsClockwise[i].y,
finalCubeTwoPointsClockwise[i].x,
finalCubeTwoPointsClockwise[i].y);
}
g.drawString("Rotation in Clockwise", 560, 280);
g.drawString("12069",580,300);
}
public static void main(String[] args) {
new Rotation3D();
}
}