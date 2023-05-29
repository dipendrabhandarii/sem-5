//watermark sparkD123321
import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;
public class Translation  extends JFrame{

  private Scanner sc = new Scanner(System.in);
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
   
    private int width=400;
    private int height=400;
    private int dx=20;
    private int dy=20;
    public Translation() {
         setTitle("Line Translation");
         setSize(width,height);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
    }
      public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(x1,y1,x2,y2);
        g.drawString("Before translation",x1,y1);
        g.setColor(Color.GREEN);
        g.drawLine(x1+dx,y1+dy,x2+dx,y2+dy);
        g.drawString("After translation",x1+dx,y1+dx);
        
    }
      public static void main(String[] args) {
    
    Translation t = new Translation();
    t.input();
    //System.exit(0); 
     
       
      }

    }