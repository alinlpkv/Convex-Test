public class Rectangle {
    public R2Point bottomLeft, topRight;
    public Rectangle(double bottomLeftX, double bottomLeftY, double topRightX, double topRightY ){
        this.bottomLeft= new R2Point(bottomLeftX,bottomLeftY);
        this.topRight=new R2Point(topRightX, topRightY);
    }

    public R2Point[] getPoints(){
         return new R2Point[]{new R2Point(bottomLeft.x, bottomLeft.y),new R2Point(bottomLeft.x, topRight.y),new R2Point(topRight.x, topRight.y), new R2Point(topRight.x, bottomLeft.y),new R2Point(bottomLeft.x, bottomLeft.y)};
    }
}
