package output;

public class Console extends Terminal {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
