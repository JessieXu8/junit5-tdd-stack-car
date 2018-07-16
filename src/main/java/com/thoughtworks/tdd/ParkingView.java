package com.thoughtworks.tdd;

import java.util.Scanner;

public class ParkingView {
    Response response = new Response();

    public void displayParkingGUI(){
        response.send("1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：");
    }

    public void displayParkingServerGUI() {
        StringBuffer display = new StringBuffer();
        display.append("1. 停车\n");
        display.append("2. 取车\n");
        display.append("请输入您要进行的操作：");
        response.send(display.toString());
    }

    public void displayParkingManagementGUI(){
        response.send("1.查看停车场详情\n" +
                "2.添加停车场\n" +
                "3.删除停车场\n" +
                "请输入您要进入的页面：");
    }

    public void displayIllegalInstruction() {
        response.send("非法指令，请查证后再输\n");
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

    public void displayUnparkGUI() {
        response.send("请输入小票编号：");
    }

    public void displayReceiptIsWrong() {
        response.send("非法小票，无法取出车，请查证后再输\n");
    }

    public void displayReceiptIsTrue(Car car) {
        response.send("车已取出，您的车牌号是: " + car.getCarID()+"\n");
    }

    public void displayParkingLotDetails(String parkingDetails) {
        response.send(parkingDetails+"\n");
    }

    public void displayAddParkingLot() {
        response.send("请输入你套添加的停车场信息（格式为：名称，车位）:");
    }

    public void displayDeleteParkingLot() {
        response.send("请输入需要删除的被管理停车场ID:");
    }

    public void displayDeleteParkingLotSuccessfully() {
        response.send("停车场删除成功！\n");
    }

    public void displayDeleteParkingLotFailedBecauseHaveCar() {
        response.send("停车场添加失败，原因：此停车场中，依然停有汽车，无法删除！\n");
    }

    public void displayDeleteParkingLotFailedBecauseDontExist() {
        response.send("停车场添加失败，原因：此停车场不存在！\n");
    }

}
