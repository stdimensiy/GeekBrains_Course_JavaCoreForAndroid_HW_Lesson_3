package ru.geekbrains.JavaCoreForAndroid;

import java.util.Random;
import java.util.Scanner;

/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 *
 * HomeWork for lesson3
 * Created 05.02.2021
 * v1.0
 */
public class TicTacToeEV {
    private static char[][] field;                                  // поле
    private static final char DOT_HUMAN = 'X';                      // символ хода человека
    private static final char DOT_AI = 'O';                         // символ хода машины
    private static final char DOT_EMPTY = '.';                      // обозначение пустой ячейки
    private static final Scanner SCANNER = new Scanner(System.in);  // я так понял константой мы фиксируем тип, так как
    private static final Random RANDOM = new Random();              // ссылочный тип не может зафиксировать значение.
    private static int fieldSizeX = 5;                                  // размер поля по оси X (горизонталь)
    private static int fieldSizeY = 5;                                  // размер поля по оси Y (Вертикаль)
    private static int lenWinSize = 4;                                  // условие победы n-элементов в ряд


    public static void main(String[] args) {
        while (true) {                                              // формируем бесконечный игровой цикл
            initField();
            printField();

            while (true) {
                humanTurn();
                printField();
                if (checkGame(DOT_HUMAN, "Вы победили!!!")) break;
                aiTurn();
                printField();
                if (checkGame(DOT_AI, "Я победил, Искусственный Интеллект поработит мир!!")) break;
            }
            System.out.println("Сыграем еще?");
            if (!SCANNER.next().equals("y")) {
                SCANNER.close();
                break;
            }
        }

    }

    // метод инициализации игрового поля
    // TODO перенести инициализацию значений переменных класса из метода в класс
    private static void initField() {
        //fieldSizeX = 3;
        //fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    // метод вывода визуализации поля в консоль
    // TODO сделать поле более удобным и заменить цифры по вертикали буквами
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    // метод хода человека
    // TODO заменить ввод цифры вертикальной координаты на букву
    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.print("Введите координаты хода Х и У от 1 до 3 через пробел ->");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
    }

    // метод проверки свободна ли ячейка
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    // метод проверки попал ли пользователь вообще в поле
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    // метод проверки игры
    // TODO при замене логики проверить, нужно ли тут что либо менять
    private static boolean checkGame(char dot, String s) {

        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья !!!");
            return true;
        }
        return false;
    }

    /* метод проверки на получение выигрышной комбинации
    / Теперь метод универсальный и применим для поля любого размера с выигрышной комбинацией
    / любой длины не длиннее чем само поле */
    private static boolean checkWin(char c) {
        //проверка наличия победной комбинации по горизонтали
        for (int y=0; y< field.length - 1; y++){
            for (int x=0; x < field[y].length - (lenWinSize-1); x++){
                if (field[y][x] == c){
                    int z = 1;
                    do {
                        if(field[y][x+z] != c){
                            break;
                        } else {
                            z++;
                            if (z >= lenWinSize) return true;
                        }
                    } while(true);
                }
            }
        }

        //проверка наличия победной комбинации по вертикали
        for (int y=0; y < field.length - (lenWinSize-1); y++){
            for (int x=0; x < field[y].length-1; x++){
                if (field[y][x] == c){
                    int z = 1;
                    do {
                        if(field[y+z][x] != c){
                            break;
                        } else {
                            z++;
                            if (z >= lenWinSize) return true;
                        }
                    } while (true);
                }
            }
        }

        //проверка наличия победной комбинации вдоль главной диагонали (лево верх - право низ)
        for (int y=0; y < field.length - (lenWinSize-1); y++){
            for (int x=0; x < field[y].length - (lenWinSize-1); x++){
                if (field[y][x] == c){
                    int z=1;
                    do {
                        if(field[y+z][x+z] != c){
                            break;
                        } else {
                            z++;
                            if (z >= lenWinSize) return true;
                        }
                    } while (true);
                }
            }
        }

        //проверка наличия победной комбинации вдоль второстепенной диагонали (право верх - лево низ)
        for (int y=0; y < field.length - (lenWinSize-1); y++){
            for (int x = lenWinSize-1; x < field[y].length; x++){
                if (field[y][x] == c){
                    int z=1;
                    do {
                        if(field[y+z][x-z] != c){
                            break;
                        } else {
                            z++;
                            if (z >= lenWinSize) return true;
                        }
                    } while (true);
                }
            }
        }
        return false;
    }

    // проверка на ситуация "ничья"
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    // ход машины (без особой логики, случайный напрочь
    // TODO переделать логику, попытаться научить играть комп в крестики нолики
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));

        field[y][x] = DOT_AI;
    }

}
