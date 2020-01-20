package by.etc.introdaction.basicsoop.structure;

import by.etc.introdaction.basicsoop.sweets.Sweets;
import by.etc.introdaction.basicsoop.wrap.Wrap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gift {
    private String name;
    private double weight;
    private List<Sweets> listOfSweets = new ArrayList<>();
    private Date packingDate;
    private double price;
    private Wrap wrap;

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public List<Sweets> getListOfSweets() {
        return listOfSweets;
    }

    public String getPackingDate() {
        return packingDate.toString();
    }

    public void setPackingDate(Date packingDate) {
        this.packingDate = packingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double v) {
        this.price = v;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Wrap getWrap() {
        return wrap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWrap(Wrap wrap) {
        this.wrap = wrap;
    }

    public void setSweets(ArrayList<Sweets> listOfSweets) {
        this.listOfSweets = listOfSweets;
    }

    public void setGift(List<Sweets> fillProducts) {
        this.listOfSweets = fillProducts;
    }

    public void addSweets(Sweets sweets) {
        listOfSweets.add(sweets);
    }

    @Override
    public String toString() {
        String list = getGiftLine();
        return String.format("Gift name:  %s ; weight: %.2f; price: %.2f; type of wrap: %s;  packingDate: %tc; list of sweets:/n ", name,
                weight, price, wrap.getName(), packingDate) + list;
    }

    String getGiftLine() {
        if (listOfSweets.size() == 0) {
            return ".";
        }
        StringBuilder sb = new StringBuilder();
        for (Sweets product : listOfSweets) {
            sb.append(product.getName() + " price:" + product.getPrice()).append("\n");
        }
        return sb.toString();
    }
}
