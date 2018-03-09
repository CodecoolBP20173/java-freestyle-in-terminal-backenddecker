package com.codecool.spaceship;

public class Shoot {

    public static int laserShots = 15;

    public static char[][] generateLaser(char[][] matrix) {
        int numberOfLasers = countLasers(matrix);

        if (numberOfLasers < 3 && laserShots > 0){
            int[] shipPlace = Ship.getShipPos(matrix);
            int[] laserStartingPosition = new int[2];
            laserStartingPosition[0] = shipPlace[0] - 1;
            laserStartingPosition[1] = shipPlace[1];

            if (matrix[laserStartingPosition[0]][laserStartingPosition[1]] == 'o') {
                matrix[laserStartingPosition[0]][laserStartingPosition[1]] = ' ';
            } else {
                matrix[laserStartingPosition[0]][laserStartingPosition[1]] = '^';
            }
            laserShots--;
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
        int[][] laserPositions = new int[numberOfLasers][2];

        for(int i = 1; i < matrix.length - 1; i ++){
            for(int j = 1; j < matrix.length - 1; j++) {
                if (matrix[i][j] == '^') {
                    laserPositions[laserIndex][0] = i;
                    laserPositions[laserIndex][1] = j;
                    laserIndex++;
                }
            }
        }
        return laserPositions;
    }

    public static char[][] moveLasers(char[][] matrix){
        int[][] laserPositions = getLaserPositions(matrix);

        for (int[] laserPosition: laserPositions) {
            int[] newLaserPosition = {laserPosition[0] - 1, laserPosition[1]};
            char characterInFrontOfLaser = matrix[newLaserPosition[0]][newLaserPosition[1]];
            char characterInPlaceOfLaser = matrix[laserPosition[0]][laserPosition[1]];

            if (laserPosition[0] > 1) {
                matrix[laserPosition[0]][laserPosition[1]] = ' ';
                char newCharacter = ' ';
                matrix = Matrix.changeCharacterInMatrix(matrix, laserPosition, newCharacter);

                if (characterInFrontOfLaser == 'o') {
                    matrix = Matrix.changeCharacterInMatrix(matrix, newLaserPosition, newCharacter);

                } else {
                    newCharacter = '^';
                    matrix = Matrix.changeCharacterInMatrix(matrix, newLaserPosition, newCharacter);
                }
                
            } else {
                char newCharacter = ' ';
                matrix = Matrix.changeCharacterInMatrix(matrix, laserPosition, newCharacter);
            }
        }
        return matrix;
    }
}