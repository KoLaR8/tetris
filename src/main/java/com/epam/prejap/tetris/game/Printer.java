package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.colours.ColorPicker;

import java.io.PrintStream;

public class Printer {

    private final PrintStream out;

    public Printer(PrintStream out) {
        this.out = out;
    }

    void draw(byte[][] grid, String color) {
        clear();
        border(grid[0].length);

        for (byte[] bytes : grid) {
            startRow();
            out.print(color);
            for (byte aByte : bytes) {
                print(aByte);
            }
            out.print(ColorPicker.resetColor());
            endRow();
        }

        border(grid[0].length);
    }

    void clear() {
        out.print("\u001b[2J\u001b[H");
    }

    void print(byte dot) {
        out.format(dot == 0 ? " " : ColorPicker.printHash(dot));
    }

    void startRow() {
        out.print("|");
    }

    void endRow() {
        out.println("|");
    }

    void border(int width) {
        out.println("+" + "-".repeat(width) + "+");
    }

}
