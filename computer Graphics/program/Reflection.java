
//watermark sparkD123321
import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;
public class Reflection  extends JFrame{ //inheriting jframe 
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
    public Reflection()
    {
         setTitle("Line Reflection");
         setSize(width,height);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
    }
    public void paint(Graphics g) 
    {    
        // line before reflection
        g.setColor(Color.RED);
        g.drawLine(x1+400,y1+400,x2+400,y2+400);
        g.drawString("befor reflection",x1+400, y1+400);
        // reflection through origin
        g.setColor(Color.PINK);
        g.drawString(" reflection through origin",-x1+400, -y1+400);
        g.drawLine(-x1+400,-y1+400,-x2+400,-y2+400);
        // reflection through X-axis
        g.setColor(Color.GREEN);
        g.drawString(" reflection in x-axis",x1+400, -y1+400);
        g.drawLine(x1+400,-y1+400,x2+400,-y2+400);
        //reflection through y-axis
        g.setColor(Color.blue);
        g.drawLine(-x1+400,y1+400,-x2+400,y2+400);
        g.drawString(" reflection in y-axis",-x1+400, y1+400);
      // frame is divided into 4 quardant
      g.setColor(Color.white);
        g.drawLine(400,0,400,800);
        g.drawLine(0,400,800,400);
       // g.drawRect(100, 100, 50, 100);
        //g.fillOval(400,600,2,2);
    }
      public static void main(String[] args) {
    
    Reflection t = new Reflection();
    t.input();
    //System.exit(0);   
      }
    }
 
