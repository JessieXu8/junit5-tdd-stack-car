package com.thoughtworks.tdd;

public class Main {
    public static void main(String[] args )throws Exception{
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(new ParkingLot(2));
        parkingBoy.addParkingLot(new ParkingLot(2));
        ParkingView view = new ParkingView();
        ParkingController  parkingController = new ParkingController(view,parkingBoy);
        parkingController.getChoose();
    }
}
