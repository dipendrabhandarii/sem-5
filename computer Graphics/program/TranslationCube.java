import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Scanner;

class TranslationCube extends JPanel {

    // Define the coordinates of the vertices of the cube
    private int[][] vertices = {
        {50, 50}, {150, 50}, {150, 150}, {50, 150},
        {100, 0}, {200, 0}, {200, 100}, {100, 100}
    };

    // Define the indices of the vertices for each face of the cube
    private int[][] faces = {
        {0, 1, 2, 3}, {4, 5, 6, 7},
        {0, 1, 5, 4}, {2, 3, 7, 6},
        {1, 2, 6, 5}, {0, 3, 7, 4}
    };

    private int translationX, translationY, translationZ;
    private int width = 800;
    private int height = 800;

    public TranslationCube() {
        setPreferredSize(new Dimension(width, height));
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
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

        for (int[] face : faces) {
            // Draw the original face in blue
            g.setColor(Color.BLUE);
            drawFace(g, face);

            // Perform 3D translation
            for (int i = 0; i < face.length; i++) {
                vertices[face[i]][0] += translationX;
                vertices[face[i]][1] += translationY;
                // We won't use the z-axis value for this simulation
            }

            // Draw the translated face in red
            g.setColor(Color.RED);
            drawFace(g, face);
        }
    }

    private void drawFace(Graphics g, int[] face) {
        for (int i = 0; i < face.length; i++) {
            int startIdx = face[i];
            int endIdx = face[(i + 1) % face.length];
            g.drawLine(vertices[startIdx][0], vertices[startIdx][1], vertices[endIdx][0], vertices[endIdx][1]);
        }
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("3D Translation on Cube");
        TranslationCube panel = new TranslationCube();
        panel.input();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
