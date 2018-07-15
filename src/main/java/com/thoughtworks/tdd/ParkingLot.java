package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private int size;

    Map<Receipt,Car> mapOfReceiptAndCar = new HashMap<>();

    public ParkingLot(int size) {
        this.size = size;
    }

    public Receipt park(Car car) {
        if (isFull()){
            throw new ParkingLotFullException();
        }
        Receipt receipt =new Receipt(UUID.randomUUID());
        mapOfReceiptAndCar.put(receipt, car);
        return receipt;
    }

    public Car unPark(Receipt receipt) {
        return mapOfReceiptAndCar.remove(receipt);
    }

    public boolean isFull() {
        if (size == mapOfReceiptAndCar.size()){
            return true;
        }else {
            return false;
        }
    }
}
