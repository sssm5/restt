package restaurant;

import food.Product;
import output.Terminal;
import output.Window;
import persons.Person;
import persons.Repository;

import java.util.List;

public class Table extends Thread {


    private Person person;
    private TableStatus status;
    public Terminal terminal;
    public int number;

    private String prefix;

    public Table(Person person, int number, Terminal terminal){
        this.person = person;
        this.status = TableStatus.IN_SERVICE;
        this.terminal = terminal;
        this.number = number;

        this.prefix = "[TABLE " + this.number +"] ";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public void serve(List<Product> menu){
        checkDishForCountNotZero(menu);
        Product product = person.chooseDish(menu);//.stream().filter(el -> el.getCount() > 1).collect(Collectors.toList()));
        boolean checkPreferences = person.checkPreferences(product);
        boolean checkTime = person.checkTime(product.getTime());
        boolean checkMoney = person.checkMoney(product.getPrice());
        boolean eating = checkPreferences && checkTime && checkMoney;
        try {
            terminal.print(person.toString());
            terminal.print(product.toString());
            if (eating) {
                terminal.print(prefix + "Я сажусь есть. Мне есть " + product.getTime() + " секунд.");
                Thread.sleep(product.getTime());
                product.setCount(product.getCount() - 1);
                terminal.print(prefix + "Я ухожу,потому что съел блюдо!");
                person = Restaurant.getPersonFromQueue();
                if(person == null) {
                    terminal.print(prefix + "Очередь в ресторане кончилась. Скоро закрываемся");
                    return;
                }
            } else {
                if (!checkTime) {
                    terminal.print(prefix + "Я не буду это заказывать, потому что готовят медленно.");
                } else if(!checkPreferences) {
                    terminal.print(prefix + "Я не буду это заказывать, потому что мне не подходит");
                } else {
                    terminal.print(prefix + "Я не буду это заказывать, потому что мне не хватает средств");
                }
                if (person.getAttempt() == 3) {
                    terminal.print(prefix + "Я ухожу, потому что 3 попытки закончились!");
                    person = Restaurant.getPersonFromQueue();
                    if(person == null) {
                        terminal.print(prefix + "Очередь в ресторане кончилась. Скоро закрываемся");
                        return;
                    }
                } else{

                    terminal.print(prefix + "Я не съел блюдо (попытка № " + person.getAttempt() + ")");
                }

            }
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            serve(menu);

        } catch (Exception e) {
            terminal.print(e.getMessage());
        }

    }
    private void checkDishForCountNotZero(List<Product> dishes) {
        for(int i = 0; i < dishes.size(); i++){
            if(dishes.get(i).getCount() == 0) {
                dishes.remove(i);
            }
        }
//        dishes.removeIf(product -> product.getCount() == 0);

    }
    private void leavePerson(){
        this.status = TableStatus.FREE;
    }

    private void setNewPersonAndGiveMenu(Person person, List<Product> menu){
        this.person = person;
        this.status = TableStatus.IN_SERVICE;
        serve(menu);
    }
}
