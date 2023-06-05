package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Arrays;

public class NonFoodProduct extends Product {
    Double[] prices;

    private NonFoodProduct(String name, Double[] prices) {
        super(name);
        this.prices = prices;
    }

    public static NonFoodProduct fromCsv(Path path) {
        String name;
        Double[] prices;
        try {
            Scanner scanner = new Scanner(path);
            name = scanner.nextLine();

            scanner.nextLine();
            prices = Arrays.stream(scanner.nextLine().split(";"))
                    .map(value -> value.replace(",", "."))
                    .map(Double::valueOf)
                    .toArray(Double[]::new);
            scanner.close();
            
            return new NonFoodProduct(name, prices);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double getPrice(int year, int month) {
        int index = priceIndex(year, month);
        return prices[index];
    }
}
