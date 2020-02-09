package com.gg;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map;
import java.util.TreeMap;

public class ParkingImpl implements Parking {
    private Queue<Integer> emptySlots = null;
    private Map <Integer,Vehicle> filledSlots = null;

    public void createParkingSlot(int size){
        emptySlots = new PriorityQueue<Integer>(size);
        for(int i=1;i<=size;i++) {
            emptySlots.add(i);
        }
        filledSlots = new TreeMap<Integer, Vehicle>();
    }

    public int park(String regNum, String colour){
        if(!emptySlots.isEmpty()) {
            int slotNum = emptySlots.poll();
            Vehicle vehicle = new Vehicle(regNum, colour);
            filledSlots.put(slotNum,vehicle);
            return slotNum;
        }
        return -1;
    }

    public void leave(int slot){
        filledSlots.remove(slot);
        emptySlots.add(slot);
    }

    public void status(){
        System.out.println("Slot No.\tRegistration No\tColour");
        for(Map.Entry<Integer,Vehicle> entry : filledSlots.entrySet()){
            System.out.println(entry.getKey()+"\t"+entry.getValue().getRegistrationNumber()+"\t"+entry.getValue().getColour());
        }
    }

    public String slotNumsForColor(String colour){
        String res = "";
        for(Map.Entry<Integer,Vehicle> entry : filledSlots.entrySet()){
            if(entry.getValue().getColour().equals(colour)){
                res = res + entry.getKey().toString()+", ";

            }
        }
        return !res.equals("")?res.substring(0,res.length()-2):null;
    }
    public String regNumsForColor(String color){
        String res = "";
        for(Map.Entry<Integer,Vehicle> entry : filledSlots.entrySet()){
            if(entry.getValue().getColour().equals(color)){
                res = res + entry.getValue().getRegistrationNumber()+", ";

            }
        }
        return !res.equals("")?res.substring(0,res.length()-2):null;
    }
    public String slotNumForRegNum(String regNum){
        String res = null;
        for(Map.Entry<Integer,Vehicle> entry : filledSlots.entrySet()){
            if(entry.getValue().getRegistrationNumber().equals(regNum)){
                res = entry.getKey().toString();
                break;
            }
        }
        return res;
    }
}
