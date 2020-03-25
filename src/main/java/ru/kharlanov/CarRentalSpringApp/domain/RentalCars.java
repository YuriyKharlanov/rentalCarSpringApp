package ru.kharlanov.CarRentalSpringApp.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RentalCars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date toRental;
    private Date fromRental;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rentalpoint_id")
    private RentalPoint rentalPoint;

    public RentalCars() {
    }

    public RentalCars(Date toRental, Date fromRental, Customers customers, RentalPoint rentalPoint) {
        this.toRental = toRental;
        this.fromRental = fromRental;
        this.customers = customers;
        this.rentalPoint = rentalPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getToRental() {
        return toRental;
    }

    public void setToRental(Date toRental) {
        this.toRental = toRental;
    }

    public Date getFromRental() {
        return fromRental;
    }

    public void setFromRental(Date fromRental) {
        this.fromRental = fromRental;
    }

    public String getCustomers() {
        return customers.getFullName();
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public String getRentalPoint() {
        return rentalPoint.getPointName();
    }

    public void setRentalPoint(RentalPoint rentalPoint) {
        this.rentalPoint = rentalPoint;
    }
}