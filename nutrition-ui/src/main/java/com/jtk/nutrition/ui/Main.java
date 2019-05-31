package com.jtk.nutrition.ui;

import com.jtk.nutrition.loader.model.FoodProduct;
import com.jtk.nutrition.loader.util.NutritionLoader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main extends Application {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        String fileName = System.getProperty("nutrition.file.path");
        logger.info("file name "   + fileName);
        NutritionLoader loader = new NutritionLoader(fileName);

        List<FoodProduct> foodProducts = loader.getAllFoodProductDetails();
        primaryStage.setTitle("Food Viewer");
        BorderPane root = new BorderPane();
        HBox hbox = generateTitleHBox();
        root.setTop(hbox);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        Label name = new Label();
        name.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        GridPane.setHalignment(name, HPos.RIGHT);
        grid.add(name, 0, 1);

        Label calories = new Label();
        calories.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        GridPane.setHalignment(calories, HPos.RIGHT);
        grid.add(calories, 0, 2);

        Label fat = new Label();
        fat.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        GridPane.setHalignment(fat, HPos.RIGHT);
        grid.add(fat, 0, 3);

        Label carbs = new Label();
        GridPane.setHalignment(carbs, HPos.RIGHT);
        grid.add(carbs, 0, 4);

        Label sodium = new Label();
        GridPane.setHalignment(sodium, HPos.RIGHT);
        grid.add(sodium, 0, 5);

        final List<FoodProduct> foodProductList = foodProducts;
        // Create a new JavaFX ListView
        ListView<String> list = new ListView<String>();
        // Collect a String list of Contact names in lastName, firstName format
        List<String> listContactNames = foodProducts.stream().map(c -> c.getName())
                .collect(Collectors.toList());

        // Build an ObservableList from the list of names
        ObservableList<String> obsContactNames = FXCollections.observableList(listContactNames);
        // Pass that to ListView to have them displayed in a list
        list.setItems(obsContactNames);
        // Add listener to handle click events
        list.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            // Get the selected index in the ListView
            int selectedIndex = list.getSelectionModel().getSelectedIndex();
            name.setText(newVal);
            // Get the Contact instance which was clicked
            FoodProduct foodProduct = foodProductList.get(selectedIndex);
            // Set the values to the labels on the right
            calories.setText("Calories: " + foodProduct.getNutritionInfo().getCalories());
            fat.setText("Fat:" + foodProduct.getNutritionInfo().getFat());
            carbs.setText("Carbohydrates:" + foodProduct.getNutritionInfo().getCarbs());
            sodium.setText("Sodium:" + foodProduct.getNutritionInfo().getSodium());
        });

        list.setPrefWidth(300);
        list.setPrefHeight(650);
        root.setLeft(list);
        root.setRight(grid);

        primaryStage.setScene(new Scene(root, 700, 550));
        primaryStage.show();
    }

    public HBox generateTitleHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #89993e;");

        Label appTitle = new Label("Nutrition Reader");
        appTitle.setTextFill(Color.web("#FFFFFF"));
        appTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        hbox.getChildren().add(appTitle);

        return hbox;
    }

}