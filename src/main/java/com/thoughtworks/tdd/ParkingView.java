package com.thoughtworks.tdd;

import java.util.Scanner;

public class ParkingView {

    public StringBuffer getMainGUI() {
        StringBuffer display = new StringBuffer();
        display.append("1. 停车\n");
        display.append("2. 取车\n");
        display.append("请输入您要进行的操作：");
        System.out.print(display);
        return display;
    }


    public String displayParkingLotIsNotFull() {
        System.out.print("请输入车牌号:");
        Scanner scanner = new Scanner(System.in);
        String carID = scanner.nextLine();
        return carID;
    }

    public void displayParkingLotIsFull() {
        System.out.print("车已停满，请晚点再来\n");
    }

    public void displayParkSuccessfull(Receipt receipt){
        System.out.println("停车成功，您的小票是：\n"+receipt.getReceipt());
    }

    public String displayUnparkGUI() {
        System.out.print("请输入小票编号：");
        Scanner scanner = new Scanner(System.in);
        String receipt = scanner.nextLine();
        return receipt;
    }

    public void displayReceiptIsWrong() {
        System.out.println("非法小票，无法取出车，请查证后再输");
    }

    public void displayReceiptIsTrue(Car car) {
        System.out.println("车已取出，您的车牌号是: " + car.getCarID());
    }
}
