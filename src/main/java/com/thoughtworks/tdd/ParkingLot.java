package com.thoughtworks.tdd;

public class ParkingLot {
    private int size;
    public ParkingLot(int size) {
        this.size = size;
    }

    public void park(Car car) {
        if (size == 0){
            throw new ParkingLotFullException();
        }
    }

    public String unPark(Receipt receipt) {
        return null;
    }
}
