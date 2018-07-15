package com.thoughtworks.tdd;

import java.util.Scanner;

public class ParkingController {
    public ParkingController(ParkingView view, ParkingBoy parkingBoy) {
        this.view = view;
        this.parkingBoy = parkingBoy;
    }

    private ParkingView view;
    private ParkingBoy parkingBoy;

    public  void getChoose() throws Exception {

        while (true) {
            view.getMainGUI();
            Scanner scanner = new Scanner(System.in);
            String choose = scanner.nextLine();
//            Receipt receipt ;
            try {
                if (checkChoose(choose))
                    break;
            } catch (Exception e) {
                System.out.print("非法指令，请查证后再输\n");
            }
        }
    }

    public boolean checkChoose(String choose) throws Exception {
        if (Integer.parseInt(choose) == 1) {
            //call park
            callPark();
            return true;

        } else if (Integer.parseInt(choose) == 2) {
            //call unpark
            callUnpark();
            return true;
        } else {
            System.out.print("非法指令，请查证后再输\n");
        }
        return false;
    }

    public void callUnpark() throws Exception {
        Receipt receipt = new Receipt(view.displayUnparkGUI()) ;

        Car car = parkingBoy.unPark(receipt);
        if (car == null){
            view.displayReceiptIsWrong();
            getChoose();
        }else {
            view.displayReceiptIsTrue(car);
            getChoose();
        }
    }

    public void callPark() throws Exception {
        if (!parkingBoy.isFull()){
            Car car = new Car(view.displayParkingLotIsNotFull());
            Receipt receipt =parkingBoy.park(car);
            view.displayParkSuccessfull(receipt);
            getChoose();
        }else {
            view.displayParkingLotIsFull();
            getChoose();
        }
    }
}
