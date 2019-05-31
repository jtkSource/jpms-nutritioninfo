package com.jtk.nutrition.cli;

import com.jtk.nutrition.loader.model.FoodProduct;
import com.jtk.nutrition.loader.util.NutritionLoader;
import com.jtk.nutrition.loader.util.NutritionLoaderException;
import com.jtk.service.api.ValidationService;

import java.lang.module.ModuleFinder;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws NutritionLoaderException {
        logger.info("Nutrition viewer: Started");
        String fileName = System.getProperty("nutrition.file.path");
        logger.info("file name "   + fileName);
        NutritionLoader loader = new NutritionLoader(fileName);
        List<FoodProduct> productDetails = loader.getAllFoodProductDetails();
        logger.info(productDetails.toString());
        logger.info("Address book viewer application: Completed");

        productDetails.forEach(foodProduct ->
                ValidationService.getValidators(foodProduct.getName()).forEach(validationService ->
                        logger.info("Valid Name: " + validationService.validate(foodProduct.getName()))
                )
        );


    }
}
