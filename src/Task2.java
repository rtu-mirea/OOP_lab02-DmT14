import java.util.Scanner;

public class Task2 {
    private String list;
    Scanner in = new Scanner(System.in);

    public Task2(String list) {
        this.list = list;
    }

    public void fillIn() {
        System.out.print("Введите фамилию и зарплату сотрудника (пример: Иванов, 10000.): ");
        String newE = in.nextLine();

        int maxIndex = 0;
        String a = "";

        for(int i = 0; i < list.length() - 1; i++)
            if(list.charAt(i) == '.' && i > maxIndex)
                maxIndex = i;

        a += list.charAt(maxIndex+2);
        a += list.charAt(maxIndex+3);
        int b = Integer.parseInt(a) + 1;

        if(b < 10)
            list += " 0";
        else
            list += ' ';
        list += String.valueOf(b);
        list += ", ";
        list += newE;

        System.out.println("Список после добавления: " + list);
    }

    public void deleteEmp() {
        //01, Петров, 14000. 02, Сидоров, 4000. 08, Викторов, 40001. 11, Мельтюхов, 3000. 95, Дмитриев, 500000.
        System.out.print("Введите код сотрудника, которого нужно удалить: ");
        String code = in.nextLine();

        StringBuffer sb = new StringBuffer(list);
        for(int i = 0; i < list.length(); i++) {
            if (list.charAt(i) == code.charAt(0) && list.charAt(i + 1) == code.charAt(1)) {
                for (int j = i; list.charAt(j) != '.'; j++)
                    sb.delete(i, i + 1);
                sb.delete(i, i+2);
            }
        }

        System.out.println("Новая строка: " + sb);
        list = String.valueOf(sb);
    }

    public void threeZero() {
        //01, Петров, 14000. 02, Сидоров, 4000. 08, Викторов, 40001. 11, Мельтюхов, 3000. 95, Дмитриев, 500000.
        StringBuffer sb = new StringBuffer(list);

        sb.insert(0, "000");
        for(int i = 0; i < list.length(); i++)
            if(sb.charAt(i) == '.')
                sb.insert(i+2, "000");

        System.out.println("Новая строка: " + sb);
        list = String.valueOf(sb);
    }
}
