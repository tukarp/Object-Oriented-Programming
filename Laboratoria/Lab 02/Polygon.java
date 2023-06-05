package com.company;

import java.util.Locale;

public class Polygon extends Shape{
    Point arr[];

    public Polygon(int count, Style style) {
        super(style);
        arr = new Point[count];
    }

    public void setPoint(int index, Point point) {
        arr[index] = point;
    }

    public void setPoints(Point points[]){
        arr = points;
    }

    public String toSvg() {
        String pointsString = "";
        for(Point point : arr)
            pointsString += point.x + "," + point.y + " ";
        return String.format(Locale.ENGLISH,"<polygon points=\"%s\" style=\"%s\"/>", pointsString, style.toSvg());
    }

    public Point rightBottom() {
        double bottom = 0, right = 0;
        for(Point point : arr) {
            if(point.x > right)
                right = point.x;
            if(point.y > bottom)
                bottom = point.y;
        }
        return new Point(right, bottom);
    }

    public static Polygon square(Line diagonal, Style style) {
        Point center = new Point((diagonal.getP1().x + diagonal.getP2().x) / 2, (diagonal.getP1().y + diagonal.getP2().y) / 2);
        Line perpResult[] = Line.perpendicular(diagonal, center, diagonal.distance() / 2);
        Point pointArr[] = new Point[4];

        pointArr[0] = diagonal.getP1();
        pointArr[1] = perpResult[0].getP2();
        pointArr[2] = diagonal.getP2();
        pointArr[3] = perpResult[1].getP2();
        
        Polygon result = new Polygon(4, style);
        result.setPoints(pointArr);
        return result;
    }
}
