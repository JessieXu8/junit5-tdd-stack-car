package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(String parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public Map<String, Car> getMapOfReceiptAndCar() {
        return mapOfReceiptAndCar;
    }

    public void setMapOfReceiptAndCar(Map<String, Car> mapOfReceiptAndCar) {
        this.mapOfReceiptAndCar = mapOfReceiptAndCar;
    }

    String parkingLotID;
    String parkingLotName;

    public ParkingLot(int size, String parkingLotID,String parkingLotName) {
        this.size = size;
        this.parkingLotID = parkingLotID;
        this.parkingLotName = parkingLotName;
    }

    Map<String, Car> mapOfReceiptAndCar = new HashMap<>();

    public ParkingLot(int size) {
        this.size = size;
    }

    public Receipt park(Car car) {
        if (isFull()) {
            throw new ParkingLotFullException();
        }
        Receipt receipt = new Receipt();
        mapOfReceiptAndCar.put(receipt.getReceipt(), car);
        return receipt;
    }

    public Car unPark(Receipt receipt) {
//        if (receipt.getReceipt())
        return mapOfReceiptAndCar.remove(receipt.getReceipt());
    }

    public boolean isFull() {
        if (size == mapOfReceiptAndCar.size()) {
            return true;
        } else {
            return false;
        }
    }
}
