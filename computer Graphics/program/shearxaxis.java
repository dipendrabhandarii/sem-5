import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.Scanner;
class shearxaxis extends JFrame{
    Scanner sc= new Scanner(System.in);
    int x1,x2,x3,x4,y1,y2,y3,y4,shx;
    public void input(){
   x1 = sc.nextInt(); 
   y1 = sc.nextInt(); 
   x2 = sc.nextInt();  
   y2 = sc.nextInt(); 
   x3 = sc.nextInt(); 
   y3 = sc.nextInt(); 
   x4 = sc.nextInt(); 
   y4 = sc.nextInt(); 
   shx = sc.nextInt(); 
  
    }
  

  public shearxaxis(){
    int py1,py2,py3,py4;
    setTitle("x shearing ho hai");
    setSize(1000,1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);}
@Override
public void paint(Graphics g){
    //before shear
    g.setColor(Color.white);
    g.fillRect(0, 0, getWidth(),getHeight());
    g.setColor(Color.red);
    g.drawLine(x1, y1, x2, y2);
    g.drawLine(x2, y2, x3, y3);
    g.drawLine(x3, y3, x4, y4);
    g.drawLine(x4, y4, x1, y1);
    //after shear
    g.setColor(Color.blue);
    g.drawLine(x1 + y1*shx, y1, x2 + y2*shx, y2);
    g.drawLine(x2+y2*shx, y2 + y2*shx, x3+  y3*shx, y3);
    g.drawLine(x3+  y3*shx, y3, x4+  y4*shx, y4);
    g.drawLine(x4+  y4*shx, y4, x1 + y1*shx, y1); 
}
  public static void main(String args[]){
    shearxaxis s=new shearxaxis();
s.input();
}}

