package com.company;

public class Style {
    public final String fillColor, strokeColor;
    public final Double strokeWidth;

    public Style(String fillColor, String strokeColor, Double strokeWidth) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public String toSvg() {
        String styleString = "";
        if(fillColor != null)
            styleString += "fill:"+fillColor+";";
        else
            styleString += "fill:transparent;";
        if(strokeColor != null)
            styleString += "stroke:"+strokeColor+";";
        else
            styleString += "stroke:black;";
        if(strokeWidth != null)
            styleString += "stroke-width:"+strokeWidth+";";
        return styleString;
    }
}
