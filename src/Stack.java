import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

public class Stack {
    // Список для зберігання елементів стека
    private ArrayList<Integer> stack;

    // Конструктор, що створює порожній стек
    public Stack() {
        stack = new ArrayList<>();
    }

    // Додавання елемента у стек (операція push)
    public void push(int value) {
        stack.add(value);
    }

    // Вилучення елемента зі стека (операція pop)
    public int pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    // Перегляд верхнього елемента стека (операція peek)
    public int peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    // Перевірка, чи стек порожній
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Пошук елемента в стеку
    public boolean search(int value) {
        return stack.contains(value);
    }

    // Виведення елементів стека
    public void display() {
        if (stack.isEmpty()) {
            System.out.println("Стек порожній");
        } else {
            System.out.println("Елементи стека: " + stack);
        }
    }

    // Головний метод для взаємодії з користувачем
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        boolean continueProgram = true;

        // Основне меню для користувача
        while (continueProgram) {
            System.out.println("\nОберіть дію:");
            System.out.println("1 - Додати елемент до стека (push)");
            System.out.println("2 - Вилучити елемент зі стека (pop)");
            System.out.println("3 - Переглянути верхній елемент (peek)");
            System.out.println("4 - Пошук елемента у стеку");
            System.out.println("5 - Вивести всі елементи стека");
            System.out.println("6 - Вийти з програми");

            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Додати елемент до стека
                    System.out.print("Введіть число для додавання у стек: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    System.out.println("Елемент " + value + " додано у стек.");
                    break;

                case 2: // Вилучити елемент зі стека
                    try {
                        int poppedValue = stack.pop();
                        System.out.println("Вилучений елемент: " + poppedValue);
                    } catch (EmptyStackException e) {
                        System.out.println("Помилка: Стек порожній, немає елементів для вилучення.");
                    }
                    break;

                case 3: // Переглянути верхній елемент
                    try {
                        int topValue = stack.peek();
                        System.out.println("Верхній елемент стека: " + topValue);
                    } catch (EmptyStackException e) {
                        System.out.println("Помилка: Стек порожній.");
                    }
                    break;

                case 4: // Пошук елемента у стеку
                    System.out.print("Введіть число для пошуку: ");
                    int searchValue = scanner.nextInt();
                    if (stack.search(searchValue)) {
                        System.out.println("Елемент " + searchValue + " знайдений у стеку.");
                    } else {
                        System.out.println("Елемент " + searchValue + " не знайдений у стеку.");
                    }
                    break;

                case 5: // Вивести всі елементи стека
                    stack.display();
                    break;

                case 6: // Вихід з програми
                    continueProgram = false;
                    System.out.println("Завершення роботи програми.");
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }

        scanner.close();
    }
}
