package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingBoy {
    public static int count=0;

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public void removeParkingLot(ParkingLot parkingLot){
        parkingLots.remove(parkingLot);
    }

    public Receipt park( Car car) {
//        parkingLots.forEach(parkingLot->parkingLot.isFull());
        boolean flag = false;
        Receipt receipt = new Receipt();
        for( ParkingLot parkingLot: parkingLots){
            if (!parkingLot.isFull()){
                flag = true;
                receipt = parkingLot.park(car);
                break;
            }
        }
        if (!flag){
            throw new ParkingBoyManagedParkingLotIsFullException();
        }
        return receipt;
    }

    public Car unPark(Receipt receipt) {
        Car car = new Car();
        for (ParkingLot parkingLot : parkingLots){
            car=parkingLot.unPark(receipt);
            if(car != null){
                break;
            }
        }
        return car;
    }


    public boolean isFull(){
        boolean isFull = true;
        for( ParkingLot parkingLot: parkingLots){
            if (!parkingLot.isFull()){
                isFull = false;
                break;
            }
        }
        return isFull;
    }
}
