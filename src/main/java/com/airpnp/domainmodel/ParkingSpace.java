package com.airpnp.domainmodel;

import javax.persistence.*;
import java.util.*;

@Entity
public class ParkingSpace {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private int price;
    private Date startDate;
    private Date endDate;
    private String streetAddress;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Customer customer;

    public ParkingSpace(int price, Date startDate, Date endDate, String streetAddress, Customer owner) {
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.streetAddress = streetAddress;
        this.customer = owner;
    }

    public ParkingSpace() {
    }

    public List<Date> getAvailableDates() {
        List<Date> dates = new ArrayList<Date>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.startDate);

        while (calendar.getTime().before(this.endDate))
        {
            Date result = calendar.getTime();
            dates.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        return dates;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "id=" + id +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", streetAddress='" + streetAddress + '\'' +
                '}';
    }
}
