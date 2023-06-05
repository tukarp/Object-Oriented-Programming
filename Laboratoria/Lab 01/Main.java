package com.company;

public class Main {
    public static void main(String[] args) {
        Line line = new Line(new Point(10,100), new Point(110, 99));
        Line perp2[] = Line.perpendicular(line, line.getP1());

        System.out.println(line.toSvg());
        for(int i = 0; i < perp2.length; i++)
            System.out.println(perp2[i].toSvg());
        System.out.println(line.distance());

        Polygon poly = new Polygon(4);
        poly.setPoints(new Point[]{new Point(120, 30), new Point(170, 180), new Point(240, 320), new Point(110, 30)});

        System.out.println(poly.toSvg());
    }
}
