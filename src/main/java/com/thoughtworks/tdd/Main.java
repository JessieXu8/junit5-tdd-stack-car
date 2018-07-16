package com.thoughtworks.tdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args )throws Exception{
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(new ParkingLot(2,String.format("%03d",parkingBoy.count++),"西南停车场"));
        parkingBoy.addParkingLot(new ParkingLot(2,String.format("%03d",parkingBoy.count++),"西南停车场"));
        ParkingView view = new ParkingView();
        Request request = new Request();
        Router router = new Router("parkingLotMainPage",parkingBoy);
        view.displayParkingGUI();
        while (true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String command = request.setCommand(input);
            router.doCommand(command);
        }
    }
}
