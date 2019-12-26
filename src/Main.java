import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Facet f = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,1,0),
                new R3Vector(0,1,0), Color.yellow);
        f.out();
        Cube c = new Cube();
        c.scale(150);
        c.rotate(78,67,29);
        Viewer v = new Viewer(c);
    }
}