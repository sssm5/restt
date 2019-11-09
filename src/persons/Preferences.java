package persons;

public class Preferences {
    private boolean drinkAlcohol;
    private boolean eatMeat;
    private boolean eatSeaFood;

    public Preferences(boolean drinkAlcohol, boolean eatMeat, boolean eatSeaFood, int personAge) {
        this.drinkAlcohol = personAge >= 18 && drinkAlcohol;
        this.eatMeat = eatMeat;
        this.eatSeaFood = eatSeaFood;

    }

    public boolean isDrinkAlcohol() {
        return drinkAlcohol;
    }

    public boolean isEatMeat() {
        return eatMeat;
    }

    public boolean isEatSeaFood() {
        return eatSeaFood;
    }

    public void setEatMeat(boolean eatMeat) {
        this.eatMeat = eatMeat;
    }

    public void setEatSeaFood(boolean eatSeaFood) {
        this.eatSeaFood = eatSeaFood;
    }

    @Override
    public String toString() {
        String alc = drinkAlcohol ? "Пью." : "Не пью.";
        String meat = eatMeat ? " Ем мясо." : " Не ем мясо.";
        String sea = eatSeaFood ? " Ем морепродукты." : " Не ем морепродукты.";
        return alc + meat + sea;
    }
}
