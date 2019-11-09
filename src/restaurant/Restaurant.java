package restaurant;

import food.Product;
import output.Terminal;
import persons.Person;
import persons.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class Restaurant extends Thread {
    private List<Product> dishes;
    private List<Table> tables;
    private static Queue<Person> queue;
    private Person person;
    private Terminal terminal;

    public Restaurant(List<Product> dishes, Terminal terminal, int countOfTables) {
        this.dishes = dishes;
        this.terminal = terminal;
        this.tables = new ArrayList();
        this.queue = Repository.generatePersons();

        for ( int i = 0; i <countOfTables;i++){
            this.tables.add(new Table(this.queue.poll(), i, terminal));
        }
    }

    @Override
    public void run() {
        try {
            startWorking();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }

    public void addDish(Product product){
        dishes.add(product);
    }

    public synchronized void startWorking() throws InterruptedException {
        for (int i = 0; i < tables.size(); i++) {
            tables.get(i).serve(dishes);
            tables.get(i).join();
        }
        terminal.print("Ресторан закрыт!");
    }

    public synchronized static Person getPersonFromQueue(){
        return queue.poll();
    }

}
