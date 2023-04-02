package com.company;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FoodProductTest {
    @Test
    void fromCsvName() {
        FoodProduct product = FoodProduct.fromCsv(Path.of("test/resources/testfoodproduct.csv"));
        assertEquals("produkt testowy", product.getName());
    }

    @Test
    void fromCsvPrice() throws NoSuchFieldException, IllegalAccessException {
        FoodProduct product = FoodProduct.fromCsv(Path.of("test/resources/testfoodproduct.csv"));
        // dostęp do prywatnego pola - zła praktyka
        Field pricesField = FoodProduct.class.getDeclaredField("prices");
        pricesField.setAccessible(true);
        Map<String, Double[]> prices = (Map<String, Double[]>) pricesField.get(product);

        assertEquals(6.0, prices.get("yyy")[2]);
    }

    @Test
    void fromCsvPrice2() {
        FoodProduct product = FoodProduct.fromCsv(Path.of("test/resources/testfoodproduct.csv"));
        FoodProductExposed exposedProduct = new FoodProductExposed(product);

        assertEquals(6.0, exposedProduct.getPrices().get("yyy")[2]);
    }

    @Test
    void fromCsvPrice3() {
        FoodProduct product = FoodProduct.fromCsv(Path.of("test/resources/testfoodproduct.csv"));

        assertEquals(6.0, product.getPrice(2010, 3, "yyy"));
    }
}