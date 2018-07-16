package com.thoughtworks.tdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args )throws Exception{
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(new ParkingLot(2));
        parkingBoy.addParkingLot(new ParkingLot(2));
        ParkingView view = new ParkingView();
        Request request = new Request();
        Router router = new Router("mainPage",parkingBoy);
        view.getMainGUI();
        while (true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String command = request.setCommand(input);
            router.doCommand(command);
        }
    }
}
