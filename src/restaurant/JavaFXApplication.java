package restaurant;

import food.Drink;
import food.MainDish;
import food.Product;
import food.Salad;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import output.Console;
import persons.Repository;

import java.util.ArrayList;
import java.util.List;

public class JavaFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("restaurant.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 850));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
