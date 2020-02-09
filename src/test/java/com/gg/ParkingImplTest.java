package com.gg;

import com.gg.parkinglot.Parking;
import com.gg.parkinglot.ParkingImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingImplTest {
    private Parking parking  = new ParkingImpl();

    @Test
    public void createParkingSlot() {
        parking.createParkingSlot(4);
        assertEquals(4, parking.getEmptySlots().size());
    }

    @Test
    public void park() {
        parking.createParkingSlot(4);
        parking.park("KA-01-HH-9999", "White");
        assertEquals(3, parking.getEmptySlots().size());
        assertEquals(1, parking.getFilledSlots().size());
    }

    @Test
    public void leave() {
        parking.createParkingSlot(4);
        parking.park("KA-01-HH-9999", "White");
        parking.leave(1);
        assertEquals(4, parking.getEmptySlots().size());
        assertEquals(0, parking.getFilledSlots().size());
    }

    @Test
    public void status() {
        parking.createParkingSlot(4);
        parking.park("KA-01-HH-9999", "White");
        parking.status();
    }

    @Test
    public void slotNumsForColor() {
        parking.createParkingSlot(4);
        parking.park("KA-01-HH-9999", "White");
        String res = parking.slotNumsForColor("White");
        assertEquals(1, Integer.parseInt(res));
    }

    @Test
    public void regNumsForColor() {
        parking.createParkingSlot(4);
        parking.park("KA-01-HH-9999", "White");
        String res = parking.regNumsForColor("White");
        assertEquals("KA-01-HH-9999", res);
    }

    @Test
    public void slotNumForRegNum() {
        parking.createParkingSlot(4);
        parking.park("KA-01-HH-9999", "White");
        String res = parking.slotNumForRegNum("KA-01-HH-9999");
        assertEquals("1", res);
    }
}