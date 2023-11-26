 import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.Scanner.*;

public class Rotation2  extends JFrame{
    private Scanner sc = new Scanner(System.in);
    int x1,y1,x2,y2;
    public void input()

  {
    System.out.println("Hello, welcome here, Now enjoy the program");
    System.out.println("Enter x1 : "); 
   int  x1 = sc.nextInt();
    System.out.println("Enter y1 : ");
   int  y1 = sc.nextInt();
    System.out.println("Enter x2 : ");
   int x2 = sc.nextInt();
    System.out.println("Enter y2 : ");
   int y2 = sc.nextInt();
    }

    Public Rotation2(){
    setTitle("LinerotationExample");
    setSize(800,800);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawString("Before Rotation", x2, y2);

        // Rotate the line
        double rotationAngle = Math.PI / 4; // 45 degrees in radians
        AffineTransform transform = new AffineTransform();
        transform.rotate(rotationAngle, (x1 + x2) / 2, (y1 + y2) / 2);
        Shape rotatedLine = transform.createTransformedShape(new Line2D.Double(x1, y1, x2, y2));

        // Draw the rotated line
        g2d. setColor(Color.RED);
        g2d.draw(rotatedLine);
        g2d.drawString("Aftere Rotation",x1,y1);
    }

    public static void main(String[] args)  {
            Rotation2 r=new Rotation2();
            

        }
    }



   
