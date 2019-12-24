import java.awt.*;
import java.util.Scanner;

public class ConvexTest {

    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        Figure figure = convex.getFigure();
        double x, y, xLeftMin, yLeftMin, xRightMax, yRightMax;

        Scanner scan = new Scanner(System.in);
        System.out.print("Введи координаты прямоугольника для двух крайних углов : x1 = ");
        System.out.println(xLeftMin = scan.nextDouble());
        System.out.print("у1 = ");
        System.out.println(yLeftMin = scan.nextDouble());
        System.out.print("х2= ");
        System.out.println(xRightMax = scan.nextDouble());
        System.out.print("у2 = ");
        System.out.println(yRightMax = scan.nextDouble());
        Rectangle rectangle = new Rectangle(xLeftMin, yLeftMin, xRightMax, yRightMax);
        MyWindow window = new MyWindow(figure, rectangle);
        while (true) {
            // Scanner scan = new Scanner(System.in);
            System.out.print("x= ");
            System.out.println(x = scan.nextDouble());
            System.out.print("y= ");
            System.out.println(y = scan.nextDouble());
            figure = convex.add(new R2Point(x, y));
            System.out.println("S = " + convex.area() + " , P = " + convex.perimeter());
            window.setFigure(figure);
            System.out.println("count=" + calculateIntersections(figure, rectangle));
        }

    }

    private static double calculateIntersections(Figure figure, Rectangle rectangle) {
        double count = 0;
        R2Point[] pointsFigure = figure.getPoints();
        R2Point[] pointsRectangle = rectangle.getPoints();

        for (int i = 0; i < pointsFigure.length - 1; i++) {
            for (int j = 0; j < pointsRectangle.length - 1; j++) {
                //просто нахождение пересечений
                boolean intersect = checkSegmentsIntersect(pointsFigure[i], pointsFigure[i + 1], pointsRectangle[j], pointsRectangle[j + 1]);
                System.out.println(pointsFigure[i].toString() + "__" + pointsFigure[i + 1].toString() + " , " + pointsRectangle[j].toString() + "__" + pointsRectangle[j + 1].toString() + " " + intersect);
                if (intersect) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean checkSegmentsIntersect(R2Point p1, R2Point p2, R2Point p3, R2Point p4) {
        double x1 = p1.x;
        double y1 = p1.y;
        double x2 = p2.x;
        double y2 = p2.y;
        double x3 = p3.x;
        double y3 = p3.y;
        double x4 = p4.x;
        double y4 = p4.y;

        double x1h = Math.min(x1, x2);
        double y1h = Math.min(y1, y2);
        double x2h = Math.max(x1, x2);
        double y2h = Math.max(y1, y2);
        double x3h = Math.min(x3, x4);
        double y3h = Math.min(y3, y4);
        double x4h = Math.max(x3, x4);
        double y4h = Math.max(y3, y4);

        boolean limitRectangle = x2h >= x3h && x4h >= x1h && y2h >= y3h && y4h >= y1h;
        if (!limitRectangle) return false;

        double condition2 = vectorProduct(p1, p3, p1, p2) * vectorProduct(p1, p4, p1, p2);
        double condition3 = vectorProduct(p3, p1, p3, p4) * vectorProduct(p3, p2, p3, p4);

        if (condition2 <= 0 && condition3 <= 0) {
            return true;
        }
        return false;
    }

    private static double vectorProduct(R2Point a, R2Point b, R2Point c, R2Point d) {

        double abX = b.x - a.x;
        double abY = b.y - a.y;
        double cdX = d.x - c.x;
        double cdY = d.y - c.y;
        return abX * cdY - cdX * abY;
    }
}
