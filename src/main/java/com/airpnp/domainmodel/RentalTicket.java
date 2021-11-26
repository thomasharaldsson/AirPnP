package com.airpnp.domainmodel;

import javax.persistence.*;

@Entity
public class RentalTicket {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @ManyToOne
    private Customer customer;
}
