import java.util.Scanner;

public class Task1 {
    private String txt1;
    private String txt2;
    private String newString;
    private String helpStr;
    private int counter = 0;

    public Task1(String txt1, String txt2) {
        this.txt1 = txt1;
        this.txt2 = txt2;
    }

    public int searchingBold() {
        for(int i = 0; i < txt1.length()-2; i++) {
            if(txt1.charAt(i) == '(' && txt1.charAt(i+1) == 'Ж' && txt1.charAt(i+2) == ')') {
                counter++;
            }
        }

        return counter;
    }

    public String replace() {
        //(6)Сдача (5)работы по (4)ООП.
        for(int i = 0; i < txt2.length()-2; i++) {
            if(txt2.charAt(i) == '(' && ((int)txt2.charAt(i+1) >= 48 && (int)txt2.charAt(i+1) <= 57) && txt2.charAt(i+2) == ')')
                txt2 = txt2.replace(txt2.charAt(i+1), '7');
        }

        return txt2;
    }

    public String newStr() {
        newString = "(С)(12)Н(П)(12)а улице хорошая погода!";

        return newString;
    }

    public String words() {
        //(П)Здравствуйте, мои (О)7 и 1 любимых друзей! (О)(Ж)5 из вас я знаю уже (П)довольно (О)(Ж)давно, целых 4 года.
        String format = " ";
        int j = 0;
        for (int i = 0; i < txt1.length(); i++)
            if (((int) txt1.charAt(i) >= 48 && (int) txt1.charAt(i) <= 57) && ((int) txt1.charAt(i - 1) == 32 || txt1.charAt(i - 1) == ')') && ((int) txt1.charAt(i + 1) == 32
            || txt1.charAt(i + 1) == '.'))
                for (j = i-1; j > 0; j--)
                    if (txt1.charAt(j) == ')' && (txt1.charAt(j - 1) == 'С' || txt1.charAt(j - 1) == 'П' || txt1.charAt(j - 1) == 'Ж' || txt1.charAt(j - 1) == 'О' ||
                    ((int)txt1.charAt(j - 1) >= 48 && (int)txt1.charAt(j - 1) <= 57) && txt1.charAt(j - 2) == '(')) {
                        format += txt1.charAt(j);
                        format += txt1.charAt(j-1);
                        format += txt1.charAt(j-2);
                        format += ' ';
                        if(txt1.charAt(j-3) != ')' && txt1.charAt(j-4) != 'С' && txt1.charAt(j-4) != 'П' && txt1.charAt(j-4) != 'Ж' && txt1.charAt(j-4) != 'О')
                            break;
                    }
        String resultFormat = new StringBuffer(format).reverse().toString();

        return resultFormat;
    }
}