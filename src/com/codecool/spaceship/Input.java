package com.codecool.spaceship;

import java.io.*;

public class Input {
    private static Character tryToRead() {
        try {
            if (System.in.available() > 0) {
                return (char)System.in.read();
            }
        }
        catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return null;
    }

    public static int getDirectionForShip() {
        Character userInput = tryToRead();
        if (userInput != null){
            if (userInput == 'a' || userInput == '4') {
                return -1;
            } else if (userInput == 'd' || userInput == '6') {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;

    }
}