package by.etc.introdaction.basicsoop.wrap;

public abstract class Wrap {
    private double price;
    private String name;

    public Wrap(double price,String name) {
        this.price = price;
        this.name=name;
    }

    public Wrap() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
