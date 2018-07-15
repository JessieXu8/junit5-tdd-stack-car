package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static com.thoughtworks.tdd.ParkingView.getMainGUI;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingSystemTest {
    @Test
    public void should_display_user_interface_when_call_getMainGUI(){
        //given
        StringBuffer excepted = new StringBuffer();
        excepted.append("1. 停车\n2. 取车\n请输入您要进行的操作：");
        //when
        StringBuffer result= getMainGUI();
        //then
        assertThat(result.toString(),is(excepted.toString()));
    }

    @Test
    public void should_display_park_interface_when_input_choose_is_1(){
        int choose = 1;

    }

//    @Test
//    public void should_call_parkingGUI_given_choose_is_1_when_call_getChoose(){
//        //given
//        int choose = 1;
//        //when
//        getChoose(choose);
//        //then
//        assertThat();
//    }
}
