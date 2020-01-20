package by.etc.introdaction.basicsoop.sweets;

public class Chocolate extends Sweets {

    public Chocolate(String name, int weight, double price) {
        super(name, weight, price);
    }

    public Chocolate(){
        this.setName("Шоколадная конфета");
        this.setWeight(10);
        this.setPrice(0.5);
    }
}
