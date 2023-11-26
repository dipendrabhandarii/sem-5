import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MidPointCircleAlgorithm extends JFrame implements ActionListener {
JLabel l1, l2, l3;
JTextField t1, t2, t3;
Graphics g;
MidPointCircleAlgorithm() {
this.setTitle("aarko Golo");
this.setSize(800, 700);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setLayout(null);
l1 = new JLabel("h:");
t1 = new JTextField();
l2 = new JLabel("k:");
t2 = new JTextField();
l3 = new JLabel("r:");
t3 = new JTextField();
JButton btn = new JButton("Draw");
l1.setBounds(10, 10, 80, 25);
t1.setBounds(100, 10, 100, 25);
l2.setBounds(10, 50, 80, 25);
t2.setBounds(100, 50, 100, 25);
l3.setBounds(10, 90, 80, 25);
t3.setBounds(100, 90, 100, 25);
btn.setBounds(10, 130, 100, 25);
btn.addActionListener(this);
this.add(l1);
this.add(t1);
this.add(l2);
this.add(t2);
this.add(l3);
this.add(t3);
this.add(btn);
this.setVisible(true);
 g= this.getGraphics();
}
@Override
public void actionPerformed(ActionEvent e) {
int h = Integer.parseInt(t1.getText());
int k = Integer.parseInt(t2.getText());
int r = Integer.parseInt(t3.getText());
int xk = 0;
int yk = r;
int pk = 1 - r;
for (int i = 0; i <= r; i++) {
g.fillRect(xk + h, yk + k, 2, 2);
g.fillRect(yk + h, xk + k, 2, 2);
g.fillRect(-xk + h, yk + k, 2, 2);
g.fillRect(-yk + h, xk + k, 2, 2);
g.fillRect(-xk + h, -yk + k, 2, 2);
g.fillRect(-yk + h, -xk + k, 2, 2);
g.fillRect(xk + h, -yk + k, 2, 2);
g.fillRect(yk + h, -xk + k, 2, 2);
if (Math.round(xk) >= Math.round(yk)) {
break;
}
xk = xk + 1;
if (pk >= 0) {
yk = yk - 1;
pk = pk + 2 * (xk - yk) + 1;
} else {
pk = pk + 2 * xk + 1;
}}}
public static void main(String[] args) {
new MidPointCircleAlgorithm();
}}
