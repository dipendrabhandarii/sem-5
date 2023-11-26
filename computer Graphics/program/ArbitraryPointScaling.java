import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Scanner;

class ArbitraryPointScaling extends JPanel {

    private int x1, y1, x2, y2, pivotX, pivotY;
    private double scaleX, scaleY;
    private int width = 800;
    private int height = 800;

    public ArbitraryPointScaling() {
        setPreferredSize(new Dimension(width, height));
    }
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x1: ");
        x1 = sc.nextInt();
        System.out.println("Enter y1: ");
        y1 = sc.nextInt();
        System.out.println("Enter x2: ");
        x2 = sc.nextInt();
        System.out.println("Enter y2: ");
        y2 = sc.nextInt();
        System.out.println("Enter pivot X: ");
        pivotX = sc.nextInt();
        System.out.println("Enter pivot Y: ");
        pivotY = sc.nextInt();
        System.out.println("Enter scaling factor for X: ");
        scaleX = sc.nextDouble();
        System.out.println("Enter scaling factor for Y: ");
        scaleY = sc.nextDouble();
        sc.close();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int newX1 = (int) ((x1 - pivotX) * scaleX) + pivotX;
        int newY1 = (int) ((y1 - pivotY) * scaleY) + pivotY;
        int newX2 = (int) ((x2 - pivotX) * scaleX) + pivotX;
        int newY2 = (int) ((y2 - pivotY) * scaleY) + pivotY;
        // Draw the original rectangle in blue
        g.setColor(Color.BLUE);
        g.drawRect(x1, y1, x2 - x1, y2 - y1);
        // Draw the scaled rectangle in red
        g.setColor(Color.RED);
        g.drawRect(newX1, newY1, newX2 - newX1, newY2 - newY1);
    }
    public static void main(String args[]) {
        JFrame frame = new JFrame("Arbitrary Point Scaling of a Rectangle");
        ArbitraryPointScaling panel = new ArbitraryPointScaling();
        panel.input();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
