package food;

public abstract class Product {
    private int price;
    private int time;
    private int sale;
    private int count;
    private String name;



    public Product(String name, int price, int time, int count) {
        this.name = name;
        this.price = price;
        this.time = time;
        this.sale = 0;
        this.count = count;
    }

    public Product(String name, int price, int time, int count, int sale) throws Exception {
        this.name = name;
        this.price = price;
        this.time = time;
        this.sale = 0;
        this.count = count;
        this.setSale(sale);
    }

    public int getPrice() {
        return this.sale == 0 ? price : (price * (100 - this.sale)) / 100;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) throws Exception {
        if (sale < 100) {
            this.sale = sale;
        } else {
            this.sale = 0;
            throw new Exception("Скидка не может быть больше 100%! Установлено значение 0.");
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Блюдо:" + "\n" +
                "   Название: " + name + "\n" +
                "   Цена без скидки: " + price + "\n" +
                "   Цена со скидкой: " + getPrice() + "\n" +
                "   Время приготовления: " + time + "\n" +
                "   Остаток на складе: " + count + "\n" +
                "   Скидка: " + sale + "\n" ;
    }
}
