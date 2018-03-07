package com.codecool.spaceship;

public class Shoot {
    public static char[][] generateLaser(char[][] matrix) {
        int[] shipPlace = Ship.getShipPos(matrix);
        int[] laserStartingPosition = new int[2];
        laserStartingPosition[0] = shipPlace[0] - 1;
        laserStartingPosition[1] = shipPlace[1];
        matrix[laserStartingPosition[0]][laserStartingPosition[1]] = '^';
        return matrix;
    }
}