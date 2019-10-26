import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task3 {
    Scanner in = new Scanner(System.in);
    private static String REGEX;
    private static String REPLACE;

    public void regular() {
        System.out.print("Введите строку: ");
        String str = in.nextLine();

        if(str.matches("^(\\d)\\1$"))
            System.out.println("Строка состоит из двух одинаковых цифр.");
        else
            System.out.println("Строка не состоит из двух одинаковых цифр.");
    }

    public void replaceSymbol() {
        //Привет, как7дела 6?55 666
        System.out.print("Введите строку: ");
        String str = in.nextLine();

        REGEX = "(\\d)\\1\\s";
        REPLACE = "* ";

        Pattern p = Pattern.compile(REGEX);

        Matcher m = p.matcher(str);
        str = m.replaceAll(REPLACE);
        System.out.print("Результат замены: " + str + "\n");
    }
}

