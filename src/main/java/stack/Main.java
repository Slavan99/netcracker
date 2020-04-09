package stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество элементов");
        int num = sc.nextInt();
        System.out.println("Введите элементы");
        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            stack.push(a);
        }
        System.out.println(stack);
        System.out.println("Клонированный стек");
        Stack stack1 = stack.clone();
        System.out.println(stack1);
        System.out.println("Равны ли два стека? " + stack.equals(stack1));
        System.out.println("Вытащим первый элемент из клонированного");
        stack1.pop();
        System.out.println(stack1);
        System.out.println("Исходный");
        System.out.println(stack);

    }
}
