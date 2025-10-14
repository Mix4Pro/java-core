package lesson06;

public class Place {
    private String placeId;
    private boolean bookingStatus;
    private String nameOfPassanger;
    private placeType type;


    public enum placeType {BUSINESS , ECONOMY , LIMITED_RECLINE};


    Place (String placeId , placeType type) {
        this.placeId = placeId;
        this.bookingStatus = false;
        this.nameOfPassanger = "";
        this.type = type;
    }

    // Getters
    public String getPlaceId () { return this.placeId; }
    public boolean getBookingStatus () { return this.bookingStatus; }
    public String getNameOfPassanger () { return this.nameOfPassanger; }
    public placeType getType () { return this.type; }

    // Setters
    public void setBookingStatus (boolean status) {
        this.bookingStatus = status;
    }

    public void setNameOfPassanger (String name) {
        this.nameOfPassanger = name;
    }
}