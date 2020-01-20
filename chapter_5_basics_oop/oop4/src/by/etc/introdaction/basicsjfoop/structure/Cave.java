package by.etc.introdaction.basicsjfoop.structure;

import by.etc.introdaction.basicsjfoop.action.TreasureAction;

import java.util.ArrayList;
import java.util.List;

public class Cave {
    private String titleCave;
    private List<Treasure> treasures;
    private TreasureAction treasureAction = new TreasureAction();


    public Cave(String titleCave) {
        this.titleCave = titleCave;
        this.treasures = treasureAction.fillCaveWithTreasures();
    }

    public String getTitleCave() {
        return titleCave;
    }

    public void setTitleCave(String titleCave) {
        this.titleCave = titleCave;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public TreasureAction getTreasureAction() {
        return treasureAction;
    }

}
