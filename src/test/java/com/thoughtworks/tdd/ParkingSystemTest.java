package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

//import static com.thoughtworks.tdd.ParkingView.displayParkingServerGUI;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class ParkingSystemTest {
    @Test
    public void should_call_park_given_choose_is_1_when_call_checkChoose ()throws Exception{
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingLot parkingLot = mock(ParkingLot.class);
        parkingBoy.addParkingLot(parkingLot);
        ParkingView view = mock(ParkingView.class);

        ParkingController  parkingController = new ParkingController(view,parkingBoy);
        String choose ="1";

        Car car = new Car();
        when(view.displayParkingLotIsNotFull()).thenReturn("N123");
        when(parkingBoy.park(car)).thenReturn(new Receipt());
        parkingController.checkChoose(choose);
//        verify(parkingBoy).park(car);
        verify(parkingBoy).isFull();
    }

    @Test
    public void should_Take(){
//        InputOutput inputOutput = new InputOutput();
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("1");
    }
}
