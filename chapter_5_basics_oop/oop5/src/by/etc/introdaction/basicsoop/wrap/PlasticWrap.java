package by.etc.introdaction.basicsoop.wrap;

public class PlasticWrap extends Wrap {
    public PlasticWrap(double price,String name) {
        super(price,name);
    }
    public PlasticWrap(){
        setName("Упаковка из пластика");
        setPrice(2.0);
    }
}
