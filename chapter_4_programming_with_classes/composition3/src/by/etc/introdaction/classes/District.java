package by.etc.introdaction.classes;

public class District {
    private City city;
    private double areaOfDistrict;

    District(City city, double areaOfDistrict) {
        this.city = city;
        this.areaOfDistrict = areaOfDistrict;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public double getAreaOfDistrict() {
        return areaOfDistrict;
    }

    public void setAreaOfDistrict(double areaOfDistrict) {
        this.areaOfDistrict = areaOfDistrict;
    }



    @Override
    public String toString() {
        return city.getTown();
    }
}
