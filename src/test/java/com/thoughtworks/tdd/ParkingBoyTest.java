package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.is;

public class ParkingBoyTest {
    @Test
    public void should_park_successfully_when_call_park_given_ParkingBoy_managed_parkingLot_is_not_null(){
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(new ParkingLot(1));

        try {
            parkingBoy.park(new Car());

        }catch (ParkingBoyManagedParkingLotIsFullException e){
            fail("should park successfully");
        }
    }

    @Test
    public void should_unpark_successfully_when_call_unpark_given_the_car_is_park_at_ParkingBoy_managed_parkingLot(){
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(new ParkingLot(1));
        Car car = new Car();
        Receipt receipt = parkingBoy.park(car);
//        try {
//            parkingBoy.unPark(receipt);
//
//        }catch (ParkingBoyManagedParkingLotIsFullException e){
//            fail("should park successfully");
//        }
//        Car result = parkingBoy.unPark(receipt);
        assertThat(parkingBoy.unPark(receipt),is(car));
    }

    @Test
    public void should_park_successfully_when_call_park_twice_given_ParkingBoy_managed_parkingLot_is_two(){
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(new ParkingLot(1));
        parkingBoy.addParkingLot(new ParkingLot(1));

        try{
            parkingBoy.park(new Car());
            parkingBoy.park(new Car());

        }catch (ParkingBoyManagedParkingLotIsFullException e){
            fail("should park successfully");
        }
    }

    @Test
    public void should_unpark_successfully_when_call_unpark_twice_given_ParkingBoy_managed_parkingLot_is_two(){
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(new ParkingLot(1));
        parkingBoy.addParkingLot(new ParkingLot(1));
        Receipt receipt1 = parkingBoy.park(new Car());
        Receipt receipt2 = parkingBoy.park(new Car());

        try{
            parkingBoy.unPark(receipt1);
            parkingBoy.unPark(receipt2);

        }catch (ParkingBoyManagedParkingLotIsFullException e){
            fail("should unpark successfully");
        }
    }

    @Test
    public void should_park_in_order_when_call_park_twice_given_the_car_is_park_twice_at_ParkingBoy_managed_parkingLot(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingBoy.addParkingLot(parkingLot1);
        parkingBoy.addParkingLot(parkingLot2);
        Car car1 = new Car();
        Receipt receipt1 = parkingBoy.park(car1);
        Car car2 = new Car();
        Receipt receipt2 = parkingBoy.park(car2);

        assertThat(parkingLot1.list.get(receipt1),is(car1));
        assertThat(parkingLot2.list.get(receipt2),is(car2));
    }

//    @Test
//    public void should_not_park_successfully_when_call_addCar_given_ParkingBoy_managed_parkingLot_is_null(){
//        ParkingBoy parkingBoy = new ParkingBoy();
//        parkingBoy.addParkingLot(new ParkingLot(0));
//
//        try{
//            parkingBoy.park(new Car());
//            fail("should park successfully");
//        }catch (ParkingBoyManagedParkingLotIsFullException e){
//
//        }
//    }

//    @Test
//    public void should_unpark_successfully_when_call_takeoutCar_given_car_is_in_ParkingBoy_managed_parkingLot(){
//        ParkingBoy parkingBoy = new ParkingBoy();
//        parkingBoy.addParkingLot(new ParkingLot(1));
//        Car car = new Car();
//        Receipt receipt = parkingBoy.park(car);
//        try {
//            parkingBoy.unPark(parkingLots,receipt);
//        }catch (ParkingBoyManagedParkingLotIsFullException e){
//            fail("should take out your car");
//        }
//    }
}
