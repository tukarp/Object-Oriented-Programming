package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SvgScene {
    private static SvgScene instance = null;

    private Shape shapes[] = new Shape[0];
    private String defs[] = new String[0];
    private int width = 0, height = 0;

    public void addShape(Shape shape) {
        shapes = Arrays.copyOf(shapes, shapes.length + 1);
        shapes[shapes.length - 1] = shape;
    }

    public void addDef(String def) {
        defs = Arrays.copyOf(defs, defs.length + 1);
        defs[defs.length - 1] = def;
    }

    public void saveHtml(String path) {
        try {
            FileWriter file = new FileWriter(path);
            file.write("<html>\n<body>\n");
            file.write(String.format("<svg width=\"%d\" height=\"%d\">\n",1000, 1000));

            for(Shape shape : shapes)
                file.write("\t"+ shape.toSvg("") +"\n" );
            if(defs.length>=0) {
                file.write("<defs>\n");
                for (var def : defs)
                    file.write(def + "\n");
                file.write("</defs>\n");
            }

            file.write("</svg>\n</body>\n</html>\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SvgScene getInstance() {
        if(instance == null)
            instance = new SvgScene();
        return instance;
    }

    private SvgScene() {}
}
