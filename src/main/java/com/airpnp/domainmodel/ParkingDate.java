package com.airpnp.domainmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParkingDate  {
    @Id
    private int id;
    private LocalDate date;

    public ParkingDate() {

    }

    public ParkingDate(int id) {
        this.id = id;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public List<ParkingDate> generateDates() {

        List<ParkingDate> totalDates = new ArrayList<>();

        // Show dates 90 days ahead from today
        for(int i = 0; i < 90; i++) {
            ParkingDate date = new ParkingDate(id);
            totalDates.add(date);
            date.setDate(LocalDate.now().plusDays(i));
        }

        return totalDates;
    }
}
