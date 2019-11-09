package food;

public class MainDish extends Product {
    private boolean meat;

    public MainDish(String name, int price, int time, int count, boolean meat) {
        super(name, price, time, count);
        this.meat = meat;
    }

    public MainDish(String name, int price, int time, int count, int sale, boolean meat) throws Exception {
        super(name, price, time, count, sale);
        this.meat = meat;
    }


    public boolean isMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }
    @Override
    public String toString() {
        String withMeat = this.meat ? " Мясо." : " Не мясо.";
        return super.toString() + "   Это основное блюдо." + withMeat + "\n_________________________";
    }
}
