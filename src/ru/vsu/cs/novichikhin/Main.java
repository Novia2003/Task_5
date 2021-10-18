package ru.vsu.cs.novichikhin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int s = readFigureSize();
        checkFigureSize(s);
        char space = ' ';
        char star = '*';
        char hashtag = '#';
        int firstStar = s / 2 ;
        int n = firstStar;
        printFigure(s, firstStar, n, space, star, hashtag);
    }

    static int readFigureSize() {
        System.out.print("Введите размер фигуры ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    static void checkFigureSize(int size) {
        if (size < 2 || size % 2 == 1) {
            System.out.println("Размер фигуры задан неверно");
            System.exit(1);
        }
    }

    static void printFigure(int s, int firstStar,int n, char space, char star, char hashtag) {
        for (int i = 0; i < s; i++) {
            if (i == 0 || i == s - 1) {
                printFirstAndLastLine(i, firstStar, space, star);
            } else {
                if (i <= s / 2 - 2) {
                    printFirstLinesWithHashtag(s, i, firstStar,space, star, hashtag);
                } else {
                    if (i>=s/2-1 && i<s/2+1) {
                        printCenterLinesWithOneStar(i,s,firstStar,space,star);
                    } else {
                       printSecondLinesWithHashtag(s, i, n, space, star, hashtag);
                       n--;
                    }
                }
            }
        }
    }
    static void printFirstAndLastLine(int i, int firstStar, char space, char star) {
        if (i == 0) {
           printSpaces(firstStar, space);
            for (int a = 0; a < firstStar; a++) {
                System.out.print(star);
            }
            System.out.println();
        } else {
            for (int b = 0; b < firstStar; b++) {
                System.out.print(star);
            }
        }
    }
    static void printFirstLinesWithHashtag (int s,int i, int firstStar, char space, char star, char hashtag) {
        printSpaces(firstStar, space);
        System.out.print(star);
        for (int b = firstStar + 2; b < s-i; b++) {
            System.out.print(hashtag);
        }
        System.out.print(star);
        System.out.println();
    }
    static void printCenterLinesWithOneStar (int i, int s, int firstStar, char space, char star) {
       if (i == s/2-1) {
           printSpaces(firstStar, space);
       } else {
           printSpaces(firstStar - 1, space);
       }
        System.out.println(star);
    }
    static void printSpaces (int firstStar, char space) {
        for (int j = 0; j < firstStar; j++) {
            System.out.print(space);
        }
    }

    static void printSecondLinesWithHashtag (int s,int i, int n, char space, char star, char hashtag) {
            printSpaces(n-2, space);
            System.out.print(star);
            for (int a = s / 2; a < i - 1; a++) {
                System.out.print(hashtag);
            }
            System.out.print(star);
            System.out.println();

        }
    }
