package com.jtk.nutrition.loader.internal

import spock.lang.Specification

class YamlNutritionLoaderSpec extends Specification {

    def "Coca-Cola should return nutrition details"(){
        given:
        String fileName = "C:\\Users\\jubin\\git\\nutritioninfo\\nutrition-ui\\src\\main\\resources\\nutrition.yaml"
        YamlNutritionLoader loader = new YamlNutritionLoader(fileName)
        when:
        Map<String,String> details =  loader.getNutritionDetails("Coca-Cola")
        then:
        details.get("Calories").equals("200")
        details.get("Sodium").equals("19mg")
    }

}
