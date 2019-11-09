public class Temp {
    public static void main(String[] args) {


        System.out.println(85/100);

    }
}

class Mnogopotok extends Thread {

    String name;

    public Mnogopotok(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10000; i++) {
            System.out.println(name+ ": " + i);
        }
    }
}
