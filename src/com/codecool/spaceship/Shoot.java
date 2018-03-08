package com.codecool.spaceship;

public class Shoot {
    public static char[][] generateLaser(char[][] matrix) {
        int numberOfLasers = countLasers(matrix);

        if (numberOfLasers < 3){
            int[] shipPlace = Ship.getShipPos(matrix);
            int[] laserStartingPosition = new int[2];
            laserStartingPosition[0] = shipPlace[0] - 1;
            laserStartingPosition[1] = shipPlace[1];

            if (matrix[laserStartingPosition[0]][laserStartingPosition[1]] == 'o') {
                matrix[laserStartingPosition[0]][laserStartingPosition[1]] = ' ';
            } else {
                matrix[laserStartingPosition[0]][laserStartingPosition[1]] = '^';
            }
        }
        return matrix;
    }

    public static int countLasers(char[][] matrix) {
        int numberOfLasers = 0;

        for(int i = 1; i < matrix.length - 1; i ++){
            for(int j = 1; j < matrix.length - 1; j++) {
                if (matrix[i][j] == '^') {
                    numberOfLasers++;
                }
            }
        }
        return numberOfLasers;
    }

    public static int[][] getLaserPositions(char[][] matrix){
        int numberOfLasers = countLasers(matrix);
        int laserIndex = 0;
        int[][] laserPositins = new int[numberOfLasers][2];

        for(int i = 1; i < matrix.length - 1; i ++){
            for(int j = 1; j < matrix.length - 1; j++) {
                if (matrix[i][j] == '^') {
                    laserPositins[laserIndex][0] = i;
                    laserPositins[laserIndex][1] = j;
                    laserIndex++;
                }
            }
        }
        return laserPositins;
    }

    public static char[][] moveLasers(char[][] matrix){
        int[][] laserPositins = getLaserPositions(matrix);
        for (int[] laser: laserPositins) {
            if (laser[0] > 1){
                if ((matrix[laser[0] - 1][laser[1]]) == 'o') {
                    matrix[laser[0]][laser[1]] = ' ';
                    matrix[laser[0] - 1][laser[1]] = ' ';
                } else {
                    matrix[laser[0]][laser[1]] = ' ';
                    matrix[laser[0] - 1][laser[1]] = '^';
                }
            } else {
                matrix[laser[0]][laser[1]] = ' ';
            }
        }
        return matrix;
    }
}