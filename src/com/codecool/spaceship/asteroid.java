package com.codecool.spaceship;
import java.util.Random;

public class asteroid {
    public static char[][] generateAsteroid(char[][] matrix) {
        int[] startPoint = new int[2];
        int firstCoordinate = 0;
        int secondCoordinate = 1;
        startPoint[firstCoordinate] = 1;
        Random generator = new Random();
        startPoint[secondCoordinate] = generator.nextInt(10) + 1;
        matrix[startPoint[firstCoordinate]][startPoint[secondCoordinate]]= '⎊';
        return matrix;
    }
}
