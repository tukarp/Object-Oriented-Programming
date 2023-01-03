package com.company.shapedecorator;

import com.company.Shape;
import com.company.Vec2;

import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator {
    private boolean translate;
    private Vec2 translateVector;

    private boolean rotate;
    private double rotateAngle;
    private Vec2 rotateCenter;

    private boolean scale;
    private Vec2 scaleVector;

    public static class Builder {
        private boolean translate = false;
        private Vec2 translateVector;

        private boolean rotate = false;
        private double rotateAngle;
        private Vec2 rotateCenter;

        private boolean scale = false;
        private Vec2 scaleVector;

        private Shape shape;

        public Builder setTranslate(Vec2 translateVector) {
            translate = true;
            this.translateVector = translateVector;
            return this;
        }

        public Builder setRotate(double rotateAngle, Vec2 rotateCenter) {
            rotate = true;
            this.rotateAngle = rotateAngle;
            this.rotateCenter = rotateCenter;
            return this;
        }

        public Builder setScale(Vec2 translateVector) {
            scale = true;
            this.scaleVector = translateVector;
            return this;
        }

        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }

        public TransformationDecorator build() {
            TransformationDecorator result = new TransformationDecorator(shape);
            if(translate) {
                result.translate = true;
                result.translateVector = this.translateVector;
            }
            if(rotate) {
                result.rotate = true;
                result.rotateAngle = this.rotateAngle;
                result.rotateCenter = this.rotateCenter;
            }
            if(scale) {
                result.scale = true;
                result.scaleVector = this.scaleVector;
            }
            return result;
        }
    }

    private TransformationDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    public String toSvg(String parameters) {
        String result="";
        if(translate)
            result += String.format(Locale.ENGLISH, "translate(%f %f) ", translateVector.x, translateVector.y);
        if(rotate)
            result += String.format(Locale.ENGLISH, "rotate(%f %f %f) ", rotateAngle, rotateCenter.x, rotateCenter.y);
        if(scale)
            result += String.format(Locale.ENGLISH, "scale(%f %f) ", scaleVector.x, scaleVector.y);
        return  decoratedShape.toSvg(String.format("transform=\"%s\" %s", result, parameters));
    }
}
