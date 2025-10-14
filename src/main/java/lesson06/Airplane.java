package lesson06;

import java.util.ArrayList;

public class Airplane {
    private ArrayList<Place> placeCollection = new ArrayList<>();
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String RESET = "\u001B[0m";

    private void showAPlace(String placeId) {
        Place currentPlace = null;
        for (Place place : placeCollection) {
            if (place.getPlaceId().equals(placeId)) {
                currentPlace = place;
                break;
            }
        }

        if (currentPlace != null) {
            if (currentPlace.getBookingStatus() == false) {
                System.out.print(GREEN + currentPlace.getPlaceId() + " " + " AVAILABLE | " + RESET);
            } else {
                System.out.print(RED + currentPlace.getPlaceId() + " " + " NOT AVAILABLE | " + RESET);

            }
        } else {
            System.out.println("There is no seat like this");
        }
    }

    Airplane() {

        // Loop for business classes
        for (int i = 1; i <= 5; i++) {
            for (char letter = 'A'; letter <= 'B'; letter++) {
                String placeId = i + String.valueOf(letter);
                Place place = new Place(placeId, Place.placeType.BUSINESS);
                placeCollection.add(place);
            }
        }

        // Loop for other classes
        for (int i = 6; i <= 21; i++) {
            if (i == 7 || i == 21) {
                for (char letter = 'A'; letter <= 'F'; letter++) {
                    String placeId = i + String.valueOf(letter);
                    Place place = new Place(placeId, Place.placeType.LIMITED_RECLINE);
                    placeCollection.add(place);
                }
            } else {
                for (char letter = 'A'; letter <= 'F'; letter++) {
                    String placeId = i + String.valueOf(letter);
                    Place place = new Place(placeId, Place.placeType.ECONOMY);
                    placeCollection.add(place);
                }
            }
        }
    }

    public void bookAPlace (String placeId , String name) {
        int place_index = -1;
        for(Place place_i : placeCollection) {
            if(place_i.getPlaceId().equals(placeId)) {
                place_index = placeCollection.indexOf(place_i);
                break;
            }
        }

        if(place_index >= 0) {
            placeCollection.get(place_index).setBookingStatus(true);
            placeCollection.get(place_index).setNameOfPassanger(name);
            System.out.println("The seat " + placeCollection.get(place_index).getPlaceId() + " was booked successfully");
        }else{
            System.out.println("There is no seat like this");
        }
    }

    public void unbookAPlace (String placeId) {
        int place_index = -1;
        for(Place place_i : placeCollection) {
            if(place_i.getPlaceId().equals(placeId)) {
                place_index = placeCollection.indexOf(place_i);
                break;
            }
        }

        if(place_index >= 0) {
            placeCollection.get(place_index).setBookingStatus(false);
            System.out.println("The seat " + placeCollection.get(place_index).getPlaceId() + " was unbooked successfully");
        }else{
            System.out.println("There is no seat like this");
        }
    }

    public void showPlaceInfo (String placeId) {
        Place place = null;
        for(Place place_i : placeCollection) {
            if(place_i.getPlaceId().equals(placeId)) {
                place = place_i;
            }
        }

        if(place != null) {
            if(place.getBookingStatus()){
                System.out.println(RED + "Seat number : " + place.getPlaceId());
                System.out.println("Type of the seat : " + place.getType());
                System.out.println("Booking status : Booked");
                System.out.println("Person who booked the seat : " + place.getNameOfPassanger() + RESET);
            }else{
                System.out.println(GREEN + "Seat number : " + place.getPlaceId());
                System.out.println("Type of the seat : " + place.getType());
                System.out.println("Booking status : Available" + RESET);
            }
        }else{
            System.out.println("There is no seat like this");
        }
    }


    public void showAllPlaces() {
        System.out.println("====== BUSINESS CLASS ======");
        for (int i = 0; i < 10; i++) {
            if ((i + 1) % 2 == 0) {
                this.showAPlace(placeCollection.get(i).getPlaceId());
                System.out.println();
            } else {
                this.showAPlace(placeCollection.get(i).getPlaceId());
            }
        }

        System.out.println("====== ECONOMY CLASS ======");
        for (int i = 10; i < placeCollection.size(); i++) {
            if(i % 3 == 0) {
                this.showAPlace(placeCollection.get(i).getPlaceId());
                System.out.println();
            }else{
                if(placeCollection.get(i).getPlaceId().equals("7A") || placeCollection.get(i).getPlaceId().equals("21A")) {
                    System.out.println("====== LIMITED RECLINE ======");
                    this.showAPlace(placeCollection.get(i).getPlaceId());
                }else if(placeCollection.get(i).getPlaceId().equals("8A")){
                    System.out.println("====== ECONOMY CLASS ======");
                    this.showAPlace(placeCollection.get(i).getPlaceId());
                }else{
                    this.showAPlace(placeCollection.get(i).getPlaceId());
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Airplane aircraft = new Airplane();

        aircraft.showAllPlaces();

        System.out.println("====== SINGULAR ======");
        aircraft.bookAPlace("7A" , "Someone");
        aircraft.showPlaceInfo("7A");

        aircraft.showAllPlaces();
    }
}