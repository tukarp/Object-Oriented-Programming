package com.company.shapedecorator;

import com.company.Shape;

public class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public String toSvg(String parameters) {
        return decoratedShape.toSvg(parameters);
    }
}
