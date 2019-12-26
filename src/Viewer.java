import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
    public static final int width = 1000;
    public static final int height = 1000;
    private Cube cube;
    public Viewer(Cube cube) {
        this.cube = cube;
        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("kYбИк");
        this.setLocationRelativeTo(null);
        this.setState(JFrame.ICONIFIED);
    }
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D)gr;
        BasicStroke pen1 = new BasicStroke(2);
        g.setStroke(pen1);
        g.translate(Viewer.width/2, Viewer.height/2);
        g.setColor(Color.white);
        g.fillRect(-width/2,-height/2, width, height);
        cube.drawPersp(g, 6000);
    }
}