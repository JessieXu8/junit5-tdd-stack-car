package com.thoughtworks.tdd;

import java.util.Scanner;

public class ParkingView {
    Response response = new Response();

    public void getMainGUI() {
        StringBuffer display = new StringBuffer();
        display.append("1. 停车\n");
        display.append("2. 取车\n");
        display.append("请输入您要进行的操作：");
        response.send(display.toString());
    }

    public void displayIllegalInstruction() {
        response.send("非法指令，请查证后再输\n");
    }

    public String displayParkingLotIsNotFull_old() {
        System.out.print("请输入车牌号:");
        Scanner scanner = new Scanner(System.in);
        String carID = scanner.nextLine();
        return carID;
    }

    public void displayParkingLotIsNotFull() {
        response.send("请输入车牌号:");
    }

    public void displayParkingLotIsFull() {
        response.send("车已停满，请晚点再来\n");
    }

    public void displayParkSuccessfull(Receipt receipt){
        response.send("停车成功，您的小票是：\n"+receipt.getReceipt()+"\n");
    }

    public String displayUnparkGUI_old() {
        System.out.print("请输入小票编号：");
        Scanner scanner = new Scanner(System.in);
        String receipt = scanner.nextLine();
        return receipt;
    }
    public void displayUnparkGUI() {
        response.send("请输入小票编号：");
    }

    public void displayReceiptIsWrong() {
        response.send("非法小票，无法取出车，请查证后再输\n");
    }

    public void displayReceiptIsTrue(Car car) {
        response.send("车已取出，您的车牌号是: " + car.getCarID()+"\n");
    }
}
