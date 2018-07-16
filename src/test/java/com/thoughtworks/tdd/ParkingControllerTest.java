package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingControllerTest {
    @Test
    public void should_return_parkingLotMainPage_given_parkingLots_is_full_when_call_getParkStatus(){
        ParkingController parkingController = new ParkingController();
        ParkingBoy parkingBoy=mock(ParkingBoy.class);
        when(parkingBoy.isFull()).thenReturn(true);
        String currentStatus=parkingController.getParkStatus(parkingBoy);
        assertThat(currentStatus,is("parkingLotMainPage"));
    }

    @Test
    public void should_return_parkPage_given_parkingLots_is_not_full_when_call_getParkStatus(){
        ParkingController parkingController = new ParkingController();
        ParkingBoy parkingBoy=mock(ParkingBoy.class);
        when(parkingBoy.isFull()).thenReturn(false);
        String currentStatus=parkingController.getParkStatus(parkingBoy);
        assertThat(currentStatus,is("parkPage"));
    }
}
