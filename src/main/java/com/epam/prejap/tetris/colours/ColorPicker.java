package com.epam.prejap.tetris.colours;

import java.util.Random;

/**
 *  Purpose of this class is to menage different colors  behaviour provided from enum Colors.
 * @author Wojciech Kolarczyk
 * @see Colors
 */
public class ColorPicker {

    /**
     * Pick random color from all available colors from enum Colors.
     * @return  String with random color ascii code.
     */
    public static String chooseRandomColor(){
        var random = new Random();
        var index = random.nextInt(Colors.values().length);
        for(var i = 0; i< Colors.values().length; i++){
            if(index == i){
                return Colors.values()[i].getCode();
            }
        }
        return resetColor();
    }

    /**
     * Reset color to default white color.
     * @return asci code of ascii reset code.
     */
    public static String resetColor(){
        return Colors.RESET.getCode();
    }

    /**
     * Used to change '1' to block's color id in block image.
     * @param color name of color.
     * @return  id of color.
     */
    public static byte id(String color) {
        for(var colors : Colors.values()){
            if(colors.getCode().equals(color)){
                return colors.id();
            }
        }
        return Colors.WHITE.id();
    }

    /**
     * Prints "#" in color of it's block color field.
     * @param id color id.
     * @return String with colored "#".
     */
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
