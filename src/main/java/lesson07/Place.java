package lesson07;

import java.time.LocalDateTime;

public class Place {
    private final String placeId;
    private final placeType type;
    private bookingStatusEnum bookingStatus;
    private String nameOfPassanger;
    private LocalDateTime dateOfBooking;

    Place(String placeId, placeType type) {
        this.placeId = placeId;
        this.bookingStatus = bookingStatusEnum.FREE;
        this.nameOfPassanger = "";
        this.type = type;
        this.dateOfBooking = null;
    }

    Place(String placeId, placeType type, bookingStatusEnum bookingStatus, LocalDateTime dateOfBooking, String nameOfPassanger) {
        this.placeId = placeId;
        this.bookingStatus = bookingStatus;
        this.nameOfPassanger = nameOfPassanger;
        this.type = type;
        this.dateOfBooking = dateOfBooking;
    }

    // Getters
    public String getPlaceId() {return this.placeId;}

    public bookingStatusEnum getBookingStatus() {return this.bookingStatus;}

    // Setters
    public void setBookingStatus(bookingStatusEnum bookingStatus) {this.bookingStatus = bookingStatus;}

    public String getNameOfPassanger() {return this.nameOfPassanger;}

    public void setNameOfPassanger(String name) {
        this.nameOfPassanger = name;
    }

    public LocalDateTime getDateOfBooking() {
        if (this.dateOfBooking == null) {
            return dateOfBooking;
        } else {
            return this.dateOfBooking.withNano(0);
        }
    }

    public void setDateOfBooking(LocalDateTime date) {this.dateOfBooking = date;}

    public placeType getType() {return this.type;}

    public enum bookingStatusEnum {FREE, BOOKED, PAID}

    public enum placeType {BUSINESS, ECONOMY, LIMITED_RECLINE}

}