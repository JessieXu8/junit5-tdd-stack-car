package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public List<ParkingLot> addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        return parkingLots;
    }

    public void addCar(List<ParkingLot> parkingLots, Car car) {
//        parkingLots.forEach(parkingLot->parkingLot.isFull());
        boolean flag = false;
        for( ParkingLot parkingLot: parkingLots){
            if (!parkingLot.isFull()){
                flag = true;
                parkingLot.park(car);
                break;
            }
        }
        if (flag == false){
            throw new ParkingBoyManagedParkingLotIsFull();
        }
    }
}
