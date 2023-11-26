//watermark sparkD123321
import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;
public class Scaling  extends JFrame{

  private Scanner sc = new Scanner(System.in);
  private int x1,y1,x2,y2,Sx,Sy;
  final String str  = "Ram bahadur";
  final String watermark= "hamaracodenachoro";
  

  public void input()

  { System.out.println(str);
    System.out.println(watermark); 
    System.out.println("copyright Alert!!");
    System.out.println("Hello hi darshan");
    System.out.println("Enter x1 : "); 
    x1 = sc.nextInt();
    System.out.println("Enter y1 : ");
    y1 = sc.nextInt();
    System.out.println("Enter x2 : ");
    x2 = sc.nextInt();
    System.out.println("Enter y2 : ");
    y2 = sc.nextInt();
    System.out.println("Enter Sx : ");
    Sx = sc.nextInt();
    System.out.println("Enter Sy : ");
    Sy = sc.nextInt();
    }
   
    private int width=800;
    private int height=800;
    public Scaling() {
         setTitle("thulo wa sano banaune");
         setSize(width,height);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
    }
      public void paint(Graphics g) {
        int fontsize=24;
        Font font = new Font("Arial", Font.PLAIN, fontsize);
        g.setFont(font); 
        int a,b,c,d;
        a= x1*Sx;
        b=y1*Sy;
        c=x2*Sx;
        d=y2*Sy;
        g.setColor(Color.RED);
        g.drawLine(x1,y1,x2,y2);
        g.drawString("Before Scaling",x1,y1);
        g.setColor(Color.GREEN);
        g.drawLine(a,b,c,d);
        g.drawString("After Scaling",x1*Sx,y1*Sy);
          // frame is divided into 4 quardant
      g.setColor(Color.white);
      g.drawLine(400,0,400,800);
      g.drawLine(0,400,800,400);
  }
        
    
      public static void main(String[] args) {
    
    Scaling s = new Scaling();
    s.input();
    //System.exit(0); 
     
      }}

    