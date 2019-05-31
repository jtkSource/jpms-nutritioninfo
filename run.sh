#! /bin/bash

java --version

java -p nutrition-service/target/nutrition-service-1.0-SNAPSHOT.jar:\
string-validation-service/target/string-validation-service-1.0-SNAPSHOT.jar:\
number-validation-service/target/number-validation-service-1.0-SNAPSHOT.jar:\
nutrition-lib/target/nutrition-lib-1.0-SNAPSHOT.jar:\
nutrition-loader/target/nutrition-loader-1.0-SNAPSHOT.jar:\
nutrition-ui/target/nutrition-ui-1.0-SNAPSHOT.jar:${JAVAFX_HOME}/lib \
-Dnutrition.file.path="/home/kuriakosej/git/jpms-nutritioninfo/nutrition-ui/src/main/resources/nutrition.yaml" \
-m com.jtk.nutrition.ui/com.jtk.nutrition.ui.Main