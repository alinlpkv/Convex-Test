import java.awt.*;

public class Convex {
    private Figure fig;
    public Convex() {
        fig = new Void();
    }
    public Figure add(R2Point p) {
        fig= fig.add(p);
        return fig;
    }
    public double area() {
        return fig.area();
    }
    public double perimeter() {
        return fig.perimeter();
    }
    public Figure getFigure(){ return fig;}
}
