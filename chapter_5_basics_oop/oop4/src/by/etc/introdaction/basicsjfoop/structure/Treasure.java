package by.etc.introdaction.basicsjfoop.structure;

import java.util.Objects;

public abstract class Treasure {
    private String titleTreasure;
    private int priceTreasure;


    public Treasure(String titleTreasure, int priceTreasure) {
        this.titleTreasure = titleTreasure;
        this.priceTreasure = priceTreasure;

    }

    public String getTitleTreasure() {
        return titleTreasure;
    }

    public int getPriceTreasure() {
        return priceTreasure;
    }

    public void setTitleTreasure(String titleTreasure) {
        this.titleTreasure = titleTreasure;
    }

    public void setPriceTreasure(int priceTreasure) {
        this.priceTreasure = priceTreasure;
    }

    public abstract String getDescriptionTreasure();

    public abstract void setDescriptionTreasure(String descriptionTreasure);

}
