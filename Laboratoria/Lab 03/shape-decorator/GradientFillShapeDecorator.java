package com.company.shapedecorator;

import com.company.Shape;
import com.company.SvgScene;

import java.util.Arrays;
import java.util.Locale;

public class GradientFillShapeDecorator extends ShapeDecorator {
    private static int index = 1;
    private record Stop(double offset, String color) {}

    private Stop stops[];

    public static class Builder {
        private Stop stops[] = new Stop[0];
        private Shape shape;

        public GradientFillShapeDecorator.Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }

        public GradientFillShapeDecorator.Builder addStop(double offset, String color) {
            stops = Arrays.copyOf(stops, stops.length + 1);
            stops[stops.length - 1] = new Stop(offset, color);
            return this;
        }

        public GradientFillShapeDecorator build() {
            GradientFillShapeDecorator result = new GradientFillShapeDecorator(shape);
            result.stops = this.stops;
            return result;
        }
    }

    private GradientFillShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    private int addRequiredDefToScene() {
        SvgScene scene = SvgScene.getInstance();
        String result = String.format(Locale.ENGLISH,"\t<linearGradient id=\"g%d\" >\n", index);
        for(var stop : stops)
            result += String.format(Locale.ENGLISH, "\t\t<stop offset=\"%f\" style=\"stop-color:%s\" />\n", stop.offset, stop.color);
        result += "\t</linearGradient>";
        scene.addDef(result);
        return index++;
    }

    @Override
    public String toSvg(String parameters) {
        int index = addRequiredDefToScene();
        return decoratedShape.toSvg(parameters + String.format("fill=\"url(#g%d)\" ", index));
    }
}
