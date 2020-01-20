package by.etc.introdaction.basicsoop.sweets;

public class Caramel extends Sweets {

    public Caramel(String name, int weight, double price) {
        super(name, weight, price);
    }

    public Caramel(){
        this.setName("Карамель");
        this.setWeight(10);
        this.setPrice(0.2);
    }

}
