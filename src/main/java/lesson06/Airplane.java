package lesson06;

// Utilities

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Airplane {
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String RESET = "\u001B[0m";
    private final ArrayList<Place> placeCollection = new ArrayList<>();

    Airplane() {
        String filePath = "src/main/java/lesson06/database.txt";
        File file = new File(filePath);

        if (file.length() >= 2192) {
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

    private void showAPlace(String placeId) {
        Place currentPlace = null;
        for (Place place : placeCollection) {
            if (place.getPlaceId().equals(placeId)) {
                currentPlace = place;
                break;
            }
        }

        if (currentPlace != null) {
            if (!currentPlace.getBookingStatus()) {
                System.out.print(GREEN + currentPlace.getPlaceId() + " " + " AVAILABLE | " + RESET);
            } else {
                System.out.print(RED + currentPlace.getPlaceId() + " " + " NOT AVAILABLE | " + RESET);

            }
        } else {
            System.out.println("There is no seat like this");
        }
    }

    private void saveToFile() {
        String filePath = "src/main/java/lesson06/database.txt";
        File file = new File(filePath);

        if (!placeCollection.isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                // Loop for business classes
                for (int i = 0; i < placeCollection.size(); i++) {
                    String place_str = placeCollection.get(i).getPlaceId() + "$" + placeCollection.get(i).getType() + "$" +
                        placeCollection.get(i).getBookingStatus() + "$" + placeCollection.get(i).getNameOfPassanger();
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
                        String place_str = place.getPlaceId() + "$" + place.getType() + "$" + place.getBookingStatus() + "$" + place.getNameOfPassanger();
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
                            String place_str = place.getPlaceId() + "$" + place.getType() + "$" + place.getBookingStatus() + "$" + place.getNameOfPassanger();
                            bw.write(place_str);
                            bw.newLine();
                            placeCollection.add(place);
                        }
                    } else {
                        for (char letter = 'A'; letter <= 'F'; letter++) {
                            String placeId = i + String.valueOf(letter);
                            Place place = new Place(placeId, Place.placeType.ECONOMY);
                            String place_str = place.getPlaceId() + "$" + place.getType() + "$" + place.getBookingStatus() + "$" + place.getNameOfPassanger();
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

    private void buildAPlace(String[] tokens) {
        String placeId = tokens[0];
        boolean isBooked = Boolean.parseBoolean(tokens[2]);
        if (tokens.length > 3 && isBooked) {
            String name = tokens[3];
            Place place = new Place(placeId, Place.placeType.valueOf(tokens[1]), isBooked, name);
            placeCollection.add(place);
        } else {
            Place place = new Place(placeId, Place.placeType.valueOf(tokens[1]));
            placeCollection.add(place);
        }

    }

    public void bookAPlace(String placeId, String name) {
        int place_index = -1;
        for (Place place_i : placeCollection) {
            if (place_i.getPlaceId().equals(placeId)) {
                place_index = placeCollection.indexOf(place_i);
                break;
            }
        }

        if (place_index >= 0) {
            if (!placeCollection.get(place_index).getBookingStatus()) {
                placeCollection.get(place_index).setBookingStatus(true);
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

    public void unbookAPlace(String placeId) {
        int place_index = -1;
        for (Place place_i : placeCollection) {
            if (place_i.getPlaceId().equals(placeId)) {
                place_index = placeCollection.indexOf(place_i);
                break;
            }
        }

        if (place_index >= 0) {
            if (placeCollection.get(place_index).getBookingStatus()) {
                placeCollection.get(place_index).setBookingStatus(false);
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

    public void showPlaceInfo(String placeId) {
        Place place = null;
        for (Place place_i : placeCollection) {
            if (place_i.getPlaceId().equals(placeId)) {
                place = place_i;
            }
        }

        if (place != null) {
            if (place.getBookingStatus()) {
                System.out.println(RED + "Seat number : " + place.getPlaceId());
                System.out.println("Type of the seat : " + place.getType());
                System.out.println("Booking status : Booked");
                System.out.println("Person who booked the seat : " + place.getNameOfPassanger() + RESET);
            } else {
                System.out.println(GREEN + "Seat number : " + place.getPlaceId());
                System.out.println("Type of the seat : " + place.getType());
                System.out.println("Booking status : Available" + RESET);
            }
        } else {
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
    }
}