package com.epam.prejap.tetris.colours;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
@Test(groups = "colors")
public class ColorPickerTest {

    public void colorResetShouldReturnProperAsciiCode(){
        assertEquals(ColorPicker.resetColor(), "\u001B[0m");
    }

    @DataProvider
    public Object[][] colorIdProvider() {
        return new Object[][]{
                {ColorPicker.id(Colors.RESET.getCode()), (byte)1},
                {ColorPicker.id(Colors.RED.getCode()), (byte)2},
                {ColorPicker.id(Colors.GREEN.getCode()), (byte)3},
                {ColorPicker.id(Colors.YELLOW.getCode()), (byte)4},
                {ColorPicker.id(Colors.BLUE.getCode()), (byte)5},
                {ColorPicker.id(Colors.PURPLE.getCode()), (byte)6},
                {ColorPicker.id(Colors.CYAN.getCode()), (byte)7},
                {ColorPicker.id(Colors.WHITE.getCode()), (byte)8},
        };
    }

    @DataProvider
    public Object[][] colorCodesProvider() {
        return new Object[][]{
                {ColorPicker.id(Colors.RESET.getCode()), Colors.RESET.getCode()},
                {ColorPicker.id(Colors.RED.getCode()), Colors.RED.getCode()},
                {ColorPicker.id(Colors.GREEN.getCode()), Colors.GREEN.getCode()},
                {ColorPicker.id(Colors.YELLOW.getCode()), Colors.YELLOW.getCode()},
                {ColorPicker.id(Colors.BLUE.getCode()), Colors.BLUE.getCode()},
                {ColorPicker.id(Colors.PURPLE.getCode()), Colors.PURPLE.getCode()},
                {ColorPicker.id(Colors.CYAN.getCode()), Colors.CYAN.getCode()},
                {ColorPicker.id(Colors.WHITE.getCode()), Colors.WHITE.getCode()},
        };
    }

    @DataProvider
    public Object[][] wrongIdProvider(){
        return new Object[][]{
                {(byte) 'A', Colors.WHITE.getCode() + "#" + ColorPicker.resetColor()},
                {(byte) 'B', Colors.WHITE.getCode() + "#" + ColorPicker.resetColor()},
                {(byte) 'a', Colors.WHITE.getCode() + "#" + ColorPicker.resetColor()},
                {(byte) '@', Colors.WHITE.getCode() + "#" + ColorPicker.resetColor()},
                {(byte) '#', Colors.WHITE.getCode() + "#" + ColorPicker.resetColor()},
                {(byte) '&', Colors.WHITE.getCode() + "#" + ColorPicker.resetColor()},
        };
    }

    @Test(dataProvider = "colorIdProvider")
    public void idShouldReturnProperIdValue(byte idGetter, byte id){
        assertEquals(idGetter, id);
    }

    @Test(dataProvider = "colorCodesProvider")
    public void printHashShouldPrintCorrectMessage(byte idGetter, String code){
        assertEquals(ColorPicker.printHash(idGetter), code + "#" + ColorPicker.resetColor());
    }

    @Test(dataProvider = "wrongIdProvider")
    public void printHashWithBadParameterShouldReturnWhiteHash(byte wrongInput, String whiteColorCode){
        assertEquals(ColorPicker.printHash(wrongInput), whiteColorCode);
    }

}
