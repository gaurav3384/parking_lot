package com.gg;


public interface Parking {
        public void createParkingSlot(int size);
        public int park(String regNum, String colour);
        public void leave(int slot);
        public void status();
        public String slotNumsForColor(String colour);
        public String regNumsForColor(String color);
        public String slotNumForRegNum(String regNum);
}
