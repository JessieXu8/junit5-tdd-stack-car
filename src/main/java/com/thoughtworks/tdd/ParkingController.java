package com.thoughtworks.tdd;

import java.util.Scanner;

public class ParkingController {
    ParkingBoy parkingBoy;
    ParkingView view = new ParkingView();


    public String getParkStatus(ParkingBoy parkingBoy) {
        String currentStatus;
        if (parkingBoy.isFull()) {
            currentStatus = "mainPage";
        } else {
            currentStatus = "parkPage";
        }
        return currentStatus;
    }

    public void getParkDisplay(String currentStatus) {
        if (currentStatus == "mainPage") {
            view.displayParkingLotIsFull();
            view.getMainGUI();
        } else if (currentStatus == "parkPage") {
            view.displayParkingLotIsNotFull();
        }
    }

    public void unparkController() {
        view.displayUnparkGUI();
    }

    public void illegalController() {
        view.displayIllegalInstruction();
        view.getMainGUI();
    }

    public String getParkCommandController(String command, ParkingBoy parkingBoy) {
        Car car = new Car(command);
        Receipt receipt = parkingBoy.park(car);
        view.displayParkSuccessfull(receipt);
        String currentStatus = "mainPage";
        view.getMainGUI();
        return currentStatus;
    }

    public void getUnparkCommandController(String command, ParkingBoy parkingBoy) {
        Receipt receipt = new Receipt(command);
        Car car = parkingBoy.unPark(receipt);
        if (car == null) {
            view.displayReceiptIsWrong();
        } else {
            view.displayReceiptIsTrue(car);
        }
        view.getMainGUI();
    }
}

