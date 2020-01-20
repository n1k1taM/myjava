package by.etc.introdaction.classes;

public class City {
    private String town;
    private int population;

    City(String town, int population) {
        this.town = town;
        this.population=population;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
