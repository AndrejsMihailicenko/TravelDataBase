package org.traveldata;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;

class TripManager {
    private List<Trip> trips;
    private static final String DB_FILE = "db.csv";
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public TripManager() {
        trips = new ArrayList<>();
        loadFile();
    }

    private void loadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                Trip trip = new Trip(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), parts[5]);
                trips.add(trip);
            }
        } catch (IOException e) {
            System.out.println("Failed to load database");
        }
    }

    private void saveFile() {
        try (PrintWriter writer = new PrintWriter(DB_FILE)) {
            for (Trip trip : trips) {
                writer.println(String.join(";", trip.getId(), trip.getCity(), trip.getDate(), String.valueOf(trip.getDays()), String.format("%.2f", trip.getPrice()), trip.getVehicle()));
            }
        } catch (IOException e) {
            System.out.println("Failed to save database");
        }
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
        saveFile();
    }

    public void deleteTrip(String id) {
        trips.removeIf(trip -> trip.getId().equals(id));
        saveFile();
    }

    public void editTrip(String id, Trip newTrip) {
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getId().equals(id)) {
                trips.set(i, newTrip);
                break;
            }
        }
        saveFile();
    }

    public void printTrips() {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-3s %-20s %-11s %5s %9s %7s%n", "ID", "City", "Date", "Days", "Price", "Vehicle");
        System.out.println("------------------------------------------------------------");
        for (Trip trip : trips) {
            System.out.println(trip);
        }
        System.out.println("------------------------------------------------------------");
    }

    public void sortTripsByDate() {
        trips.sort(Comparator.comparing(Trip::getDate, (d1, d2) -> {
            try {
                return dateFormat.parse(d1).compareTo(dateFormat.parse(d2));
            } catch (Exception e) {
                return 0;
            }
        }));
        saveFile();
    }

    public void findTripsBelowPrice(double priceLimit) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-3s %-20s %-11s %5s %9s %7s%n", "ID", "City", "Date", "Days", "Price", "Vehicle");
        System.out.println("------------------------------------------------------------");
        for (Trip trip : trips) {
            if (trip.getPrice() <= priceLimit) {
                System.out.println(trip);
            }
        }
        System.out.println("------------------------------------------------------------");
    }

    public void calculateAveragePrice() {
        if (trips.isEmpty()) {
            System.out.println("db is empty");
            return;
        }
        double sum = trips.stream().mapToDouble(Trip::getPrice).sum();
        double avg = sum / trips.size();
        System.out.printf("average=%.2f\n", avg);
    }

    public List<Trip> getTrips() {
        return trips;
    }
}