package ru.geekbrains.JavaCoreForAndroid;

/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson3
 * Created 07.02.2021
 * v1.0
 */
public class FillArraySnake {

    // План:
    // создать метод fillArrayLikeSnake() на вход принимает размер массива по вертикали, по горизонтали
    // создать метод симпатично выводящий массив в консоль
    // создать метод main и вызвать в нем метод fillArrayLikeSnake() и printArr() как минимум 3 раза
    // первый раз для квадратного массива
    // второй раз для прямоугольного массива, где длина боле чем ширина (существенно)
    // третий раз для прямоугольного массива, где ширина существенно больше длины.
    public static void main(String[] args) {
        System.out.println("Прямоугольный массив 10 х 10");
        printArr(fillArrayLikeSnake(10, 10));
        System.out.println();
        System.out.println("Прямоугольный массив 10 х 4");
        printArr(fillArrayLikeSnake(10, 4));
        System.out.println();
        System.out.println("Прямоугольный массив 4 х 10");
        printArr(fillArrayLikeSnake(4, 10));
    }

    public static void printArr(int[][] arr) {
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                System.out.print(arr[y][x] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] fillArrayLikeSnake(int xSize, int ySize) {
        int arr[][] = new int[ySize][xSize];
        int currentValue = 1;
        int finalValue = xSize * ySize;
        int y = 0;
        int x = 0;
        int dx = 1; // приращение по x
        int dy = 0; // приращение по y
        double grad = 90.0;
        do {
            arr[y][x] = currentValue;
            currentValue++;
            if (y + dy < 0 || y + dy >= arr.length || x + dx < 0 || x + dx >= arr[y].length || arr[y + dy][x + dx] != 0) {
                grad += 90.0;
                dy = dx;
                dx = (int) Math.sin(Math.toRadians(grad)); // контроль приращения выполняется этой функцией.
            }
            y += dy;
            x += dx;
        } while (currentValue <= finalValue);
        return arr;
    }
}
