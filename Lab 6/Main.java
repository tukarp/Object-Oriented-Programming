package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        FileCommander commander = new FileCommander();
//        System.out.println(commander.pwd());
//        commander.cd("/tmp");
//        System.out.println(commander.pwd());
//
//        List<String> files =commander.ls();
//        for(var f : files)
//            System.out.println(f);
//
//
//        List<String> files =commander.find(".cpp");
//        for(var f : files)
//            System.out.println(f);

        FileCommanderCLI cli = new FileCommanderCLI(System.in, System.out);
        cli.eventLoop();
    }
}
