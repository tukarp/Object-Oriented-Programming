package com.company;

public class Main {

    public static void main(String[] args) {
        Line line = new Line(new Point(10,100), new Point(110,99));
        Line perp2[] = Line.perpendicular(line, line.getP1());

        System.out.println(line.toSvg());
        for(int i=0;i<perp2.length;i++)
            System.out.println(perp2[i].toSvg());
        System.out.println(line.distance());

        Polygon poly = new Polygon(4, new Style("red", "black", null));
        poly.setPoints(new Point[]{new Point(120,30), new Point(170,180), new Point(240,320), new Point(110,30)});
        System.out.println(poly.toSvg());

        Polygon poly2 = new Polygon(3, new Style("black", "red", 1.0));
        poly2.setPoints(new Point[]{new Point(10,10), new Point(100,100), new Point(10,100)});
        System.out.println(poly2.toSvg());

        SvgScene scene=new SvgScene();
        scene.addShape(poly);
        scene.addShape(poly2);
        scene.addShape(Polygon.square(new Line(new Point(100,150), new Point(200,200)), new Style("green", "blue", 2.0)));
        Ellipse ellipse= new Ellipse(new Point(150, 300),100,50, new Style(null,"yellow",2.0));
        scene.addShape(ellipse);

        scene.saveHtml("scene.html");
    }
}

