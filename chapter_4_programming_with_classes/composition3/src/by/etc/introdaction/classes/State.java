package by.etc.introdaction.classes;

import java.util.Arrays;

public class State {
    private String name;
    private String capital;
    private Region[] regions;
    private double areaOfState;
    private int populationOfState;

    State( String name,City capital, Region[] regions) {
        this.name=name;
        this.capital = capital.getTown();
        this.regions = regions;
        for (Region region : regions) {
            this.areaOfState += region.getAreaOfRegion();
            populationOfState+=region.getPopulationOfRegion();
        }
    }

    public String getCapital() {
        return capital;
    }

    public Region[] getRegions() {
        return regions;
    }

    public double getAreaOfState() {
        return areaOfState;
    }

    public void showCapital() {
        System.out.println("Capital of State: " + getCapital());
    }

    public void showNumberOfRegions() {
        System.out.println("Number of regions: " + regions.length);
    }

    public void showArea() {
        System.out.println("Area of State: " + getAreaOfState());
    }

    public void showRegions() {
        for (Region region : regions) {
            System.out.println("Region: " + region.getCapitalOfRegion() + " Area of region: " + region.getAreaOfRegion() +
                    " List of districts: " + Arrays.asList(region.getDistricts()));
        }
    }

    public void showPopulationOfState() {
        System.out.printf("Population of %s is %d",this.name,this.populationOfState);
    }
}
