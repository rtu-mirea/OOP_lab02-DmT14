import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        Task1 task1;
        Task2 task2;
        Task3 task3;

        printMenu();
        int n = 1;

        while (n >= 1 && n < 4) {
            n = in.nextInt();
            switch (n) {
                case 1:
                    in = new Scanner(System.in);
                    System.out.println("Введите 2 предложения, после каждого нажмите Enter: ");

                    String text1 = in.nextLine();
                    String text2 = in.nextLine();

                    task1 = new Task1(text1, text2);

                    System.out.println("Число жирных начертаний 1-го предложения: " + '\t' + task1.searchingBold());
                    System.out.println("Измененный шрифт 2-го предложения: " + '\t' + task1.replace());
                    System.out.println("Новое сформированное предложение: " + '\t' + task1.newStr());
                    System.out.println("Форматирование целых чисел: " + '\t' + task1.words());
                    printMenu();
                    break;
                case 2:
                    in = new Scanner(System.in);
                    System.out.print("Введите список сотрудников: ");

                    String list = in.nextLine();

                    task2 = new Task2(list);

                    task2.fillIn();
                    task2.deleteEmp();
                    task2.threeZero();
                    printMenu();
                    break;
                case 3:
                    in = new Scanner(System.in);
                    task3 = new Task3();

                    task3.regular();
                    task3.replaceSymbol();
                    printMenu();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nВыберите действие: ");

        System.out.println("1. Задание 1");
        System.out.println("2. Задание 2");
        System.out.println("3. Задание 3");
        System.out.println("4. Выйти из программы");
    }
}