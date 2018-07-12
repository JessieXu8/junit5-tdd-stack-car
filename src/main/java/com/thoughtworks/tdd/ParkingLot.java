package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int size;

    Map<Receipt,Car> list= new HashMap<>();

    public ParkingLot(int size) {
        this.size = size;
    }

    public Receipt park(Car car) {
        if (isFull()){
            throw new ParkingLotFullException();
        }
        Receipt receipt =new Receipt();
        list.put(receipt, car);
        return receipt;
    }

    public Car unPark(Receipt receipt) {
        return list.remove(receipt);
    }

    public boolean isFull() {
        if (size == list.size()){
            return true;
        }else {
            return false;
        }
    }
}
