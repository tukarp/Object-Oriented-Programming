package com.company.shapedecorator;

import com.company.Shape;

public class SolidFillShapeDecorator extends ShapeDecorator {
    private String color;

    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public String toSvg(String parameters) {
        return decoratedShape.toSvg(parameters + String.format("fill=\"%s\" ", color));
    }
}
