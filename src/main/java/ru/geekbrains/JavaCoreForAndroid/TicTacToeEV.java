package ru.geekbrains.JavaCoreForAndroid;

import java.util.Random;
import java.util.Scanner;

/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson1
 * Created 04.02.2021
 * v2.0
 */
public class TicTacToeEV {
    private static char[][] field;                                  // поле
    private static final char DOT_HUMAN = 'X';                      // символ хода человека
    private static final char DOT_AI = 'O';                         // символ хода машины
    private static final char DOT_EMPTY = '.';                      // обозначение пустой ячейки
    private static final Scanner SCANNER = new Scanner(System.in);  // я так понял константой мы фиксируем тип, так как
    private static final Random RANDOM = new Random();              // ссылочный тип не может зафиксировать значение.
    private static int fieldSizeX;                                  // размер поля по оси X (горизонталь)
    private static int fieldSizeY;                                  // размер поля по оси Y (Вертикаль)

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
        fieldSizeX = 3;
        fieldSizeY = 3;
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

    //метод проверки на получение выигрышной комбинации
    // TODO переделать метод проверки выигрыша полностью, сделать его универсальным.
    private static boolean checkWin(char c) {
        // hor
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
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
