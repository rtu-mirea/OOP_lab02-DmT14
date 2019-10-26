import java.util.Scanner;

public class Task2 {
    private String list;
    Scanner in = new Scanner(System.in);

    public Task2(String list) {
        this.list = list;
    }

    public void fillIn() {
        System.out.print("Введите номер, фамилию и зарплату сотрудника (пример: 04, Иванов, 10000): ");
        StringBuffer sb = new StringBuffer(list);
        String newE = in.nextLine();

        String x = "";
        String strNum = "";
        int intNum = 0;
        int a = 0;
        int b = 0;

        x += list.charAt(0);
        x += list.charAt(1);
        a = Integer.parseInt(x);

        outer: while(true) {
            strNum = "";
            strNum += newE.charAt(0);
            strNum += newE.charAt(1);
            intNum = Integer.parseInt(strNum);

            for (int i = 0; i < list.length() - 1; i++) {
                if (list.charAt(i) == '.') {
                    x = "";
                    x += list.charAt(i + 2);
                    x += list.charAt(i + 3);
                    b = Integer.parseInt(x);
                }

                if (i == list.length() - 2 && a < intNum) {
                    sb.insert(i, ". " + newE);
                    break outer;
                }

                if (a < intNum && b > intNum) {
                    sb.insert(i, ". " + newE);
                    break outer;
                }
                else if (a == intNum || b == intNum) {
                    System.out.print("Введенный номер уже занят, повторите ввод: ");
                    newE = in.nextLine();
                    break;
                }
                else a = b;
            }
        }

        list = String.valueOf(sb);
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

        System.out.println("Список после удаления: " + sb);
        list = String.valueOf(sb);
    }

    public void threeZero() {
        //01, Петров, 14000. 02, Сидоров, 4000. 08, Викторов, 40001. 11, Мельтюхов, 3000. 95, Дмитриев, 500000.
        StringBuffer sb = new StringBuffer(list);

        sb.insert(0, "000");
        for(int i = 0; i < list.length(); i++)
            if(sb.charAt(i) == '.')
                sb.insert(i+2, "000");

        System.out.println("Список с тремя нолями в номере: " + sb);
        list = String.valueOf(sb);
    }
}
