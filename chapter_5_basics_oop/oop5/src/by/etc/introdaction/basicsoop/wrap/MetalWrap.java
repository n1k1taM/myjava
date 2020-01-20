package by.etc.introdaction.basicsoop.wrap;

public class MetalWrap extends Wrap {
    public MetalWrap(double price,String name) {
        super(price,name);
    }

    public MetalWrap(){
        setName("Металическая упаковка");
        setPrice(3.0);
    }
}
