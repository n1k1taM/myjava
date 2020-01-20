package by.etc.introdaction.basicsoop.action;

import by.etc.introdaction.basicsoop.structure.Gift;
import by.etc.introdaction.basicsoop.sweets.Sweets;

import java.util.Date;

public class GiftCreator {
    Gift gift;
    SimpleWrapFactory wrapFactory;
    SimpleSweetFactory sweetFactory;

    public GiftCreator() {
        this.wrapFactory = new SimpleWrapFactory();
        this.sweetFactory = new SimpleSweetFactory();
        gift = new Gift();
    }

    public Gift createGift(double price, String wrapType, String nameOfGift) {

        // убрать параметры в методе и определить их в самом методе, вызывая
        //необходимые методы CustomerAction
        gift.setWrap(wrapFactory.createWrap(wrapType));
        double summ = 0;
        Sweets sweets;
        while (summ < price) {
            int random = (int) (Math.random() * 5) + 1;
            if (random == 1) {
                sweets = sweetFactory.createSweet("Caramel");
                summ = summ + sweets.getPrice();
                gift.addSweets(sweets);
            } else if (random == 2) {
                sweets = sweetFactory.createSweet("Chocolate");
                summ = summ + sweets.getPrice();
                gift.addSweets(sweets);
            } else if (random == 3) {
                sweets = sweetFactory.createSweet("Cookie");
                summ = summ + sweets.getPrice();
                gift.addSweets(sweets);
            } else if (random == 4) {
                sweets = sweetFactory.createSweet("ChokolateBar");
                summ = summ + sweets.getPrice();
                gift.addSweets(sweets);
            }
        }
        setDate();
        setWeight();
        setPrice();
        setName(nameOfGift);

        return gift;
    }

    public void setDate(){
        Date date=new Date();
        gift.setPackingDate(date);
    }
    public void setWeight(){
        double massa=0;
        for(int i=0;i<gift.getListOfSweets().size();i++){
            massa=massa+gift.getListOfSweets().get(i).getWeight();
        }
        gift.setWeight(massa);
    }

    public void setPrice(){
        double cost=0;
        for(int i=0;i<gift.getListOfSweets().size();i++){
            cost=cost+gift.getListOfSweets().get(i).getPrice();
        }
        gift.setPrice(cost);
    }

    public void setName(String nameOfGift){
        gift.setName(nameOfGift);
    }

    public void createWrap(){

    }
}
