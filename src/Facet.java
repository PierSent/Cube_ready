
import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] vertex;
    Color color;
    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4,Color color){
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
        this.color = color;
    }
    public void out(){
        for(int i = 0; i < vertex.length; i++) {
            vertex[i].out();
            System.out.print(" - ");
            if(i==3){
                vertex[0].out();
            }else{
                vertex[i + 1].out();
            }
            System.out.print("\n");
        }
    }
    public void rotate(double ux, double uy, double uz){
        for(int i = 0; i < vertex.length; i++){
            vertex[i].rotate(ux,uy,uz);
        }
    }
    public void scale(double k){
        for(int i = 0; i < vertex.length; i++){
            vertex[i].scale(k);
        }
    }
    public void translate(double dx, double dy, double dz){
        for(int i = 0; i < vertex.length; i++){
            vertex[i].translate(dx,dy,dz);
        }
    }
    public void draw(Graphics2D g) {
        //double c = -3, t = (1 - c)/(-c);
        Path2D p = new Path2D.Double();
        p.moveTo(vertex[0].getX(), vertex[0].getY());
        p.lineTo(vertex[1].getX(), vertex[1].getY());
        p.lineTo(vertex[2].getX(), vertex[2].getY());
        p.lineTo(vertex[3].getX(), vertex[3].getY());
        p.lineTo(vertex[0].getX(), vertex[0].getY());
        p.closePath();
        //if (bulion()) {
            g.setColor(color);
            g.draw(p);
        //}
    }
        public void drawPersp(Graphics2D g, double c) {
            Path2D p = new Path2D.Double();
            double[] t = new double[4];
            t[0] = -c / (vertex[0].getZ() - c);
            t[1] = -c / (vertex[1].getZ() - c);
            t[2] = -c / (vertex[2].getZ() - c);
            t[3] = -c / (vertex[3].getZ() - c);
            p.moveTo(vertex[0].getX() * t[0], vertex[0].getY() * t[0]);
            p.lineTo(vertex[1].getX() * t[1], vertex[1].getY() * t[1]);
            p.lineTo(vertex[2].getX() * t[2], vertex[2].getY() * t[2]);
            p.lineTo(vertex[3].getX() * t[3], vertex[3].getY() * t[3]);
            p.lineTo(vertex[0].getX() * t[0], vertex[0].getY() * t[0]);
            p.closePath();
            if (bulion()) {
                g.setColor(this.color);
                g.fill(p);
            }

                Path2D p2 = new Path2D.Double();
                t[0] = -c/(vertex[0].getZ()-c);
                t[1] = -c/(vertex[1].getZ()-c);
                t[2] = -c/(vertex[2].getZ()-c);
                t[3] = -c/(vertex[3].getZ()-c);
                p2.moveTo(vertex[0].getX()*t[0], vertex[0].getY()*t[0]);
                p2.lineTo(vertex[1].getX()*t[1], vertex[1].getY()*t[1]);
                p2.lineTo(vertex[2].getX()*t[2], vertex[2].getY()*t[2]);
                p2.lineTo(vertex[3].getX()*t[3], vertex[3].getY()*t[3]);
                p2.lineTo(vertex[0].getX()*t[0], vertex[0].getY()*t[0]);
                p2.closePath();
                if(bulion()) {
                    g.setColor(Color.black);
                    g.draw(p);
                }
    }

    public boolean bulion(){
        if (R3Vector.normal(R3Vector.diagonals(vertex[0], vertex[1]),R3Vector.diagonals(vertex[0], vertex[3])).getZ()>0)
        { return false; }
        else{return true;}
    }
}