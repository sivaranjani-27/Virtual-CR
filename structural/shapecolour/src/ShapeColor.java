import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeColor extends JPanel {
    private String shape;
    private String color;

    public ShapeColor(String shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (color.equalsIgnoreCase("red")) {
            g2d.setColor(Color.RED);
        } else if (color.equalsIgnoreCase("blue")) {
            g2d.setColor(Color.BLUE);
        } else {
            g2d.setColor(Color.RED); // default to red
        }

        if (shape.equalsIgnoreCase("circle")) {
            g2d.fillOval(50, 50, 200, 200);
        } else if (shape.equalsIgnoreCase("rectangle")) {
            g2d.fillRect(50, 50, 200, 200);
        } else {
            g2d.fillOval(50, 50, 200, 200); // default to circle
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the shape (circle or rectangle): ");
            String shape = scanner.nextLine();

            System.out.println("Enter the color (red or blue): ");
            String color = scanner.nextLine();

            ShapeColor shapeColor = new ShapeColor(shape, color);

            JFrame frame = new JFrame("Shape Color");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(shapeColor);
            frame.setSize(300, 300);
            frame.setVisible(true);

            System.out.println("Do you want to continue? (yes/no) or type 'exit' to quit:");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("no")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else if (response.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                System.exit(0);
            }
        }
    }
}