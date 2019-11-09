package persons;

import food.Drink;
import food.MainDish;
import food.Product;
import food.Salad;

import java.util.List;
import java.util.Random;

public class Person {
    private String name;
    private int age;
    private int freeTime;
    private int money;
    private Preferences preferences;
    private int attempt;

    public Person(String name, int age, int freeTime, int money, Preferences preferences) {
        this.name = name;
        this.age = age;
        this.freeTime = freeTime;
        this.money = money;
        this.preferences = preferences;
        this.attempt = 0;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public Person setFreeTime(int freeTime) {
        this.freeTime = freeTime;
        return this;
    }

    public int getMoney() {
        return money;
    }

    public Person setMoney(int money) {
        this.money = money;
        return this;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public Person setPreferences(Preferences preferences) {
        this.preferences = preferences;
        return this;
    }

    public int getAttempt() {
        return attempt;
    }

    public Product chooseDish(List<Product> list) {
        Random random = new Random();

        attempt++;

        return list.get(random.nextInt(list.size()));
    }

    public boolean checkPreferences(Product product) {
        if (product.getClass() == Salad.class) {
            if (!this.preferences.isEatSeaFood() && ((Salad) product).isSeaFood()) {
                return false;
            }
        }
        if (product.getClass() == Drink.class) {
            if (!this.preferences.isDrinkAlcohol() && ((Drink) product).isAlcohol()) {
                return false;
            }
        }
        if (product.getClass() == MainDish.class) {
            if (!this.preferences.isEatMeat() && ((MainDish) product).isMeat()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkTime(int productTime){
        if (this.freeTime< productTime){
            return false;
        }
        return true;
    }
    public boolean checkMoney(int price){
        if (this.money < price){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Человек:" + "\n" +
                "   Имя: " + name + "\n" +
                "   Возраст: " + age + "\n" +
                "   Свободное время: " + freeTime + "\n" +
                "   Деньги: " + money + "\n" +
                "   Предпочтения: " + preferences + "\n" +
                "   Попытка: " + attempt + "\n" +
                "__________________________________________" + "\n";
    }
}

