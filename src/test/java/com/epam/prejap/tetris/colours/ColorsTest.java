package com.epam.prejap.tetris.colours;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = "colors")
public class ColorsTest {

    @DataProvider
    public Object[][] colorCodesProvider() {
        return new Object[][]{
                {Colors.RESET.getCode(), "\u001B[0m"},
                {Colors.RED.getCode(), "\u001B[30m"},
                {Colors.GREEN.getCode(), "\u001B[32m"},
                {Colors.YELLOW.getCode(), "\u001B[33m"},
                {Colors.BLUE.getCode(), "\u001B[34m"},
                {Colors.PURPLE.getCode(), "\u001B[35m"},
                {Colors.CYAN.getCode(), "\u001B[36m"},
                {Colors.WHITE.getCode(), "\u001B[37m"},
        };
    }

    @DataProvider
    public Object[][] colorIdProvider() {
        return new Object[][]{
                {Colors.RESET.id(), (byte)1},
                {Colors.RED.id(), (byte)2},
                {Colors.GREEN.id(), (byte)3},
                {Colors.YELLOW.id(), (byte)4},
                {Colors.BLUE.id(), (byte)5},
                {Colors.PURPLE.id(), (byte)6},
                {Colors.CYAN.id(), (byte)7},
                {Colors.WHITE.id(), (byte)8},
        };
    }

    @Test(dataProvider = "colorCodesProvider")
    public void correctnessOfReturnedAsciiCode(String colorGetter, String asciiCode) {
        assertEquals(colorGetter, asciiCode);
    }

    @Test(dataProvider = "colorIdProvider")
    public void correctnessOfReturnedId(byte idGetter, byte id) {
        assertEquals(idGetter, id);
    }
}
