package food;

public class Salad extends Product{
    private boolean seaFood;

    public Salad(String name, int price, int time, int count, boolean seaFood) {
        super(name, price, time, count);
        this.seaFood = seaFood;
    }

    public Salad(String name, int price, int time, int count, int sale, boolean seaFood) throws Exception {
        super(name, price, time, count, sale);
        this.seaFood = seaFood;
    }


    public boolean isSeaFood() {
        return seaFood;
    }

    public void setSeaFood(boolean seaFood) {
        this.seaFood = seaFood;
    }
    @Override
    public String toString() {
        String sea = seaFood ? " С морепродуктами." : " Без морепродуктов.";
        return super.toString() + "   Это салат." + sea+ "\n_________________________";
    }
}
