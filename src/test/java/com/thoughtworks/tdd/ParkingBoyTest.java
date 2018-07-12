package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ParkingBoyTest {
    @Test
    public void should_park_successfullly_call_addCar_given_ParkingBoy_managed_parkingLot_is_not_null(){
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots = parkingBoy.addParkingLot(new ParkingLot(1));

        try {
//            parkingLots.forEach(parkingLot->parkingLot.isFull());
            parkingBoy.addCar(parkingLots,new Car());

        }catch (ParkingBoyManagedParkingLotIsFull e){
            fail("should park successfully");
        }
    }

    @Test
    public void should_not_park_successfully_call_addCar_given_ParkingBoy_managed_parkingLot_is_null(){
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots = parkingBoy.addParkingLot(new ParkingLot(0));

        try{
            parkingBoy.addCar(parkingLots,new Car());
            fail("should park successfully");
        }catch (ParkingBoyManagedParkingLotIsFull e){

        }
    }
}
