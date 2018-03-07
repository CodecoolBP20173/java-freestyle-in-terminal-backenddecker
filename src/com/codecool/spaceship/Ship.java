package com.codecool.spaceship;

public class Ship {

    public static int[] getShipPos(char[][] matrix){
        int[] shipPlace = new int[2];
        for(int i = 0; i < matrix[matrix.length - 2].length; i ++){
            if(matrix[matrix.length - 2][i] == 'A'){
                shipPlace[0] = matrix.length - 2;
                shipPlace[1] = i;
            }
        }
        return shipPlace;
    }



    public static char[][] moveShip(char[][] mtrx, int dir){
        int[] shipPlace = getShipPos(mtrx);

        if (0 <= (shipPlace[1] + dir) && (shipPlace[1] + dir) <= mtrx[shipPlace[0]].length - 2) {
            mtrx[shipPlace[0]][shipPlace[1]] = ' ';
            mtrx[shipPlace[0]][shipPlace[1] + dir] = 'A';
        }
        return mtrx;
    }

}