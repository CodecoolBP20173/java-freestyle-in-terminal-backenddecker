package com.codecool.spaceship;
import sun.nio.cs.ext.MacHebrew;

import java.util.*;

public class Asteroid {
    public static char[][] generateAsteroid(char[][] matrix) {
        int[] startPoint = new int[2];
        int firstCoordinate = 0;
        int secondCoordinate = 1;
        startPoint[firstCoordinate] = 1;
        int secondPos = (int)(Math.random() * (matrix.length - 3)) + 1;
        startPoint[secondCoordinate] = secondPos;
        matrix[startPoint[firstCoordinate]][startPoint[secondCoordinate]]= 'o';
        return matrix;
    }

    public static int[] getAsteroidPos(char[][] matrix){
        int[] asteroidPos = new int[2];

        for(int i = 1; i < matrix.length - 1; i ++){
            for(int j = 1; j < matrix.length - 1; j++) {
                if (matrix[i][j] == 'o') {
                    asteroidPos[0] = i;
                    asteroidPos[1] = j;
                }
            }
        }
        return asteroidPos;
    }

    public static char[][] moveAsteroid(char[][] matrix){
        int[] asteroidPos = getAsteroidPos(matrix);
        if(asteroidPos[0] < matrix.length - 2){
            matrix[asteroidPos[0]][asteroidPos[1]] = ' ';
            matrix[asteroidPos[0] + 1][asteroidPos[1]] = 'o';
        } else {
            matrix[asteroidPos[0]][asteroidPos[1]] = ' ';
            matrix = generateAsteroid(matrix);
        }

        return matrix;
    }
}
