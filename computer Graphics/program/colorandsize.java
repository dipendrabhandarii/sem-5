import javax.swing.*;
import java.awt.*;

public class colorandsize {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame shyam = new JFrame("DipendraBhandari");
        shyam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shyam.setSize(400, 300);

        // Create a JPanel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        // Create a JLabel with different colors, font sizes, and text
        JLabel label1 = new JLabel("Hello, World!");
        label1.setForeground(Color.RED);
        label1.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel label2 = new JLabel("Dipendra");
        label2.setForeground(Color.BLUE);
        label2.setFont(new Font("Verdana", Font.ITALIC, 16));

        JLabel label3 = new JLabel("TU symbol:12069");
        label3.setForeground(Color.GREEN);
        label3.setFont(new Font("Courier New", Font.PLAIN, 14));

        // Add the labels to the panel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        // Add the panel to the frame
        shyam.getContentPane().add(panel);

        // Set the frame visible
        shyam.setVisible(true);
    }
}
