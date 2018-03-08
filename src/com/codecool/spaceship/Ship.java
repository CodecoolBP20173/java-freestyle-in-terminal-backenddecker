package com.codecool.spaceship;

public class Ship {

    public static char[][] generateShip(char[][] matrix) {
        if(matrix[(matrix.length - 1) - 1][(matrix.length - 1) / 2] == ' ') {
            matrix[(matrix.length - 1) - 1][(matrix.length - 1) / 2] = 'A';
        } else {
            for(int index=0; index < matrix[(matrix.length - 1)].length; index++) {
                int randomCoordinate = (int) (Math.random() * (matrix.length - 3)) + 1;
                if(matrix[(matrix.length - 1) - 1][randomCoordinate] == ' '){
                    matrix[(matrix.length - 1) - 1][randomCoordinate] = 'A';
                    return matrix;
                }
            }
        }
        return matrix;
    }

    public static int[] getShipPos(char[][] matrix) {
        int[] shipPlace = new int[2];
        for (int i = 0; i < matrix[matrix.length - 2].length; i++) {
            if (matrix[matrix.length - 2][i] == 'A') {
                shipPlace[0] = matrix.length - 2;
                shipPlace[1] = i;
            }
        }
        return shipPlace;
    }


    public static char[][] moveShip(char[][] mtrx, int dir) {
        int[] shipPlace = getShipPos(mtrx);

        if (1 <= (shipPlace[1] + dir) && (shipPlace[1] + dir) <= mtrx[shipPlace[0]].length - 2) {
            mtrx[shipPlace[0]][shipPlace[1]] = ' ';
            mtrx[shipPlace[0]][shipPlace[1] + dir] = 'A';
        }
        return mtrx;
    }

}