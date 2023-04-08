package com.company;

public class Main {
    public static void main(String[] args) {
        FileCommanderCLI cli = new FileCommanderCLI(System.in, System.out);
        cli.eventLoop();
    }
}
