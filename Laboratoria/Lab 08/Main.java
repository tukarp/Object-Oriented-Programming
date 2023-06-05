package com.company;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Zadanie 1
//        DeathCauseStatistic statistic=DeathCauseStatistic.fromCsvLine("A02.1, 5, -, -, -, -, -, -, -, -, -, -, -, -, 1, 2, -, 1, 1, -, -, -");
//        System.out.println(statistic.getKey());
//        int[] arr = statistic.getAgeBracket();
//        for(var a : arr) {
//            System.out.println(a);
//        }
//
//        System.out.println(statistic.getDeaths(60));

        // Zadanie 3a
        DeathCauseStatisticsList statisticsList = new DeathCauseStatisticsList();
        statisticsList.repopulate("zgony.csv");

        List<DeathCauseStatistic> mostDeadly= statisticsList.mostDeadlyDiseases(1, 100);

        // Zadanie 4
        //DeathCauseStatisticsList deaths = new DeathCauseStatisticsList();
        //deaths.repopulate("zgony.csv");

        ICDCodeTabular codes = new ICDCodeTabularOptimizedForMemory("icd10.txt");

        for(var diseases : mostDeadly) {
            System.out.print(diseases.getKey());
            System.out.print(" - ");
            try {
                System.out.println(codes.getDescription(diseases.getKey()));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("???");
            }
        }
    }
}
