public class Void implements  Figure {
    public double perimeter() {
        return 0.0;
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point p) {
        return new Point(p);
    }

    public R2Point[] getPoints(){
        return new R2Point[0];
    };
}
