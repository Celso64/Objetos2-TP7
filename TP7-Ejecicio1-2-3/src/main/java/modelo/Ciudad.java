package modelo;

public class Ciudad {

    private Integer zip;
    private String name;
    private Double lat;
    private Double lon;
    private String country;

    public Ciudad(Integer zip, String name, Double lat, Double lon, String contry) {
	this.zip = zip;
	this.name = name;
	this.lat = lat;
	this.lon = lon;
	this.country = contry;
    }

    public Integer getZip() {
	return zip;
    }

    public String getName() {
	return name;
    }

    public Double getLat() {
	return lat;
    }

    public Double getLon() {
	return lon;
    }

    public String getContry() {
	return country;
    }

    @Override
    public String toString() {
	return "zip: " + zip + "\nname: " + name + "\nlat: " + lat + "\nlon: " + lon + "\ncountry: " + country;
    }

}
