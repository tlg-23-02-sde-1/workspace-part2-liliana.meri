package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 50, DisplayType.LED);
        tv2 = new Television("Sony", 50, DisplayType.LED);
    }

    // Channel Invalid
    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound()
    throws InvalidChannelException {
        try {
            tv1.changeChannel(0); // should trigger  the exception

            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            // you can assert that exceptions reason message is what you expect
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound()
    throws InvalidChannelException {
        try {
            tv1.changeChannel(1000); // should trigger  the exception

            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            // you can assert that exceptions reason message is what you expect
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }

    // Channel Valid
    @Test // checked
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws Exception {
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    @Test // checked
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws Exception {
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    //  Volume Invalid
    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv1.setVolume(-1); // should trigger the exception, and I DON'T catch it
    }

    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        tv1.setVolume(101); // should trigger the exception, and I DON'T catch it
    }

    // Volume Valid
    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound(){
        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());
    }

    // CompareTo
    @Test
    public void compareTo_shouldCompareBrand_whenValid() {
        assertEquals(tv1.getBrand(), tv2.getBrand());
    }

    // HashCode
    @Test
    public void hashCode_shouldBeEqual_whenObjectsEqual() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    // Equals
    @Test
    public void equals_shouldReturnTrue_whenAllPropertiesEqual() {
        assertEquals(tv1, tv2);
        assertTrue(tv1.equals(tv2));
    }

    @Test
    public void equals_shouldReturnFalse_differentBrands(){
        tv1.setBrand("LG");
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_differentDisplays() {
        tv1.setDisplay(DisplayType.OLED);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_differentVolumes(){
       tv1.setVolume(88);
       assertNotEquals(tv1, tv2);
    }
}