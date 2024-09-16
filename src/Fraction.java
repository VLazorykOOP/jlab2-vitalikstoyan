import java.util.Scanner;    // 11 завдання

public class Fraction {
    private long integerPart;  // Ціла частина
    private short fractionalPart;  // Дробова частина (представлена як число від 0 до 99)

    // Конструктор
    public Fraction(long integerPart, short fractionalPart) {
        this.integerPart = integerPart;
        this.fractionalPart = fractionalPart;
    }

    // Метод для додавання дробів
    public Fraction add(Fraction other) {
        long newIntegerPart = this.integerPart + other.integerPart;
        short newFractionalPart = (short) (this.fractionalPart + other.fractionalPart);

        // Якщо дробова частина більше 99, то додаємо до цілої частини
        if (newFractionalPart >= 100) {
            newIntegerPart += newFractionalPart / 100;
            newFractionalPart = (short) (newFractionalPart % 100);
        }

        return new Fraction(newIntegerPart, newFractionalPart);
    }

    // Метод для віднімання дробів
    public Fraction subtract(Fraction other) {
        long newIntegerPart = this.integerPart - other.integerPart;
        short newFractionalPart = (short) (this.fractionalPart - other.fractionalPart);

        // Якщо дробова частина негативна, перетворюємо її в правильний вигляд
        if (newFractionalPart < 0) {
            newIntegerPart -= 1;
            newFractionalPart += 100;
        }

        return new Fraction(newIntegerPart, newFractionalPart);
    }

    // Метод для множення дробів
    public Fraction multiply(Fraction other) {
        // Перетворюємо дробові числа до форматів з однією дробовою частиною
        double thisDecimal = this.integerPart + (this.fractionalPart / 100.0);
        double otherDecimal = other.integerPart + (other.fractionalPart / 100.0);

        // Рахуємо результат множення
        double result = thisDecimal * otherDecimal;

        // Розділяємо на цілу та дробову частини
        long newIntegerPart = (long) result;
        short newFractionalPart = (short) Math.round((result - newIntegerPart) * 100);

        return new Fraction(newIntegerPart, newFractionalPart);
    }

    // Операції порівняння
    public boolean equals(Fraction other) {
        return this.integerPart == other.integerPart && this.fractionalPart == other.fractionalPart;
    }

    public boolean greaterThan(Fraction other) {
        if (this.integerPart > other.integerPart) {
            return true;
        } else if (this.integerPart == other.integerPart) {
            return this.fractionalPart > other.fractionalPart;
        }
        return false;
    }

    public boolean lessThan(Fraction other) {
        if (this.integerPart < other.integerPart) {
            return true;
        } else if (this.integerPart == other.integerPart) {
            return this.fractionalPart < other.fractionalPart;
        }
        return false;
    }

    // Повернення дробу у вигляді рядка
    @Override
    public String toString() {
        return String.format("%d.%02d", integerPart, fractionalPart);
    }

    // Головний метод для взаємодії з користувачем
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення першого дробу
        System.out.print("Введіть цілу частину першого дробу: ");
        long intPart1 = scanner.nextLong();
        System.out.print("Введіть дробову частину першого дробу (0-99): ");
        short fracPart1 = scanner.nextShort();

        Fraction f1 = new Fraction(intPart1, fracPart1);

        // Введення другого дробу
        System.out.print("Введіть цілу частину другого дробу: ");
        long intPart2 = scanner.nextLong();
        System.out.print("Введіть дробову частину другого дробу (0-99): ");
        short fracPart2 = scanner.nextShort();

        Fraction f2 = new Fraction(intPart2, fracPart2);

        // Операції з дробами
        Fraction sum = f1.add(f2);
        Fraction diff = f1.subtract(f2);
        Fraction prod = f1.multiply(f2);

        // Виведення результатів
        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
        System.out.println("f1 + f2: " + sum);
        System.out.println("f1 - f2: " + diff);
        System.out.println("f1 * f2: " + prod);

        // Операції порівняння
        System.out.println("f1 > f2: " + f1.greaterThan(f2));
        System.out.println("f1 < f2: " + f1.lessThan(f2));
        System.out.println("f1 == f2: " + f1.equals(f2));

        scanner.close();
    }
}
   


   