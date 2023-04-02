package com.company;

import java.nio.file.Path;
import java.util.Map;

public class FoodProductExposed extends FoodProduct{
    FoodProductExposed(FoodProduct foodProduct) {
        super(foodProduct.name, foodProduct.prices);
    }

    Map<String, Double[]> getPrices() {
        return prices;
    }
}
