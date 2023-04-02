package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SvgScene {
    private Shape shapes[] = new Shape[0];
    private int width = 0, height = 0;

    public void addShape(final Shape poly) {
        shapes = Arrays.copyOf(shapes, shapes.length + 1);
        shapes[shapes.length - 1] = poly;

        Point rightBottom = poly.rightBottom();
        width = (int) Math.max(width, rightBottom.x);
        height = (int) Math.max(height, rightBottom.y);
    }

    public void saveHtml(String path) {
        try {
            FileWriter file = new FileWriter(path);
            file.write("<html>\n<body>\n");
            file.write(String.format("<svg width=\"%d\" height=\"%d\">",width, height));
            for(Shape shape : shapes)
                file.write("\t"+ shape.toSvg());
            file.write("</svg>\n</body>\n</html>\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

