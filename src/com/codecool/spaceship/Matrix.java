package com.codecool.spaceship;

import java.util.Date;

public class Matrix {


    private static char[][] generateMatrix() {
        char[][] matrix = new char[19][19];

        int firstRow = 0;
        int firstCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i != matrix.length - 1) {
                matrix[firstRow][i] = '═';
            } else {
                matrix[firstRow][i] = '╗';
            }
            matrix[matrix.length - 1][i] = '═';
            if (i == 0 || i == matrix.length - 1) {
                if (i == 0) {
                    matrix[i][firstCol] = '╔';
                } else {
                    matrix[i][firstCol] = '╚';
                }
            } else {
                matrix[i][firstCol] = '║';
            }
            if (i == matrix.length - 1) {
                matrix[i][matrix.length - 1] = '╝';
            } else {
                matrix[i][matrix.length - 1] = '║';
            }
        }
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[i].length - 1; j++) {
                matrix[i][j] = ' ';
            }
        }
        matrix = Ship.generateShip(matrix);
        return matrix;
    }


    private static void drawMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'A'){
                    System.out.print("\033[0;37m" + matrix[i][j] + "\033[0m");
                } else if (matrix[i][j] == 'o') {
                    System.out.print("\033[0;33m" + matrix[i][j] + "\033[0m");
                } else if (matrix[i][j] == '^') {
                    System.out.print("\033[1;34m" + matrix[i][j] + "\033[0m");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static char[][] changeCharacterInMatrix(char[][] matrix, int[] position, char newCharacter) {
        int firstCoordinate = position[0];
        int secondCoordinate = position[1];
        matrix[firstCoordinate][secondCoordinate] = newCharacter;
        return matrix;
    }

    public static boolean main() {
        Date startTime = new Date();
        char[][] matrix;
        matrix = generateMatrix();
        drawMatrix(matrix);
        int health = 3;
        Shoot.laserShots = 15;
        while(health >= 0) {
            matrix = Asteroid.generateAsteroid(matrix);
            matrix = Asteroid.moveAsteroid(matrix);
            int input = Input.getUserInput();
            if (input == 1 || input == -1) {
                matrix = Ship.moveShip(matrix, input);
            } else if (input == 2) {
                matrix = Shoot.generateLaser(matrix);
            }
            matrix = Shoot.moveLasers(matrix);
            Main.clearScreen();
            System.out.print("Lives:" + health +"\r\n");
            System.out.print("Shots:" + Shoot.laserShots +"\r\n");
            drawMatrix(matrix);
            sleep(300);
            int[] shipData = Ship.getShipPos(matrix);
            int[][] asteroidData = Asteroid.getAsteroidPositions(matrix);
            for (int[] asteroid: asteroidData) {
                if(shipData[0] == (asteroid[0] + 1) && shipData[1] == asteroid[1]){
                    health--;
                    if(health >= 0){
                        matrix = Ship.generateShip(matrix);
                        drawMatrix(matrix);
                    }
                }
            }
        }
        Date endTime = new Date();
        int secondsPlayed = (int)((endTime.getTime() - startTime.getTime())/1000);
        System.out.println("\033[0;31m" + "You have been killed!" + "\033[0m");
        System.out.printf("You have survived: %d seconds", secondsPlayed);

        return true;


    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {

        }

    }
}
