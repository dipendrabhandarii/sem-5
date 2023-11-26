import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class LineClippingAlgorithm extends JFrame implements ActionListener {
final int INSIDE = 0; 
final int LEFT = 1; 
final int RIGHT = 2; 
final int BOTTOM = 4; 
final int TOP = 8; 
//7:32 pm
int x_min, y_min, x_max, y_max;
JLabel l1, l2, l3, l4, l5, l6, l7, l8;
JTextField t1, t2, t3, t4, t5, t6, t7, t8;
Graphics g;
LineClippingAlgorithm() {
this.setTitle("Sutherland line clipping");
this.setSize(800, 700);
this.setLayout(null);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
l1 = new JLabel("Xmin:");
t1 = new JTextField();
l2 = new JLabel("Ymin:");
t2 = new JTextField();
l3 = new JLabel("Xmax:");
t3 = new JTextField();
l4 = new JLabel("Ymax:");
t4 = new JTextField();
l5 = new JLabel("X1:");
t5 = new JTextField();
l6 = new JLabel("Y1:");
t6 = new JTextField();
l7 = new JLabel("X2:");
t7 = new JTextField();
l8 = new JLabel("Y2:");
t8 = new JTextField();
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
l6.setBounds(250, 50, 50, 25);
t6.setBounds(320, 50, 100, 25);
l7.setBounds(250, 90, 50, 25);
t7.setBounds(320, 90, 100, 25);
l8.setBounds(250, 130, 50, 25);
t8.setBounds(320, 130, 100, 25);
JButton btn = new JButton("Clip Line");
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
this.add(l7);
this.add(t7);
this.add(l8);
this.add(t8);
this.add(btn);
this.setVisible(true);
g = this.getGraphics();
}
int computeCode(double x, double y)
{
int code = INSIDE;
if (x < x_min) // to the left of rectangle
code |= LEFT;
else if (x > x_max) // to the right of rectangle
code |= RIGHT;
if (y < y_min) // below the rectangle
code |= BOTTOM;
else if (y > y_max) // above the rectangle
code |= TOP;
return code;
}
@Override
public void actionPerformed(ActionEvent e)
{
 x_min =Integer.parseInt(t1.getText());
 y_min = Integer.parseInt(t2.getText());
 x_max = Integer.parseInt(t3.getText());
 y_max = Integer.parseInt(t4.getText());
double x1 = Integer.parseInt(t5.getText());
double y1 = Integer.parseInt(t6.getText());
double x2 = Integer.parseInt(t7.getText());
double y2 = Integer.parseInt(t8.getText());
g.drawLine(x_min, y_min, x_min, y_max);
g.drawLine(x_min, y_max, x_max, y_max);
g.drawLine(x_max, y_max, x_max, y_min);
g.drawLine(x_max, y_min, x_min, y_min);
g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
g.drawString("Before Clipping", 150, 600);
int code1 = computeCode(x1, y1);
int code2 = computeCode(x2, y2);
boolean accept = false;
while (true) {
if ((code1 == 0) && (code2 == 0)) {
accept = true;
break;
} else if ((code1 & code2) != 0) {
break;
} else {
int code_out;
double x = 0, y = 0;
if (code1 != 0) {
code_out = code1;
} else {
code_out = code2;
}
if ((code_out & TOP) != 0) {
x = x1 + (x2 - x1) * (y_max - y1) / (y2 - y1);
y = y_max;
} else if ((code_out & BOTTOM) != 0) {
x = x1 + (x2 - x1) * (y_min - y1) / (y2 - y1);
y = y_min;
} else if ((code_out & RIGHT) != 0) {
y = y1 + (y2 - y1) * (x_max - x1) / (x2 - x1);
x = x_max;
} else if ((code_out & LEFT) != 0) {
y = y1 + (y2 - y1) * (x_min - x1) / (x2 - x1);
x = x_min;
}
if (code_out == code1) {
x1 = x;
y1 = y;
code1 = computeCode(x1, y1);
} else {
x2 = x;
y2 = y;
code2 = computeCode(x2, y2);
}
} }
int tx = 300;
if (accept) {
g.drawLine(x_min + tx, y_min, x_min + tx, y_max);
g.drawLine(x_min + tx, y_max, x_max + tx, y_max);
g.drawLine(x_max + tx, y_max, x_max + tx, y_min);
g.drawLine(x_max + tx, y_min, x_min + tx, y_min);
g.drawLine((int) x1 + tx, (int) y1, (int) x2 + tx, (int) y2);
g.drawString("After Clipping", 460, 600);
} else {
System.out.println("Line is rejected.");
}
}
public static void main(String[] args) {
new LineClippingAlgorithm();
}
}