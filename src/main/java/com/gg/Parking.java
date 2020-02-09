package com.gg;


import java.util.Queue;
import java.util.Map;

public interface Parking {
        public void createParkingSlot(int size);
        public int park(String regNum, String colour);
        public void leave(int slot);
        public void status();
        public String slotNumsForColor(String colour);
        public String regNumsForColor(String color);
        public String slotNumForRegNum(String regNum);
        public Queue<Integer> getEmptySlots();
        public Map<Integer,Vehicle> getFilledSlots();
}
