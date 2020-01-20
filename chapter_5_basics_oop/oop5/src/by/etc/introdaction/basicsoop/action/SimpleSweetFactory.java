package by.etc.introdaction.basicsoop.action;

import by.etc.introdaction.basicsoop.sweets.*;

public class SimpleSweetFactory {

    public Sweets createSweet(String type){
        Sweets sweets=null;

        if(type.equalsIgnoreCase("Caramel")){
            sweets=new Caramel();
        }else if(type.equalsIgnoreCase("Chocolate")){
            sweets=new Chocolate();
        }else if(type.equalsIgnoreCase("Cookie")){
            sweets=new Cookie();
        }else if(type.equalsIgnoreCase("ChokolateBar")){
            sweets=new ChocolateBar();
        }
        return sweets;
    }
}
