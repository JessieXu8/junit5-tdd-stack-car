package com.thoughtworks.tdd;

public class ParkingLotManageController {
    ParkingView view = new ParkingView();

    public void mainParkingLotManagePageController() {
        view.displayParkingManagementGUI();
    }

    public void viewParkingLotDetailsController(ParkingBoy parkingBoy) {
        String parkingDetails ="|停车场ID|名称|车位|已停车辆|剩余车位|\n" +
                "======================================\n";
        int totalParkingSpaces=0;
        int totalParking=0;
        int totalRemainingParkingSpaces=0;
        for(ParkingLot parkingLot : parkingBoy.getParkingLots()){
            parkingDetails+="|"+parkingLot.getParkingLotID()+"|"+parkingLot.getParkingLotName()+
                    "|"+parkingLot.getSize()+"(个)|"+parkingLot.getMapOfReceiptAndCar().size()+
                    "(辆)|"+(parkingLot.getSize()-parkingLot.getMapOfReceiptAndCar().size())+"(个)|\n";
            totalParkingSpaces+=parkingLot.getSize();
            totalParking+=parkingLot.getMapOfReceiptAndCar().size();
        }
        totalRemainingParkingSpaces =totalParkingSpaces-totalParking;
        parkingDetails+="总车位："+totalParkingSpaces+"(个)\n" +
                "停车总量："+totalParking+"（辆）\n" +
                "总剩余车位："+totalRemainingParkingSpaces+"（个）";
        view.displayParkingLotDetails(parkingDetails);
        view.displayParkingGUI();
    }

    public void viewDisplayAddParkingLotController() {
        view.displayAddParkingLot();
    }

    public void getAddParkingLot(ParkingBoy parkingBoy, String command) {
        int size =Integer.parseInt(command.split(" ")[1]);
        String id =String.format("%03d",parkingBoy.count++);
        ParkingLot parkingLot = new ParkingLot(size,id,command.split(" ")[0]);
        parkingBoy.addParkingLot(parkingLot);
        view.displayParkingGUI();
    }

    public void viewDisplayDeleteParkingLotController() {
        view.displayDeleteParkingLot();
    }

    public void getDeleteParkingLot(ParkingBoy parkingBoy, String command) {
        boolean isExist=false;
        for (ParkingLot parkingLot:parkingBoy.getParkingLots()){
            if(parkingLot.getParkingLotID().equals(command) && parkingLot.getMapOfReceiptAndCar().size()==0){
                isExist = true;
                parkingBoy.removeParkingLot(parkingLot);
                view.displayDeleteParkingLotSuccessfully();
                break;
            }else if (parkingLot.getParkingLotID().equals(command)){
                isExist = true;
                view.displayDeleteParkingLotFailedBecauseHaveCar();
                break;
            }
        }
        if(!isExist){
            view.displayDeleteParkingLotFailedBecauseDontExist();
        }
        view.displayParkingGUI();
    }
}
