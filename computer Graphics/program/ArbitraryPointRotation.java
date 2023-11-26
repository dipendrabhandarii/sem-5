import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Scanner;
class ArbitraryPointRotation extends JPanel {
    private int x, y, pivotX, pivotY;
    private double angle;
    private int width = 800;
    private int height = 800;
    public ArbitraryPointRotation() {
        setPreferredSize(new Dimension(width, height));
    }
    public void input() {
        Scanner meow = new Scanner(System.in);
        System.out.println("Enter x: ");
        x = meow.nextInt();
        System.out.println("Enter y: ");
        y = meow.nextInt();
        System.out.println("Enter pivot X: ");
        pivotX = meow.nextInt();
        System.out.println("Enter pivot Y: ");
        pivotY = meow.nextInt();
        System.out.println("Enter rotation angle (in degrees): ");
        angle = Math.toRadians(meow.nextDouble());
        meow.close();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the original point in blue
        int fontSize = 24;
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        g.setFont(font);
        g.setColor(Color.BLUE);
        g.fillOval(x - 5, y - 5, 30, 30);
        g.drawString("before",x+5,y);
        // Perform arbitrary point rotation
        int newX = (int) (pivotX + (x - pivotX) * Math.cos(angle) - (y - pivotY) * Math.sin(angle));
        int newY = (int) (pivotY + (x - pivotX) * Math.sin(angle) + (y - pivotY) * Math.cos(angle));

        // Draw the rotated point in red
        g.setColor(Color.RED);
        g.fillOval(newX - 5, newY - 5, 30, 30);
        g.drawString("after",newX+5,newY);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Arbitrary Point Rotation");
        ArbitraryPointRotation panel = new ArbitraryPointRotation();
        panel.input();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

