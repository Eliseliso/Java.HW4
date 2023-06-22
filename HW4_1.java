/*
Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка
*/

import java.util.Deque;
import java.util.LinkedList;

public class HW4_1 {
    public static void main(String[] args) {
        Deque<Integer> num1 = new LinkedList<>();
        num1.add(3);
        num1.add(2);
        num1.add(1);

        Deque<Integer> num2 = new LinkedList<>();
        num2.add(5);
        num2.add(4);
        num2.add(3);

        Deque<Integer> result = multiply(num1, num2);
        System.out.println(result);
    }

    private static Deque<Integer> multiply(Deque<Integer> num1, Deque<Integer> num2) {
        Deque<Integer> result = new LinkedList<>();

        int carry = 0;
        int multiplier = 1;

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int digit1 = num1.isEmpty() ? 0 : num1.remove();
            int digit2 = num2.isEmpty() ? 0 : num2.remove();

            int product = (digit1 * digit2) + carry;
            carry = product / 10;
            int digit = product % 10;

            result.addFirst(digit * multiplier);
            multiplier *= 10;
        }

        return result;
    }
}