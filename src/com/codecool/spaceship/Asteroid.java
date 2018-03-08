package com.codecool.spaceship;



public class Asteroid {
    public static char[][] generateAsteroid(char[][] matrix) {
        int[] startPoint = new int[2];
        int firstCoordinate = 0;
        int secondCoordinate = 1;
        startPoint[firstCoordinate] = 1;
        startPoint[secondCoordinate] = (int) (Math.random() * (matrix.length - 3)) + 1;
        matrix[startPoint[firstCoordinate]][startPoint[secondCoordinate]] = 'o';
        return matrix;
    }

    private static int countAsteroids(char[][] matrix) {
        int numberOfAsteroids = 0;

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length - 1; j++) {
                if (matrix[i][j] == 'o') {
                    numberOfAsteroids++;
                }
            }
        }
        return numberOfAsteroids;
    }

    public static int[][] getAsteroidPositions(char[][] matrix) {
        int numberOfAsteroids = countAsteroids(matrix);
        int asteroidIndex = 0;
        int[][] asteroidPositions = new int[numberOfAsteroids][2];

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length - 1; j++) {
                if (matrix[i][j] == 'o') {
                    asteroidPositions[asteroidIndex][0] = i;
                    asteroidPositions[asteroidIndex][1] = j;
                    asteroidIndex++;
                }
            }
        }
        return asteroidPositions;
    }

    public static char[][] moveAsteroid(char[][] matrix) {
        int[][] asteroidPositions = getAsteroidPositions(matrix);

        for (int[] asteroidPosition: asteroidPositions) {
            int[] newAsteroidPosition = {asteroidPosition[0] + 1, asteroidPosition[1]};
            char characterInFrontOfAsteroid = matrix[newAsteroidPosition[0]][newAsteroidPosition[1]];
            char characterInPlaceOfAsteroid = matrix[asteroidPosition[0]][asteroidPosition[1]];

            if (asteroidPosition[0] < matrix.length - 2) {
                char newCharacter = ' ';
                matrix = Matrix.changeCharacterInMatrix(matrix, asteroidPosition, newCharacter);

                if (characterInFrontOfAsteroid == '^') {
                    matrix = Matrix.changeCharacterInMatrix(matrix, newAsteroidPosition, newCharacter);
                    
                } else {
                    newCharacter = 'o';
                    matrix = Matrix.changeCharacterInMatrix(matrix, newAsteroidPosition, newCharacter);
                }
                
            } else {
                char newCharacter = ' ';
                matrix = Matrix.changeCharacterInMatrix(matrix, asteroidPosition, newCharacter);
                matrix = generateAsteroid(matrix);
            }
        }
        return matrix;
    }
}
