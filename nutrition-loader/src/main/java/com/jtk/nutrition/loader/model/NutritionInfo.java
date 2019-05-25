package com.jtk.nutrition.loader.model;

public class NutritionInfo {

    private String calories;
    private String fat;
    private String carbs;
    private String sodium;

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    @Override
    public String toString() {
        return "NutritionInfo{" +
                "calories='" + calories + '\'' +
                ", fat='" + fat + '\'' +
                ", carbs='" + carbs + '\'' +
                ", sodium='" + sodium + '\'' +
                '}';
    }
}
