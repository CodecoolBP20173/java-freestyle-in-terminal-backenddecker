package com.codecool.spaceship;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean error;
        if(args.length == 0){
            System.out.println("Welcome to our game!");
        } else {
            System.out.println("Wanna play again?");
        }
        System.out.println("To start the game press 1!");
        System.out.println("To exit the game press 2!");
        do {
            error = false;
            try {
                System.out.print("Press a number: ");
                num = sc.nextInt();
                if (num < 1 || num > 2) {
                    error = true;
                    System.err.println("Choose an other one!");
                }
            } catch (InputMismatchException ex) {
                error = true;
                sc.nextLine();
                System.err.println("Not a number!");
            }
        } while (error);
        if(num == 1){
            Matrix.main();
        } else {
            System.out.println("Thanks for playing!");
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}



