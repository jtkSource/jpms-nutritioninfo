#!/usr/bin/env bash

rm -rf images/nutrition-cli

jlink -p nutrition-service/target/nutrition-service-1.0-SNAPSHOT.jar:\
string-validation-service/target/string-validation-service-1.0-SNAPSHOT.jar:\
number-validation-service/target/number-validation-service-1.0-SNAPSHOT.jar:\
nutrition-lib/target/nutrition-lib-1.0-SNAPSHOT.jar:\
nutrition-loader/target/nutrition-loader-1.0-SNAPSHOT.jar:\
nutrition-cli/target/nutrition-cli-1.0-SNAPSHOT.jar: \
--add-modules com.jtk.nutrition.cli --output images/nutrition-cli

images/nutrition-cli/bin/java \
-Dnutrition.file.path="/home/kuriakosej/git/jpms-nutritioninfo/nutrition-ui/src/main/resources/nutrition.yaml" \
-m com.jtk.nutrition.cli/com.jtk.nutrition.cli.Main