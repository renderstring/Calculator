import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        String expression = scan.nextLine();

        String result = calc(expression);
        System.out.print("Результат: " + result);

    }

    public static String calc(String input) {

        String result;

        String[] elements = input.split(" ");

        try {
            int el1 = Integer.parseInt(elements[0]);
            int el2 = Integer.parseInt(elements[2]);
            char operation = elements[1].charAt(0);

            if (elements.length != 3) {
                throw new RuntimeException("Неправильное количество элементов");
            }

            if ((el1 < 1 || el1 > 10) || (el2 < 1 || el2 > 10)) {
                throw new RuntimeException("Нельзя использовать числа меньше 1 и больше 10");
            }

            result = switch (operation) {
                case '+' -> String.valueOf(el1 + el2);
                case '-' -> String.valueOf(el1 - el2);
                case '*' -> String.valueOf(el1 * el2);
                case '/' -> String.valueOf(el1 / el2);
                default -> throw new RuntimeException("Неправильная операция");
            };
        } catch (NumberFormatException e) {
            throw new RuntimeException("Неправильный формат");
        }

        return result;
    }
}