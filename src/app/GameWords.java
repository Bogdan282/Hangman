package app;

public class GameWords {
    public static String[] wordsPull = {"Писюн", "Стол", "Квадрат", "Дмитрий", "Клавиатура"};

    public static void checkLetterIndex(String letter) {
        boolean match = false;

        for(int i = 0; i < Main.Word.length(); i++) {
            if(letter.equalsIgnoreCase(String.valueOf(Main.Word.charAt(i)))) {
                System.out.println("Буква " + letter + " идёт под номером " + (i + 1) + ".");
                Main.Progress[i] = letter.charAt(0);
                match = true;
                if(Main.checkProgress(Main.Progress)) {
                    Main.win = true;
                    System.out.println("Победа! Слово было: " + Main.Word + ".");
                }
            }
        }
        if(!match) {
            Main.countTry--;
            System.out.println("Вы ошиблись. Осталось попыток: " + Main.countTry);
        } else if(Main.countTry == 0) {
            Main.loose = true;
            System.out.println("Вы проиграли.");
        }
    }
}
