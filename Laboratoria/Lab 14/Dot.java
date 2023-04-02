package com.example.circleapp;

public record Dot(int x, int y, String color, int radius) {
    public static Dot fromMessage(String data) {
        String arr[] = data.split(";");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        String color = arr[2];
        int radius = Integer.parseInt(arr[3]);
        return new Dot(x, y, color, radius);
    }

    public static String toMessage(int x, int y, String color, int radius) {
        return x+";"+y+";"+color+";"+radius;
    }

    public String toMessage() {
        return x+";"+y+";"+color+";"+radius;
    }
}
