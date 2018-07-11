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
        if (size == 0){
            throw new ParkingLotFullException();
        }
        Receipt receipt =new Receipt();
        list.put(receipt, car);
        return receipt;
    }

    public Car unPark(Receipt receipt) {
//        try {
//            return list.);
//        }catch (ParkingLotFullException e){
//
//        }
        return list.remove(receipt);
    }
}
