package com.company;

import java.util.Locale;

public class Ellipse extends Shape{
    Point center;
    double rx,ry;

    public Ellipse(Point center, double rx, double ry,Style style) {
        super(style);
        this.rx=rx;
        this.ry=ry;
        this.center=center;

    }
    public Point rightBottom() {
        return new Point(center.x+rx+ style.strokeWidth,center.y+ry+ style.strokeWidth);
    }

    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH,"<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" style=\"%s\"/>", center.x,center.y,rx,ry, style.toSvg());
    }
}
