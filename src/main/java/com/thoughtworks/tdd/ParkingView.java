package com.thoughtworks.tdd;

import java.util.Scanner;

public class ParkingView {
    public static void main(String[] args) throws Exception {
//        getMainGUI();
//        int choose = 0;//////
        getChoose();
    }

    public static StringBuffer getMainGUI() {
        StringBuffer display = new StringBuffer();
        display.append("1. 停车\n");
        display.append("2. 取车\n");
        display.append("请输入您要进行的操作：");
        System.out.print(display);
        return display;
    }

    public static void getChoose() throws Exception {

        while (true) {
            getMainGUI();
            Scanner scanner = new Scanner(System.in);
            String choose = scanner.nextLine();
            try {
                if (Integer.parseInt(choose) == 1) {
                    //call parkGUI
                    break;

                } else if (Integer.parseInt(choose) == 2) {
                    //call unparkGUI
                    break;
                } else {
                    System.out.print("非法指令，请查证后再输\n");
                }
            } catch (Exception e) {
                System.out.print("非法指令，请查证后再输\n");
            }
        }
    }

    public static void displayParkingLotIsFull()throws Exception{
        System.out.print("车已停满，请晚点再来\n");
        getChoose();
    }

    public static void unparkGUI() throws Exception{
        System.out.print("请输入小票编号：");
        Scanner scanner = new Scanner(System.in);
        String receipt = scanner.nextLine();
        //if receipt is existed
        //
        if(true){}
        else {
            System.out.println("非法小票，无法取出车，请查证后再输");
            getChoose();
        }
    }
}
