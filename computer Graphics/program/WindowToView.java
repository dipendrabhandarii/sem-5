import java.awt.*;
import java.util.Scanner;

public class WindowToView extends Frame {
    int xw_min, yw_min, xw_max, yw_max;
    int xv_min, yv_min, xv_max, yv_max;
    int x, y;

    public WindowToView() {
        setTitle("Window to Viewport Transformation");
        setSize(800, 800);
        setLayout(null);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter window coordinates (xw_min yw_min xw_max yw_max):");
        xw_min = sc.nextInt();
        yw_min = sc.nextInt();
        xw_max = sc.nextInt();
        yw_max = sc.nextInt();

        System.out.println("Enter viewport coordinates (xv_min yv_min xv_max yv_max):");
        xv_min = sc.nextInt();
        yv_min = sc.nextInt();
        xv_max = sc.nextInt();
        yv_max = sc.nextInt();

        System.out.println("Enter x-coordinate of the point to transform:");
        x = sc.nextInt();
        System.out.println("Enter y-coordinate of the point to transform:");
        y = sc.nextInt();

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        // Draw the window
        g.setColor(Color.BLUE);
        g.drawRect(xw_min, yw_min, xw_max - xw_min, yw_max - yw_min);

        // Draw the viewport
        g.setColor(Color.RED);
        g.drawRect(xv_min, yv_min, xv_max - xv_min, yv_max - yv_min);

        // Draw the original point in window
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 3, 3);

        // Map the point from window to viewport
        int xv = mapX(x, xw_min, xw_max, xv_min, xv_max);
        int yv = mapY(y, yw_min, yw_max, yv_min, yv_max);

        // Draw the transformed point in viewport
        g.setColor(Color.GREEN);
        g.fillRect(xv, yv, 3, 3);
    }

    private int mapX(int x, int xw_min, int xw_max, int xv_min, int xv_max) {
        return xv_min + (x - xw_min) * (xv_max - xv_min) / (xw_max - xw_min);
    }

    private int mapY(int y, int yw_min, int yw_max, int yv_min, int yv_max) {
        return yv_min + (y - yw_min) * (yv_max - yv_min) / (yw_max - yw_min);
    }

    public static void main(String[] args) {
        new WindowToView();
    }
}