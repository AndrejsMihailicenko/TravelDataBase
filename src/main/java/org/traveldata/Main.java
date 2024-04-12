package org.traveldata;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TripManager manager = new TripManager();
        boolean running = true;

        while (running) {
            System.out.println("Enter command: ");
            String input = scanner.nextLine();
            String[] inputParts = input.split(" ", 2);
            String command = inputParts[0].toLowerCase();
            String arguments = inputParts.length > 1 ? inputParts[1] : "";

            switch (command) {
                case "add":
                    String[] parts = arguments.split(";");
                    Trip newTrip = new Trip(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), parts[5]);
                    manager.addTrip(newTrip);
                    break;
                case "del":
                    manager.deleteTrip(arguments.trim());
                    break;
                case "edit":
                    break;
                case "print":
                    manager.printTrips();
                    break;
                case "sort":
                    manager.sortTripsByDate();
                    break;
                case "avg":
                    manager.calculateAveragePrice();
                    break;
                case "find":
                    manager.findTripsBelowPrice(Double.parseDouble(arguments));
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
        scanner.close();
    }
}