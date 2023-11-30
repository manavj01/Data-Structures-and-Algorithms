package com.dsa.utility;

import java.util.*;
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please, enter matrix size: ");
        int size = in.nextInt();
        double[][] matrix = generateMatrix(size);

        System.out.println("How you want to rotate matrix:" + System.lineSeparator() +
                "\t1 - 90" + System.lineSeparator() +
                "\t2 - 180" + System.lineSeparator() +
                "\t3 - 270");
        int mode = in.nextInt();

        System.out.println(System.lineSeparator() + "Base matrix:" + System.lineSeparator());
        printMatrixToConsole(matrix);
        System.out.println();

        if (rotateMatrix(matrix, mode)) {
            printMatrixToConsole(matrix);
        }
    }

    private static double[][] generateMatrix(int size) {
        double[][] matrix = new double[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = Double.valueOf(Integer.toString(i) + "."
                        + Integer.toString(j));
            }
        }
        return matrix;
    }

    private static void printMatrixToConsole(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean rotateMatrix(double[][] matrix, int mode) {
        switch (mode) {
            case 1:
                System.out.println("90 degrees rotated:" + System.lineSeparator());
               matrix= rotate90(matrix);
                break;
            case 2:
                System.out.println("180 degrees rotated:" + System.lineSeparator());
                matrix=rotate180(matrix);
                break;
            case 3:
                System.out.println("270 degrees rotated:" + System.lineSeparator());
                matrix=rotate270(matrix);
                break;
            default:
                System.out.println("You selected non-existing mode!");
                return false;
        }
        return true;
    }

    public static double[][] rotate90(double[][] matrix) {
        int n = matrix.length; // Assuming the matrix is n x n
        double[][] rotatedMatrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[i][j] = matrix[n - 1 - j][i];
            }
        }
        return rotatedMatrix;

    }

    public static double[][] rotate180(double[][] matrix) {
        int n = matrix.length; // Assuming the matrix is n x n
        double[][] rotatedMatrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[i][j] = matrix[n - 1 - i][n - 1 - j];
            }
        }
        return rotatedMatrix;
    }

    public static double[][] rotate270(double[][] matrix) {
        int n = matrix.length; // Assuming the matrix is n x n
        double[][] rotatedMatrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[i][j] = matrix[j][n - 1 - i];
            }
        }
        return rotatedMatrix;

    }

}