package ru.kharlanov.CarRentalSpringApp.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CarPointForFilterRentalCar {
    private String rentalPointName;

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

    public String getRentalPointName() {
        return rentalPointName;
    }

    public void setRentalPointName(String rentalPointName) {
        this.rentalPointName = rentalPointName;
    }

    public Long getSumRentalTime() {
        return sumRentalTime;
    }

    public void setSumRentalTime(Long sumRentalTime) {
        this.sumRentalTime = sumRentalTime;
    }
}
