package by.etc.introdaction.basicsoop.wrap;

public class CardboardWrap extends Wrap {
    public CardboardWrap(double price, String name) {
        super(price,name);
    }
    public CardboardWrap(){
        setName("Картонная упаковка");
        setPrice(1.5);
    }

}
