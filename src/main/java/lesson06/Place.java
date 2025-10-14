package lesson06;

public class Place {
    private final String placeId;
    private boolean isBooked;
    private String nameOfPassanger;
    private final placeType type;


    Place(String placeId, placeType type) {
        this.placeId = placeId;
        this.isBooked = false;
        this.nameOfPassanger = "";
        this.type = type;
    }


    Place(String placeId, placeType type, boolean bookingStatus, String nameOfPassanger) {
        this.placeId = placeId;
        this.isBooked = bookingStatus;
        this.nameOfPassanger = nameOfPassanger;
        this.type = type;
    }

    // Getters
    public String getPlaceId() {return this.placeId;}

    public boolean getBookingStatus() {return this.isBooked;}

    // Setters
    public void setBookingStatus(boolean status) {
        this.isBooked = status;
    }

    public String getNameOfPassanger() {return this.nameOfPassanger;}

    public void setNameOfPassanger(String name) {
        this.nameOfPassanger = name;
    }

    public placeType getType() {return this.type;}

    public enum placeType {BUSINESS, ECONOMY, LIMITED_RECLINE}
}