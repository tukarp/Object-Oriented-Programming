package com.company;

import java.util.Locale;

public class Line {
    private final Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double distance() {
        return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }

    public static Line[] perpendicular(Line line, Point point) {
        double a;
        a = (line.p1.y - line.p2.y) / (line.p1.x - line.p2.x);
        double b;
        a=-1/a;
        b=point.y-a*point.x;

        double x0 = point.x;
        double y0 = point.y;
        double r = line.distance();

        double root = Math.sqrt(-y0*y0+(2*a*x0+2*b)*y0-a*a*x0*x0-2*a*b*x0+(a*a+1)*r*r-b*b);
        double x1 = -(root-a*y0-x0+a*b)/(a*a+1);
        double y1 = -(a*root-a*a*y0-a*x0-b)/(a*a+1);
        double x2 = (root+a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*root+a*a*y0+a*x0+b)/(a*a+1);

        return new Line[]{new Line(point, new Point(x1,y1)), new Line(point, new Point(x2,y2))};
    }

    public static Line[] perpendicular(Line line, Point point, double r) {
        double a;
        a = (line.p1.y - line.p2.y) / (line.p1.x - line.p2.x);
        double b;
        a=-1/a;
        b=point.y-a*point.x;

        double x0 = point.x;
        double y0 = point.y;


        double root = Math.sqrt(-y0*y0+(2*a*x0+2*b)*y0-a*a*x0*x0-2*a*b*x0+(a*a+1)*r*r-b*b);
        double x1 = -(root-a*y0-x0+a*b)/(a*a+1);
        double y1 = -(a*root-a*a*y0-a*x0-b)/(a*a+1);
        double x2 = (root+a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*root+a*a*y0+a*x0+b)/(a*a+1);

        return new Line[]{new Line(point, new Point(x1,y1)), new Line(point, new Point(x2,y2))};
    }

    public String toSvg() {
        return String.format(Locale.ENGLISH,"<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:black\" />", p1.x, p1.y, p2.x, p2.y);
    }
}
