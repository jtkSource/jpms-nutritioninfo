package com.jtk.nutrition.loader.model;

public class FoodProduct implements Comparable {

    private String id;
    private String name;
    private NutritionInfo nutritionInfo;

    public FoodProduct(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nutritionInfo
     */
    public NutritionInfo getNutritionInfo() {
        return nutritionInfo;
    }

    /**
     * @param nutritionInfo the nutritionInfo to set
     */
    public void setNutritionInfo(NutritionInfo nutritionInfo) {
        this.nutritionInfo = nutritionInfo;
    }

    public int compareTo(Object other) {
        FoodProduct otherFood = (FoodProduct) other;
        return this.name.compareTo(otherFood.name);
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nutritionInfo=" + nutritionInfo +
                '}';
    }
}
