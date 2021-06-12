package com.epam.prejap.tetris.colours;

import java.util.Random;

/**
 *
 */
public class ColorPicker {
    public static String chooseRandomColor(){
        var random = new Random();
        var index = random.nextInt(Colors.values().length);
        for(var i = 0; i< Colors.values().length; i++){
            if(index == i){
                return Colors.values()[i].getCode();
            }
        }
        return Colors.RESET.getCode();
    }

    public static String resetColor(){
        return Colors.RESET.getCode();
    }

    public static byte id(String color) {
        for(var colors : Colors.values()){
            if(colors.getCode().equals(color)){
                return colors.id();
            }
        }
        return Colors.BLUE.id();
    }

    public static String printHash(byte id){
        String color = Colors.WHITE.getCode();
        for(var colors: Colors.values()){
            if(colors.id() == id){
                color = colors.getCode();
            }
        }
        return color + "#" + Colors.RESET.getCode();
    }
}
