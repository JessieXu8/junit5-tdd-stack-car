package com.thoughtworks.tdd;

public class Router {
    ParkingBoy parkingBoy;
    private String currentStatus;

    public Router(String currentStatus, ParkingBoy parkingBoy) {
        this.currentStatus = currentStatus;
        this.parkingBoy = parkingBoy;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    ParkingController parkingController = new ParkingController();
    ParkingLotManageController parkingLotManageController = new ParkingLotManageController();


    public void doCommand(String command) {
        switch (currentStatus) {
            case "parkingLotMainPage":
                getNextService(command);
                break;
            case "parkingLotManagePage":
                getNextManagePage(command);
                break;//////////////
            case "addParkingLotPage":
                getAddParkingLotHandler(command);//添加停车场
                currentStatus = "parkingLotMainPage";
                break;
            case "deleteParkingLotPage":
                getDeleteParkingLotHandler(command);//删除停车场
                currentStatus = "parkingLotMainPage";
                break;
            case "mainPage":
                getNextPage(command);
                break;
            case "parkPage":
                currentStatus = getParkCommandHandler(command, parkingBoy);
                break;
            case "unparkPage":
                getUnParkCommandHandler(command);
                currentStatus = "parkingLotMainPage";
                break;
        }
    }

    private void getDeleteParkingLotHandler(String command) {
        parkingLotManageController.getDeleteParkingLot(parkingBoy,command);
    }

    private void getAddParkingLotHandler(String command) {
        parkingLotManageController.getAddParkingLot(parkingBoy,command);
    }

    private void getNextManagePage(String command) {
        switch (command) {
            case "1":
                viewParkingLotDetailsHandler();//查看停车场详情
                currentStatus = "parkingLotMainPage";
                break;
            case "2":
                displayAddParkingLotHandler();//打印请输入添加的停车场信息
                currentStatus = "addParkingLotPage";
                break;
            case "3":
                displayDeleteParkingLotHandler();//打印请删除的停车场信息
                currentStatus = "deleteParkingLotPage";
                break;
            default:
                currentStatus = "parkingLotMainPage";
                illegalHandler();//非法输入回主界面
                break;//非法指令
        }
    }

    private void displayDeleteParkingLotHandler() {
        parkingLotManageController.viewDisplayDeleteParkingLotController();
    }

    private void displayAddParkingLotHandler() {
        parkingLotManageController.viewDisplayAddParkingLotController();
    }

    private void viewParkingLotDetailsHandler() {
        parkingLotManageController.viewParkingLotDetailsController(parkingBoy);
    }

    public String getNextService(String command) {
        switch (command) {
            case "1":
                mainParkingPageHandler();//显示停车服务界面
                currentStatus = "mainPage";
                break;
            case "2":
                mainParkingLotManagePageHandler();//显示停车场管理界面
                currentStatus = "parkingLotManagePage";
                break;
            default:
                currentStatus = "parkingLotMainPage";
                illegalHandler();//非法输入回主界面
                break;
        }
        return currentStatus;
    }

    private void mainParkingLotManagePageHandler() {
        parkingLotManageController.mainParkingLotManagePageController();
    }

    private void mainParkingPageHandler() {
        parkingController.mainParkingPageController();
    }

    public String getNextPage(String command) {
        switch (command) {
            case "1":
                currentStatus = parkStatusHandler();//根据车库是否满，显示停车界面或者最初界面
                parkHandler(currentStatus);
                break;
            case "2":
                currentStatus = "unparkPage";
                unparkHandler();
                break;
            default:
                currentStatus = "parkingLotMainPage";
                illegalHandler();
                break;
        }
        return currentStatus;
    }

    private void illegalHandler() {
        parkingController.illegalController();
    }

    private void unparkHandler() {
        parkingController.unparkController();
    }

    public String parkStatusHandler() {
        currentStatus = parkingController.getParkStatus(parkingBoy);
        return currentStatus;
    }

    public void parkHandler(String currentStatus) {
        parkingController.getParkDisplay(currentStatus);
    }

    public String getParkCommandHandler(String command, ParkingBoy parkingBoy) {
        return parkingController.getParkCommandController(command, parkingBoy);
    }

    public void getUnParkCommandHandler(String command) {
        parkingController.getUnparkCommandController(command, parkingBoy);
    }
}
