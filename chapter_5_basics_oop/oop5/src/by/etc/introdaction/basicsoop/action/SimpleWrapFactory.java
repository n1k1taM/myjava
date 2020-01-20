package by.etc.introdaction.basicsoop.action;

import by.etc.introdaction.basicsoop.wrap.*;

public class SimpleWrapFactory {
    public Wrap createWrap(String type){
        Wrap wrap=null;

        if(type.equalsIgnoreCase("Cardboard")){
            wrap=new CardboardWrap();
        }else if(type.equalsIgnoreCase("Metal")){
            wrap=new MetalWrap();
        }else if(type.equalsIgnoreCase("Plastic")){
            wrap=new PlasticWrap();
        }else if(type.equalsIgnoreCase("Pocket")){
            wrap=new PocketWrap();
        }
        return wrap;
    }
}
