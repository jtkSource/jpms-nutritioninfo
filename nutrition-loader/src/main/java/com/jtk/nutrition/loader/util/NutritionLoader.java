package com.jtk.nutrition.loader.util;

import com.jtk.nutrition.loader.internal.YamlNutritionLoader;
import com.jtk.nutrition.loader.model.FoodProduct;
import com.jtk.nutrition.loader.model.NutritionInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NutritionLoader {

    private YamlNutritionLoader loader;

    public NutritionLoader(String fileName) throws NutritionLoaderException {
        loader = new YamlNutritionLoader(fileName);
    }

    public Map<String, String> getNutritionDetails(String product){
        return loader.getNutritionDetails(product);
    }

    public List<FoodProduct> getAllFoodProductDetails(){
        List<FoodProduct> foodDetails = new ArrayList<>();
        Arrays.asList("Margarita-Pizza", "Coca-Cola", "French-Fries", "Chicken-Biriyani", "Porotta")
                .stream()
                .forEach(s -> {
                    FoodProduct foodProduct = new FoodProduct(UUID.randomUUID().toString(),s);
                    NutritionInfo info = new NutritionInfo();
                    info.setCalories(getNutritionDetails(s).get("Calories"));
                    info.setCarbs(getNutritionDetails(s).get("Carbs"));
                    info.setFat(getNutritionDetails(s).get("Fat"));
                    info.setSodium(getNutritionDetails(s).get("Sodium"));
                    foodProduct.setNutritionInfo(info);
                    foodDetails.add(foodProduct);
        } );
        return foodDetails;
    }
}