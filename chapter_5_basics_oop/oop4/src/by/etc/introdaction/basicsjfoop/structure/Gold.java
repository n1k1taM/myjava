package by.etc.introdaction.basicsjfoop.structure;

public class Gold extends Treasure {
    private String descriptionTreasure;

    public Gold(String title, int price, String descriptionTreasure) {
        super(title, price);
        this.descriptionTreasure = descriptionTreasure;
    }

    @Override
    public String getDescriptionTreasure() {
        return descriptionTreasure;
    }

    @Override
    public void setDescriptionTreasure(String descriptionTreasure) {
        this.descriptionTreasure = descriptionTreasure;
    }

    @Override
    public String toString() {

        return String.format("%s description: %s price: %d", this.getTitleTreasure(), this.getDescriptionTreasure(),
                this.getPriceTreasure());
    }
}

