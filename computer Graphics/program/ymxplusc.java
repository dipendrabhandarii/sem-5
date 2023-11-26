import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
public class ymxplusc extends JFrame implements ActionListener { 
 JLabel l1, l2, l3, l4, l5, l6, l7, l8;
JTextField t1, t2, t3, t4, t5, t6, t7, t8; Graphics g; 
ymxplusc() {
this.setTitle("Random line ma reflection"); this.setSize(800, 700);
this.setLayout(null);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
l1 = new JLabel("X1:");
t1 = new JTextField(); 
l2 = new JLabel("Y1:"); 
t2 = new JTextField(); 
l3 = new JLabel("X2:"); 
t3 = new JTextField(); 
l4 = new JLabel("Y2:"); 
t4 = new JTextField(); 
l5 = new JLabel("X3:"); 
t5 = new JTextField(); 
l6 = new JLabel("Y3:"); 
t6 = new JTextField(); 
l7 = new JLabel("m:"); 
t7 = new JTextField(); 
l8 = new JLabel("c:"); 
t8 = new JTextField();
JButton btn = new JButton("Reflect"); l1.setBounds(10, 10, 80, 25);
t1.setBounds(100, 10, 100, 25);
l2.setBounds(10, 50, 80, 25);
t2.setBounds(100, 50, 100, 25);
l3.setBounds(10, 90, 80, 25);
t3.setBounds(100, 90, 100, 25);
l4.setBounds(10, 130, 80, 25);
t4.setBounds(100, 130, 100, 25);
l5.setBounds(10, 170, 50, 25);
t5.setBounds(100, 170, 100, 25);
l6.setBounds(10, 210, 50, 25);
t6.setBounds(100, 210, 100, 25);
l7.setBounds(250, 10, 50, 25);
t7.setBounds(320, 10, 100, 25);
l8.setBounds(250, 50, 50, 25);
t8.setBounds(320, 50, 100, 25);
btn.setBounds(10, 250, 100, 25); 
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
this.add(l7);
this.add(t7);
this.add(l8);
this.add(t8);
this.add(btn); this.setVisible(true);
g = this.getGraphics();
}
double[][] translate(double[][] orgMatrix, int tx, int ty) {
 double[][] translationVector = {{1, 0, tx}, {0, 1, ty}, {0, 0, 1}}; 
double[][] tempMatrix = new double[3][3];
for (int i = 0; i < 3; i++) { for (int j = 0; j < 3; j++) { 
tempMatrix[i][j] = 0;
for (int k = 0; k < 3; k++) {
tempMatrix[i][j] += translationVector[i][k] * orgMatrix[k][j];
}}}
return tempMatrix; }
@Override
public void actionPerformed(ActionEvent e) { 
int x1 = Integer.parseInt(t1.getText());
int y1 = Integer.parseInt(t2.getText()); 
int x2 = Integer.parseInt(t3.getText()); 
int y2 = Integer.parseInt(t4.getText()); 
int x3 = Integer.parseInt(t5.getText()); 
int y3 = Integer.parseInt(t6.getText());
int m = Integer.parseInt(t7.getText());
int c = Integer.parseInt(t8.getText()); 
g.drawLine(400, 0, 400, 700);
g.drawLine(0, 350, 800, 350);
g.drawString("(400,350)", 340, 370);
double[][] orgMatrix = {{x1, x2, x3}, {y1, y2, y3}, {1, 1, 1}}; double[][] translatedMatrix = translate(orgMatrix, 400, 350);
 x1 = (int) translatedMatrix[0][0];
y1 = (int) translatedMatrix[1][0]; 
x2 = (int) translatedMatrix[0][1]; 
y2 = (int) translatedMatrix[1][1]; 
x3 = (int) translatedMatrix[0][2]; 
y3 = (int) translatedMatrix[1][2]; 
g.drawLine(x1, y1, x2, y2);
g.drawLine(x2, y2, x3, y3); 
g.drawLine(x3, y3, x1, y1);
g.drawString("Before Reflection", 550, 570);
 x1 = -(c / m); y2 = c;
g.drawLine(x1 + 400, 350, 400, y2 + 350);
g.drawString("y = " + m + "x" + " + " + c, 420, 580); 
double a = m * m - 1;
double b = m * m + 1; double[][] reflectionVector = {
{-a / b, (2 * m) / b, (-2 * m * c) / b},
{(2 * m) / b, a / b, (2 * c) / b},{0, 0, 1} };
double[][] reflectedMatrix = new double[3][3]; 
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 3; j++) { 
reflectedMatrix[i][j] = 0;
for (int k = 0; k < 3; k++) {
reflectedMatrix[i][j] += reflectionVector[i][k] * translatedMatrix[k][j];
}}}
double[][] finalMatrix = translate(reflectedMatrix, 800, 500); 
x1 = (int) finalMatrix[0][0];
y1 = (int) finalMatrix[1][0];
 x2 = (int) finalMatrix[0][1]; 
y2 = (int) finalMatrix[1][1]; 
x3 = (int) finalMatrix[0][2]; 
y3 = (int) finalMatrix[1][2]; 
g.drawLine(x1, y1, x2, y2);
g.drawLine(x2, y2, x3, y3); 
g.drawLine(x3, y3, x1, y1);
g.drawString("After Reflection", 160, 650);} 
public static void main(String[] args) { 
new ymxplusc(); }}
