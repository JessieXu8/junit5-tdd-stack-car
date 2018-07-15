package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private int size;

    Map<String,Car> mapOfReceiptAndCar = new HashMap<>();

    public ParkingLot(int size) {
        this.size = size;
    }

    public Receipt park(Car car) {
        if (isFull()){
            throw new ParkingLotFullException();
        }
        Receipt receipt =new Receipt();
        mapOfReceiptAndCar.put(receipt.getReceipt(), car);
        return receipt;
    }

    public Car unPark(Receipt receipt) {
//        if (receipt.getReceipt())
        return mapOfReceiptAndCar.remove(receipt.getReceipt());
    }

    public boolean isFull() {
        if (size == mapOfReceiptAndCar.size()){
            return true;
        }else {
            return false;
        }
    }
}
