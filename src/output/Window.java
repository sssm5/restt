package output;


import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Window extends Terminal {

    TextArea textArea;

    public Window(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void print(String text) {
        textArea.setText(textArea.getText() + text);
    }
}
