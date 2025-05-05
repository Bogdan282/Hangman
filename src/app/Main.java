package app;

import java.util.Scanner;

public class Main {
    public static int wordNumber = (int) (Math.random() * GameWords.wordsPull.length);
    public static String Word = GameWords.wordsPull[wordNumber];
    public static String letter = "";
    public static int countTry = Word.length();
    public static boolean win = false;
    public static boolean loose = false;
    public static char[] Progress = new char[Word.length()];

    public static void main(String[] args) {
        String tryWord;
        System.out.println("Hangman by Alast0r V1");

        for(int i = 0; i < Progress.length; i++) {
            Progress[i] = 'X';
        }

        Scanner scn = new Scanner(System.in);

        int characterCount = Word.length();

        System.out.println("Вам нужно угадать слово с " + characterCount + " букв.");
        for(int i = 0; i < characterCount; i++) {
            System.out.print("X | ");
        }

        while(!win && !loose) {
            System.out.println();
            System.out.print("Введите букву: ");
            letter = scn.nextLine();
            if(letter.length() > 1) {
                tryWord = letter;
                if(tryWord.equals(Word)) {
                    System.out.println("Победа! Слово было: " + Word + ".");
                    win = true;
                } else{
                    --countTry;
                    if(countTry == 0) {
                        loose = true;
                        System.out.println("Вы проиграли.");
                    }
                }
            } else {
                GameWords.checkLetterIndex(letter);
                printProgress(Progress);
            }
        }
    }
    public static void printProgress(char[] Progress) {
        for(int i = 0; i < Progress.length; i++) {
            System.out.print(Progress[i] + " | ");
        }
    }
    public static boolean checkProgress(char[] Progress) {
        String ProgressString = "";
        boolean valid = false;
        for (int i = 0; i < Progress.length; i++) {
            ProgressString = ProgressString + Progress[i];
        }
        if (ProgressString.equalsIgnoreCase(Word)) {
            valid = true;
        }
        return valid;
    }
}