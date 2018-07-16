package com.thoughtworks.tdd;

public class Router {
    ParkingBoy parkingBoy;
    private String currentStatus;

    public Router(String currentStatus,ParkingBoy parkingBoy) {
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


    public void doCommand( String command) {
        if (currentStatus == "mainPage") {
            getNextPage(command);
        } else if (currentStatus == "parkPage") {
            currentStatus = getParkCommandHandler(command,parkingBoy);
        } else if (currentStatus == "unparkPage") {
            getUnParkCommandHandler(command);
            currentStatus = "mainPage";
        }
    }

    public String getNextPage(String command) {
        switch (command) {
            case "1":
                currentStatus = parkStatusHandler();
                parkHandler(currentStatus);
                break;
            case "2":
                currentStatus = "unparkPage";
                unparkHandler();
                break;
            default:
                currentStatus = "mainPage";
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

    public String parkStatusHandler(){
        currentStatus = parkingController.getParkStatus(parkingBoy);
        return currentStatus;
    }
    public void parkHandler(String currentStatus){
        parkingController.getParkDisplay(currentStatus);
    }

    public String getParkCommandHandler(String command,ParkingBoy parkingBoy) {
        return parkingController.getParkCommandController(command,parkingBoy);
    }

    public void getUnParkCommandHandler(String command) {
        parkingController.getUnparkCommandController(command,parkingBoy);
    }
}
