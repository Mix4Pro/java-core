package lesson07;

// Utilities

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Airplane {
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String RESET = "\u001B[0m";
    private final ArrayList<Place> placeCollection = new ArrayList<>();
    private LocalDateTime departureDate;

    // Constructor
    Airplane() {
        String filePath = "src/main/java/lesson07/database.txt";
        File file = new File(filePath);

        if (file.length() >= 2616) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    buildAPlace(line.split("\\$"));
                }
            } catch (FileNotFoundException e) {
                System.out.println("File is not found");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        } else {
            saveToFile();
        }
    }

    // "Show a place" component for showAllPlaces method
    private void showAPlace(String placeId) {
        Place currentPlace = null;
        for (Place place : placeCollection) {
            if (place.getPlaceId().equals(placeId)) {
                currentPlace = place;
                break;
            }
        }

        if (currentPlace != null) {
            if (currentPlace.getBookingStatus() == Place.bookingStatusEnum.FREE) {
                System.out.print(GREEN + currentPlace.getPlaceId() + " " + " FREE | " + RESET);
            } else if (currentPlace.getBookingStatus() == Place.bookingStatusEnum.BOOKED) {
                System.out.print(YELLOW + currentPlace.getPlaceId() + " " + " BOOKED | " + RESET);
            } else {
                System.out.print(RED + currentPlace.getPlaceId() + " " + " BOUGHT | " + RESET);
            }
        } else {
            System.out.println("There is no seat like this");
        }
    }

    // Storing data in the database
    private void saveToFile() {
        String filePath = "src/main/java/lesson07/database.txt";
        File file = new File(filePath);
        if (!placeCollection.isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                // Loop for business classes
                for (int i = 0; i < placeCollection.size(); i++) {
                    String place_str = placeCollection.get(i).getPlaceId() + "$" + placeCollection.get(i).getType() + "$" +
                        placeCollection.get(i).getBookingStatus() + "$" + placeCollection.get(i).getDateOfBooking() + "$" + placeCollection.get(i).getNameOfPassanger();
                    bw.write(place_str);
                    bw.newLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("File is not found");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        } else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                // Loop for business classes
                for (int i = 1; i <= 5; i++) {
                    for (char letter = 'A'; letter <= 'B'; letter++) {
                        String placeId = i + String.valueOf(letter);
                        Place place = new Place(placeId, Place.placeType.BUSINESS);
                        String place_str = place.getPlaceId() + "$" + place.getType() + "$" + place.getBookingStatus() +
                            "$" + place.getDateOfBooking() + "$" + place.getNameOfPassanger();
                        bw.write(place_str);
                        bw.newLine();
                        placeCollection.add(place);
                    }
                }

                // Loop for other classes
                for (int i = 6; i <= 21; i++) {
                    if (i == 7 || i == 21) {
                        for (char letter = 'A'; letter <= 'F'; letter++) {
                            String placeId = i + String.valueOf(letter);
                            Place place = new Place(placeId, Place.placeType.LIMITED_RECLINE);
                            String place_str = place.getPlaceId() + "$" + place.getType() + "$" + place.getBookingStatus() +
                                "$" + place.getDateOfBooking() + "$" + place.getNameOfPassanger();
                            bw.write(place_str);
                            bw.newLine();
                            placeCollection.add(place);
                        }
                    } else {
                        for (char letter = 'A'; letter <= 'F'; letter++) {
                            String placeId = i + String.valueOf(letter);
                            Place place = new Place(placeId, Place.placeType.ECONOMY);
                            String place_str = place.getPlaceId() + "$" + place.getType() + "$" + place.getBookingStatus() +
                                "$" + place.getDateOfBooking() + "$" + place.getNameOfPassanger();
                            bw.write(place_str);
                            bw.newLine();
                            placeCollection.add(place);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File is not found");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }

    }

    // Divide a line into tokens
    private void buildAPlace(String[] tokens) {
        String placeId = tokens[0];
        Place.placeType type = Place.placeType.valueOf(tokens[1]);
        Place.bookingStatusEnum bookingStatus = Place.bookingStatusEnum.valueOf(tokens[2]);
        if (tokens.length > 4 && bookingStatus == Place.bookingStatusEnum.BOOKED) {
            LocalDateTime date = LocalDateTime.parse(tokens[3]);
            String name = tokens[4];
            Place place = new Place(placeId, type, bookingStatus, date, name);
            placeCollection.add(place);
        } else if (tokens.length > 4 && bookingStatus == Place.bookingStatusEnum.PAID) {
            String name = tokens[4];
            Place place = new Place(placeId, type, bookingStatus, null, name);
            placeCollection.add(place);
        } else {
            Place place = new Place(placeId, Place.placeType.valueOf(tokens[1]));
            placeCollection.add(place);
        }

        clearOldBookings();
    }

    // Book a flight
    public void bookAPlace(String placeId, String name) {
        clearOldBookings();
        int place_index = -1;
        for (Place place_i : placeCollection) {
            if (place_i.getPlaceId().equals(placeId)) {
                place_index = placeCollection.indexOf(place_i);
                break;
            }
        }

        if (place_index >= 0) {
            if (placeCollection.get(place_index).getBookingStatus() != Place.bookingStatusEnum.BOOKED &&
                placeCollection.get(place_index).getBookingStatus() != Place.bookingStatusEnum.PAID) {
                placeCollection.get(place_index).setBookingStatus(Place.bookingStatusEnum.BOOKED);
                placeCollection.get(place_index).setDateOfBooking(LocalDateTime.now().withNano(0));
                placeCollection.get(place_index).setNameOfPassanger(name);
                saveToFile();
                System.out.println("The seat " + placeCollection.get(place_index).getPlaceId() + " was booked successfully");
            } else {
                System.out.println("This place is already taken");
            }
        } else {
            System.out.println("There is no seat like this");
        }
    }

    // Unbook a flight
    public void unbookAPlace(String placeId) {
        clearOldBookings();
        int place_index = -1;
        for (Place place_i : placeCollection) {
            if (place_i.getPlaceId().equals(placeId)) {
                place_index = placeCollection.indexOf(place_i);
                break;
            }
        }

        if (place_index >= 0) {
            if (placeCollection.get(place_index).getBookingStatus() != Place.bookingStatusEnum.FREE) {
                placeCollection.get(place_index).setBookingStatus(Place.bookingStatusEnum.FREE);
                placeCollection.get(place_index).setDateOfBooking(null);
                placeCollection.get(place_index).setNameOfPassanger("");
                saveToFile();
                System.out.println("The seat " + placeCollection.get(place_index).getPlaceId() + " was unbooked successfully");
            } else {
                System.out.println("This place is not taken");
            }
        } else {
            System.out.println("There is no seat like this");
        }
    }

    // Show a certain place information
    public void showPlaceInfo(String placeId) {
        clearOldBookings();
        Place place = null;
        for (Place place_i : placeCollection) {
            if (place_i.getPlaceId().equals(placeId)) {
                place = place_i;
            }
        }

        if (place != null) {
            if (place.getBookingStatus() == Place.bookingStatusEnum.FREE) {
                System.out.println(GREEN + "Seat number : " + place.getPlaceId());
                System.out.println("Type of the seat : " + place.getType());
                System.out.println("Booking status : " + place.getBookingStatus() + RESET);
            } else if (place.getBookingStatus() == Place.bookingStatusEnum.BOOKED) {
                System.out.println(YELLOW + "Seat number : " + place.getPlaceId());
                System.out.println("Type of the seat : " + place.getType());
                System.out.println("Booking status : " + place.getBookingStatus());
                System.out.println("Booking time : " + place.getDateOfBooking());
                System.out.println("Person who booked the seat : " + place.getNameOfPassanger() + RESET);
            } else {
                System.out.println(RED + "Seat number : " + place.getPlaceId());
                System.out.println("Type of the seat : " + place.getType());
                System.out.println("Booking status : " + place.getBookingStatus());
                System.out.println("Person who bought the seat : " + place.getNameOfPassanger() + RESET);
            }
        } else {
            System.out.println("There is no seat like this");
        }
    }

    // Set a departure time
    public void setADepartureTime(LocalDateTime date) {
        this.departureDate = date;
    }

    public void buyAPlace(String placeId, String name) {
        int index_place = -1;
        for (Place place_i : placeCollection) {
            if (place_i.getPlaceId().equals(placeId)) {
                index_place = placeCollection.indexOf(place_i);
                break;
            }
        }

        if (index_place >= 0) {
            if (placeCollection.get(index_place).getBookingStatus() != Place.bookingStatusEnum.PAID) {
                placeCollection.get(index_place).setDateOfBooking(null);
                placeCollection.get(index_place).setBookingStatus(Place.bookingStatusEnum.PAID);
                placeCollection.get(index_place).setNameOfPassanger(name);

                System.out.println("Bought a seat " + placeCollection.get(index_place).getPlaceId() + " successfully");
            } else {
                System.out.println("Could not buy the place");
            }
        } else {
            System.out.println("There is no seat like this");
        }
    }


    public void showAllPlaces() {
        clearOldBookings();
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
            if (i % 3 == 0) {
                this.showAPlace(placeCollection.get(i).getPlaceId());
                System.out.println();
            } else {
                if (placeCollection.get(i).getPlaceId().equals("7A") || placeCollection.get(i).getPlaceId().equals("21A")) {
                    System.out.println("====== LIMITED RECLINE ======");
                    this.showAPlace(placeCollection.get(i).getPlaceId());
                } else if (placeCollection.get(i).getPlaceId().equals("8A")) {
                    System.out.println("====== ECONOMY CLASS ======");
                    this.showAPlace(placeCollection.get(i).getPlaceId());
                } else {
                    this.showAPlace(placeCollection.get(i).getPlaceId());
                }
            }
        }

        System.out.println("DEPARTURE TIME : " + this.departureDate.withNano(0));
    }

    public void clearOldBookings() {
        for (Place place : placeCollection) {
            if (place.getDateOfBooking() != null) {
                int index_place = placeCollection.indexOf(place);
                LocalDateTime bookingTime = place.getDateOfBooking();
                LocalDateTime now = LocalDateTime.now().withNano(0);

                Duration difference = Duration.between(bookingTime, now);
                long diff_minutes = difference.toMinutes();
                if (diff_minutes >= 24) {
                    placeCollection.get(index_place).setDateOfBooking(null);
                    placeCollection.get(index_place).setNameOfPassanger("");
                    placeCollection.get(index_place).setBookingStatus(Place.bookingStatusEnum.FREE);
                }
            }
        }
        saveToFile();
    }
}