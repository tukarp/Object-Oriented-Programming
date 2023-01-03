package com.company;

import com.company.shapedecorator.*;

public class Main {
    public static void main(String[] args) {
        Polygon poly = new Polygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)});
        //SvgScene scene=new SvgScene();
        SvgScene scene = SvgScene.getInstance();

        //Shape shape = new FlatFillShapeDecorator(poly, "red");
        Shape shape = new GradientFillShapeDecorator.Builder()
                .setShape(poly)
                .addStop(0, "red")
                .addStop(0.3, "white")
                .addStop(1, "cyan")
                .build();

        shape = new StrokeShapeDecorator(shape, "blue", 5);

        shape = new TransformationDecorator.Builder()
                .setShape(shape)
                .setRotate(-30, new Vec2(20,30))
                //.setScale(new Point(2, 3))
                .build();

        shape = new DropShadowDecorator(shape);

        Shape shape2 = new Ellipse(new Vec2(250, 150),100,50);
        shape2 = new SolidFillShapeDecorator(shape2, "red");
        shape2 = new DropShadowDecorator(shape2);

        scene.addShape(shape2);
        scene.addShape(shape);

        scene.saveHtml("scene.html");
    }
}
