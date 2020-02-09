package com.gg.app;

import com.gg.constants.MessageConstants;
import com.gg.constants.Operation;
import com.gg.parkinglot.Parking;
import com.gg.parkinglot.ParkingImpl;

import java.util.Scanner;

public class Application {
    public static void main(String args[]){
        startApplication();
    }

    public static void startApplication(){
        Parking parking = new ParkingImpl();
        Scanner sc = new Scanner(System.in);
        while(true){
            String input  = sc.next();
            if(Operation.create_parking_lot.equals(input)){
                int size = sc.nextInt();
                parking.createParkingSlot(size);
                System.out.println(String.format(MessageConstants.created,size));
            }else if(Operation.park.equals(input)){
                String regNum = sc.next();
                String colour = sc.next();
                int slot = parking.park(regNum,colour);
                if(slot == -1){
                    System.out.println(String.format(MessageConstants.fullSlot));
                }else {
                    System.out.println(String.format(MessageConstants.allocated,slot));
                }
            }else if(Operation.leave.equals(input)){
                int slot = sc.nextInt();
                parking.leave(slot);
                System.out.printf(MessageConstants.leave,slot);
            }else if(Operation.status.equals(input)){
                parking.status();
            }else if(Operation.registration_numbers_for_cars_with_colour.equals(input)){
                String color = sc.next();
                String result = parking.regNumsForColor(color);
                System.out.println(result!=null?result:MessageConstants.notFound);
            }else if(Operation.slot_number_for_registration_number.equals(input)){
                String regNum = sc.next();
                String result = parking.slotNumForRegNum(regNum);
                System.out.println(result!=null?result:MessageConstants.notFound);
            }else if(Operation.slot_numbers_for_cars_with_colour.equals(input)){
                String color = sc.next();
                String result = parking.slotNumsForColor(color);
                System.out.println(result!=null?result:MessageConstants.notFound);
            }else if(Operation.exit.equals(input)){
                System.exit(0);
            }
        }
    }
}
