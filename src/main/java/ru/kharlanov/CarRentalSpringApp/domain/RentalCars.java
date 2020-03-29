package ru.kharlanov.CarRentalSpringApp.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RentalCars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carsId")
    private Cars carsId;

    private Date toRental;
    private Date fromRental;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customers customers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rentalPointId")
    private RentalPoint rentalPoint;

    //private Long carsIdNumber;

    public RentalCars() {
    }

    public RentalCars(Cars carsId, Date toRental, Date fromRental, Customers customers, RentalPoint rentalPoint) {
        this.carsId = carsId;
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

    public String getCarsId() {
        return carsId.getVendorModelName();
    }

    public Long getCarsIdNumber() {
        return carsId.getId();
    }

    public String getGovNumber() {
        return carsId.getGovernNumber();
    }

    public void setCarsId(Cars carsId) {
        this.carsId = carsId;
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