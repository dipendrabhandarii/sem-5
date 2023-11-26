import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Scanner;

class ThreeDTranslation extends JPanel {

    private int x1, y1, x2, y2;
    private int translationX, translationY, translationZ;
    private int width = 800;
    private int height = 800;

    public ThreeDTranslation() {
        setPreferredSize(new Dimension(width, height));
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter initial X1 coordinate: ");
        x1 = sc.nextInt();
        System.out.println("Enter initial Y1 coordinate: ");
        y1 = sc.nextInt();
        System.out.println("Enter initial X2 coordinate: ");
        x2 = sc.nextInt();
        System.out.println("Enter initial Y2 coordinate: ");
        y2 = sc.nextInt();
        System.out.println("Enter translation along X axis: ");
        translationX = sc.nextInt();
        System.out.println("Enter translation along Y axis: ");
        translationY = sc.nextInt();
        System.out.println("Enter translation along Z axis: ");
        // In this simulation, we won't use the z-axis value.
        translationZ = sc.nextInt();
        sc.close();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the original rectangle in blue
        g.setColor(Color.BLUE);
        g.drawRect(x1, y1, x2 - x1, y2 - y1);

        // Perform 3D translation
        x1 += translationX;
        y1 += translationY;
        x2 += translationX;
        y2 += translationY;

        // Draw the translated rectangle in red
        g.setColor(Color.RED);
        g.drawRect(x1, y1, x2 - x1, y2 - y1);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("DDD");
        ThreeDTranslation panel = new ThreeDTranslation();
        panel.input();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
