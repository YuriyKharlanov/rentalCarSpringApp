package ru.kharlanov.CarRentalSpringApp.domain;


public class CarPointForFilterRentalCar {
    private String rentalpointName;

    private Long rentalPointId;
    private Long sumRentalTime;

    private int count;

    public Long getRentalPointId() {
        return rentalPointId;
    }

    public void setRentalPointId(Long rentalPointId) {
        this.rentalPointId = rentalPointId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRentalpointName() {
        return rentalpointName;
    }

    public void setRentalpointName(String rentalpointName) {
        this.rentalpointName = rentalpointName;
    }

    public Long getSumRentalTime() {
        return sumRentalTime;
    }

    public void setSumRentalTime(Long sumRentalTime) {
        this.sumRentalTime = sumRentalTime;
    }
}
