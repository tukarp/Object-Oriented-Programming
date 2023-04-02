package com.company.shapedecorator;

import com.company.Shape;

import java.util.Locale;

public class StrokeShapeDecorator extends ShapeDecorator {
    private String color;
    private double width;

    public StrokeShapeDecorator(Shape decoratedShape, String color, double width) {
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }

    @Override
    public String toSvg(String parameters) {
        return decoratedShape.toSvg(parameters + String.format(Locale.ENGLISH, "stroke=\"%s\" stroke-width=\"%f\" ", color,width));
    }
}
