package food;

public class Drink extends Product {
    private boolean alcohol;

    public Drink(String name, int price, int time, int count, boolean alcohol) {
        super(name, price, time, count);
        this.alcohol = alcohol;
    }

    public Drink(String name, int price, int time, int count, int sale, boolean alcohol) throws Exception {
        super(name, price, time, count, sale);
        this.alcohol = alcohol;
    }


    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        String alc = alcohol ? " Алкогольный." : " Безалкогольный.";
        return super.toString() + "   Это напиток." + alc + "\n_________________________";
    }
}
