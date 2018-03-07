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

    public static int countAsteroids(char[][] matrix) {
        int numberOfAsteroids = 0;

        for(int i = 1; i < matrix.length - 1; i ++){
            for(int j = 1; j < matrix.length - 1; j++) {
                if (matrix[i][j] == 'o') {
                    numberOfAsteroids++;
                }
            }
        }
        return numberOfAsteroids;
    }

    public static int[][] getAsteroidPos(char[][] matrix){
        
        int numberOfAsteroids = countAsteroids(matrix);

        int asteroidIndex = 0;

        int[][] asteroidPos = new int[numberOfAsteroids][2];

        for(int i = 1; i < matrix.length - 1; i ++){
            for(int j = 1; j < matrix.length - 1; j++) {
                if (matrix[i][j] == 'o') {
                    asteroidPos[asteroidIndex][0] = i;
                    asteroidPos[asteroidIndex][1] = j;
                    asteroidIndex++;
                }
            }
        }
        return asteroidPos;
    }

    public static char[][] moveAsteroid(char[][] matrix){
        int[][] asteroidPos = getAsteroidPos(matrix);
        for (int[] asteroid: asteroidPos) {
            if (asteroid[0] < matrix.length - 2){
                matrix[asteroid[0]][asteroid[1]] = ' ';
                matrix[asteroid[0] + 1][asteroid[1]] = 'o';
            } else {
                matrix[asteroid[0]][asteroid[1]] = ' ';
                matrix = generateAsteroid(matrix);
            }
        }

        return matrix;
    }
}
