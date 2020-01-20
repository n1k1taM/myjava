package by.etc.introdaction.basicsoop.sweets;

public class ChocolateBar extends Sweets {

    public ChocolateBar(String name, int weight, double price) {
        super(name, weight, price);
    }
    public ChocolateBar(){
        this.setName("Шоколадка");
        this.setWeight(100);
        this.setPrice(3.0);
    }
}
