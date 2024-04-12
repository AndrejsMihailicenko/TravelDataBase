package org.traveldata;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
class Trip {
    private String id;
    private String city;
    private String date;
    private int days;
    private double price;
    private String vehicle;

    @Override
    public String toString() {
        return String.format("%-3s %-20s %-11s %5d %9.2f %-7s", id, city, date, days, price, vehicle);
    }
}