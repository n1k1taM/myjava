package by.etc.introdaction.classes;

public class Region {
    private String capitalOfRegion;
    private District[] districts;
    private double areaOfRegion;
    private int populationOfRegion;

    Region(City capitalOfRegion, District[] districts) {
        this.capitalOfRegion = capitalOfRegion.getTown();
        this.districts = districts;
        for (District district : districts) {
            populationOfRegion+=district.getCity().getPopulation();
            this.areaOfRegion += district.getAreaOfDistrict();
        }
    }

    public String getCapitalOfRegion() {
        return capitalOfRegion;
    }

    public District[] getDistricts() {
        return districts;
    }

    public double getAreaOfRegion() {
        return areaOfRegion;
    }

    public int getPopulationOfRegion() {
        return populationOfRegion;
    }
}
