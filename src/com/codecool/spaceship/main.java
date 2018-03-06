package com.codecool.spaceship;

import java.util.*;

import com.codecool.spaceship.matrix;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean error;

        System.out.println("Welcome to our game!");
        System.out.println("To start the game press 1!");
        do {
            error = false;
            try {
                System.out.print("Press a number: ");
                num = sc.nextInt();
                if (num != 1) {
                    error = true;
                    System.err.println("Choose an other one!");
                }
            } catch (InputMismatchException ex) {
                error = true;
                sc.nextLine();
                System.err.println("Not a number!");
            }
        } while (error);

        matrix.main();
    }


}



