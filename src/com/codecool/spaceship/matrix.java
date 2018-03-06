package com.codecool.spaceship;
import java.util.*;

public class matrix {


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
        matrix[(matrix.length - 1) - 1][(matrix.length - 1) / 2] = 'A';
        return matrix;
    }


    public static void resetMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                matrix[i][j] = ' ';
            }
        }

    }

    public static void drawMatrix(char[][] matrix) {
        System.out.print("\033[H\033[2J");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }


    public static void main() {
        char[][] matrix;
        matrix = generateMatrix();
        drawMatrix(matrix);
        while(true) {
            matrix = ship.moveShip(matrix, 1);
            drawMatrix(matrix);
            sleep(1000);
        }


    }
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception e){

        }

    }
}
