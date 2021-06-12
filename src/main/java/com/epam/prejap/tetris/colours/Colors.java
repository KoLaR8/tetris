package com.epam.prejap.tetris.colours;

/**
 *
 */
enum Colors {
    RESET("\u001B[0m", (byte)1),
    RED("\u001B[30m", (byte)2),
    GREEN("\u001B[32m", (byte)3),
    YELLOW("\u001B[33m", (byte)4),
    BLUE("\u001B[34m", (byte)5),
    PURPLE("\u001B[35m", (byte)6),
    CYAN("\u001B[36m", (byte)7),
    WHITE("\u001B[37m", (byte)8);

    private final String asciCode;
    private final byte id;

    Colors(String asciCode, byte id){
        this.asciCode = asciCode;
        this.id = id;
    }

    String getCode(){
        return asciCode;
    }

    byte id(){return id;}

}
