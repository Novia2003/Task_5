package ru.vsu.cs.novichikhin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int s = readFigureSize();
        checkFigureSize(s);
        printFigure(s);
    }

    static int readFigureSize() {
        System.out.print("Введите размер фигуры: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    static void checkFigureSize(int size) {
        if (size < 2 || size % 2 == 1) {
            System.out.println("Размер фигуры задан неверно (значение должно быть чётным и не меньше 2 )");
            System.exit(1);
        }
    }

    static void printFigure(int s) {
        int firstStar = s / 2;
        int n = firstStar;
        for (int i = 0; i < s; i++) {
            if (i == 0 || i == s - 1) {
                printFirstAndLastLine(i, firstStar);
            } else {
                if (i <= s / 2 - 2) {
                    printFirstLinesWithHashtag(s, i, firstStar);
                } else {
                    if (i >= s / 2 - 1 && i < s / 2 + 1) {
                        printCenterLinesWithOneStar(i, s, firstStar);
                    } else {
                        printSecondLinesWithHashtag(s, i, n);
                        n--;
                    }
                }
            }
        }
    }

    static void printFirstAndLastLine(int i, int firstStar) {
        if (i == 0) {
            printSpaces(firstStar);
            for (int a = 0; a < firstStar; a++) {
                System.out.print("*");
            }
            System.out.println();
        } else {
            for (int b = 0; b < firstStar; b++) {
                System.out.print("*");
            }
        }
    }

    static void printFirstLinesWithHashtag(int s, int i, int firstStar) {
        printSpaces(firstStar);
        System.out.print("*");
        for (int b = firstStar + 2; b < s - i; b++) {
            System.out.print("#");
        }
        System.out.print("*");
        System.out.println();
    }

    static void printCenterLinesWithOneStar(int i, int s, int firstStar) {
        if (i == s / 2 - 1) {
            printSpaces(firstStar);
        } else {
            printSpaces(firstStar - 1);
        }
        System.out.println("*");
    }

    static void printSpaces(int firstStar) {
        for (int j = 0; j < firstStar; j++) {
            System.out.print(" ");
        }
    }

    static void printSecondLinesWithHashtag(int s, int i, int n) {
        printSpaces(n - 2);
        System.out.print("*");
        for (int a = s / 2; a < i - 1; a++) {
            System.out.print("#");
        }
        System.out.print("*");
        System.out.println();
    }
}
