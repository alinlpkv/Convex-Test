import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame{
    private Figure f;
    private Rectangle r;
    public MyWindow(){
        this.setSize(700,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public MyWindow(Figure f, Rectangle r){
        this();
        this.f=f;
        this.r=r;     //обязательно именя f, если другое, то без this.
        this.setTitle("Окошко");
    }

    public void paint (Graphics g){
//        g.clearRect(0,0,1000,1000);
       super.paintComponents(g);
//        g.translate(getWidth()/2,getHeight()/2);
        R2Point[] points= f.getPoints();
        R2Point[] pointsRectangle=r.getPoints();
        this.drawPolygon(g, points);
        this.drawPolygon(g, pointsRectangle);
    }


    private  void drawPolygon(Graphics g, R2Point[] points){
        for (int i=0; i< points.length-1; i++){
               g.drawLine((int) points[i].x, (int) points[i].y, (int) points[i + 1].x, (int) points[i + 1].y);

        }
//        if (points.length>2) {
//            int lastIndex = points.length - 1;
//            g.drawLine((int) points[0].x, (int) points[0].y, (int) points[lastIndex].x, (int) points[lastIndex].y);
//        }
        if (points.length==1) {g.fillOval((int) points[0].x, (int) points[0].y,5,5); }
    }

    public void setFigure(Figure figure){
        this.f=figure;
        this.update(this.getGraphics());
    }


}
