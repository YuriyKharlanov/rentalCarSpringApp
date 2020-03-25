package ru.kharlanov.CarRentalSpringApp.domain;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Cars {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String vendorModelName;
    private String governNumber;

    public Cars() {
    }

    public Cars(String vendorModelName, String governNumber) {
        this.vendorModelName = vendorModelName;
        this.governNumber = governNumber;
    }

    public Long getId() {
        return id;
    }

    public String getVendorModelName() {
        return vendorModelName;
    }

    public void setVendorModelName(String vendorModelName) {
        this.vendorModelName = vendorModelName;
    }

    public String getGovernNumber() {
        return governNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGovernNumber(String governNumber) {
        this.governNumber = governNumber;
    }
}