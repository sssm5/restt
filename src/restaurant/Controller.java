package restaurant;

import food.Drink;
import food.MainDish;
import food.Product;
import food.Salad;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import output.Console;
import output.Terminal;
import output.Window;
import persons.Person;
import persons.Preferences;
import persons.Repository;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TextArea myTextArea;


    Restaurant rest;

    @FXML
    void initialize() {
        List<Product> list = new ArrayList();
        Terminal terminal = new Window(myTextArea);
        try {
            list.add(new Drink("cola", 600, 10, 2, 50, true));
            list.add(new Salad("afga", 1000, 28, 4, 20, false));
            list.add(new Salad("gfh", 500, 28, 4, 10, true));
            list.add(new MainDish("a", 600, 20, 1, 0, true));

            Person p = new Person().
                    setAge(10).
                    setName("Vasya").
                    setFreeTime(100).
                    setMoney(5000).
                    setPreferences(new Preferences(false, true,true, 10));

            rest = new Restaurant(list, terminal, 3);
        } catch (Exception e) {
            terminal.print(e.getMessage());
        }
    }

    @FXML
    void start(ActionEvent event) {
        rest.start();
    }
}


