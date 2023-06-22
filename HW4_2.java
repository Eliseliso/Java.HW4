/*
Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа могут быть отрицательными.
*/

import java.util.Deque;
import java.util.LinkedList;

public class HW4_2 {
    public static void main(String[] args) {
        Deque<Integer> num1 = new LinkedList<>();
        num1.add(3);
        num1.add(2);
        num1.add(1);

        Deque<Integer> num2 = new LinkedList<>();
        num2.add(5);
        num2.add(4);
        num2.add(3);

        Deque<Integer> result = add(num1, num2);
        System.out.println(result);
    }

    private static Deque<Integer> add(Deque<Integer> num1, Deque<Integer> num2) {
        Deque<Integer> result = new LinkedList<>();

        int carry = 0;

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int digit1 = num1.isEmpty() ? 0 : num1.remove();
            int digit2 = num2.isEmpty() ? 0 : num2.remove();

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            result.addFirst(digit);
        }

        return result;
    }
}