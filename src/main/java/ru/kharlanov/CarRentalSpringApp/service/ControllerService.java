package ru.kharlanov.CarRentalSpringApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kharlanov.CarRentalSpringApp.domain.CarPointForFilterRentalCar;
import ru.kharlanov.CarRentalSpringApp.domain.RentalCars;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class ControllerService {
    @Autowired
    CarPointForFilterRentalCar carPointForFilterRentalCar;

    public static List<String> AverageRentalTime(Iterable<RentalCars> rentalCarsList) {
        List<CarPointForFilterRentalCar> averList = new ArrayList<>();
        for (RentalCars iterRentalCars : rentalCarsList) {
            Long diffInMillies = 0l;
            long first = iterRentalCars.getToRental().getTime();
            long second = iterRentalCars.getFromRental().getTime();
            if (first != second && second > first) {
                diffInMillies = second - first;
            }
            int countEmpty = 0;
            if (!averList.isEmpty()) { //если список не пустой
                for (int i = 0; i < averList.size(); i++) { // фор для обхода exception во время модификации листа при одновременной итерации
                    if (averList.get(i).getRentalPointId() == iterRentalCars.getRentalPointId()) { // если такой id точки уже есть в списке, то обновляем
                        averList.get(i).setSumRentalTime(averList.get(i).getSumRentalTime() + diffInMillies);
                        averList.get(i).setCount(averList.get(i).getCount() + 1);
                        countEmpty++;
                    }
                }
                if (countEmpty == 0) averList.add(createNewCarPointInAverList(iterRentalCars, diffInMillies)); // если в непустом не нашли нужный, тогда делаем новый
            } else averList.add(createNewCarPointInAverList(iterRentalCars, diffInMillies)); // если лист был пустой то создаем новый объект
        }

        List<String> averTimeForEachPoint = new ArrayList<>();
        for (CarPointForFilterRentalCar currCarPointFromAverList : averList) {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Long averUnixTime = currCarPointFromAverList.getSumRentalTime() / currCarPointFromAverList.getCount();
            String resultDays = new java.text.SimpleDateFormat("dd").format(new Date(averUnixTime));
            String resultHours = new java.text.SimpleDateFormat("HH").format(new Date(averUnixTime));
            StringBuilder stringBuilder = new StringBuilder();
            String jointResult = stringBuilder.append("В среднем в пункте ")
                    .append(currCarPointFromAverList.getRentalPointId())
                    .append(" ").append(currCarPointFromAverList.getRentalPointName())
                    .append(" автомобиль берут в прокат на ").append(resultDays).append(" дней и ").append(resultHours).append(" часов").toString();
            averTimeForEachPoint.add(jointResult);
        }
        return averTimeForEachPoint;
    }

    private static CarPointForFilterRentalCar createNewCarPointInAverList(RentalCars iterRentalCars, Long diffInMillies) {
        CarPointForFilterRentalCar carPointForFilterRentalCar = new CarPointForFilterRentalCar();
        carPointForFilterRentalCar.setRentalPointName(iterRentalCars.getRentalPoint());
        carPointForFilterRentalCar.setRentalPointId(iterRentalCars.getRentalPointId());
        carPointForFilterRentalCar.setSumRentalTime(diffInMillies);
        carPointForFilterRentalCar.setCount(1);
        return carPointForFilterRentalCar;
    }
}