package com.codecool.spaceship;

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


    public static void resetMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                matrix[i][j] = ' ';
            }
        }

    }

    private static void drawMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }


    public static boolean main() {
        char[][] matrix;
        boolean restart = true;
        matrix = generateMatrix();
        drawMatrix(matrix);
        int health = 3;
        while(health > 0) {
            matrix = Asteroid.generateAsteroid(matrix);
            matrix = Asteroid.moveAsteroid(matrix);
            int shipMovementDirection = Input.getDirectionForShip();
            matrix = Ship.moveShip(matrix, shipMovementDirection);
            Main.clearScreen();
            System.out.print("Health:" + health +"\r\n");
            drawMatrix(matrix);
            sleep(500);
            int[] shipData = Ship.getShipPos(matrix);
            int[][] asteroidData = Asteroid.getAsteroidPos(matrix);
            for (int[] asteroid: asteroidData) {
                if(shipData[0] == (asteroid[0] + 1) && shipData[1] == asteroid[1]){
                    matrix = Ship.generateShip(matrix);
                    drawMatrix(matrix);
                    health--;
                }
            }
        }
        System.out.println("\033[0;31m" + "You have been killed!" + "\033[0m");
        System.out.println();

        return restart;


    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {

        }

    }
}
