 
//watermark sparkD123321
//import the necessary class 
import java.util.Scanner;
import java.awt.*;

import javax.sound.sampled.SourceDataLine;
import javax.swing.JFrame;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class Reflection1  extends JFrame{ //inheriting jframe 
  private Scanner sc = new Scanner(System.in); //for the user input
  private int x1,y1,x2,y2;
  final String str  = "Dipendra Bhandari";
  final String watermark= "watermark:sparkD123321";
  public void input()

  { System.out.println(str);
    System.out.println(watermark); 
    System.out.println("Hello, welcome here, Now enjoy the program");
    System.out.println("Enter x1 : "); 
    x1 = sc.nextInt();
    System.out.println("Enter y1 : ");
    y1 = sc.nextInt();
    System.out.println("Enter x2 : ");
    x2 = sc.nextInt();
    System.out.println("Enter y2 : ");
    y2 = sc.nextInt();
    }
    private int width=800;
    private int height=800;
    private int y=20;
    private int x=20;
   // system.out.println("y"+y);
    public Reflection1()
    {
         setTitle("Line Reflection");
         setSize(width,height);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
    }
    public void paint(Graphics g) 
    {    
        // line before reflection
        int fontSize = 24;
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.RED);
        g.drawLine(x1+400,y1+400,x2+400,y2+400);
        g.drawString("befor reflection",x1+400, y1+400);
        // reflection on parallel to x-axis
        //reflection on y=b
        g.setColor(Color.GREEN);
        g.drawString(" reflection in y=20",x1+400, -y1+400+2*y);
         g.drawLine(x1+400,-y1+400+2*y,x2+400,-y2+400+2*y);
        //reflection on parallel to y-axis
        //reflection on x=a 
        g.setColor(Color.yellow);
        g.drawString("reflection in x=20", -x2+400+2*x, y2+400);
        g.drawLine(-x1+400+2*x, y1+400, -x2+400+2*x, y2+400);

      // frame is divided into 4 quardant
      g.setColor(Color.black);
        g.drawLine(400,0,400,800);
        g.drawLine(0,400,800,400);
    }
      public static void main(String[] args) {
    
    Reflection1 t = new Reflection1();
    t.input();  
      }
    }
 

