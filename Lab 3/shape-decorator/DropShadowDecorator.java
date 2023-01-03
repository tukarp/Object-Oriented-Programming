package com.company.shapedecorator;

import com.company.Shape;
import com.company.SvgScene;

public class DropShadowDecorator extends ShapeDecorator {
    private static int index = 1;

    public DropShadowDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    private int addRequiredDefToScene() {
        SvgScene scene = SvgScene.getInstance();
        scene.addDef(String.format("\t<filter id=\"f%d\" x=\"-100%%\" y=\"-100%%\" width=\"300%%\" height=\"300%%\">\n" +
                "\t\t<feOffset result=\"offOut\" in=\"SourceAlpha\" dx=\"5\" dy=\"5\" />\n" +
                "\t\t<feGaussianBlur result=\"blurOut\" in=\"offOut\" stdDeviation=\"5\" />\n" +
                "\t\t<feBlend in=\"SourceGraphic\" in2=\"blurOut\" mode=\"normal\" />\n" +
                "\t</filter>", index));
        return index++;
    }

    @Override
    public String toSvg(String parameters) {
        int index = addRequiredDefToScene();
        return decoratedShape.toSvg(parameters + String.format("filter=\"url(#f%d)\" ", index));
    }
}
