package by.etc.introdaction.basicsoop.sweets;

public class Cookie extends Sweets {

    public Cookie(String name, int weight, double price) {
        super(name, weight, price);
    }
    public Cookie(){
        this.setName("Упаковка печенья");
        this.setWeight(100);
        this.setPrice(1.5);
    }
}