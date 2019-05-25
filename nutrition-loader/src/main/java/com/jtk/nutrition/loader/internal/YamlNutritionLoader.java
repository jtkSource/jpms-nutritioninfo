package com.jtk.nutrition.loader.internal;

import java.io.IOException;
import java.util.Map;

import com.jtk.nutrition.loader.util.NutritionLoader;
import com.jtk.nutrition.loader.util.NutritionLoaderException;

public class YamlNutritionLoader {

    private final YAMLReader reader;

    public YamlNutritionLoader(String fileName) throws NutritionLoaderException {
        reader = new YAMLReader();
        loadNutritionDetails(fileName);
    }
    private void loadNutritionDetails(String fileName) throws NutritionLoaderException {
        try {
            reader.loadYAMLDictionary(fileName);
        } catch (IOException e) {
            throw new NutritionLoaderException("Error loading Nutrition Details");
        }
    }

    public Map<String, String> getNutritionDetails(String product) {
        return reader.getNutritionDetails(product);
    }
}