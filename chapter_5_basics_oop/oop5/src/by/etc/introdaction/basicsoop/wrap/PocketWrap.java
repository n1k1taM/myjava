package by.etc.introdaction.basicsoop.wrap;

public class PocketWrap extends Wrap {
    public PocketWrap(double price,String name) {
        super(price,name);
    }
    public PocketWrap(){
        setName("Подарочный пакет");
        setPrice(1.0);
    }
}
