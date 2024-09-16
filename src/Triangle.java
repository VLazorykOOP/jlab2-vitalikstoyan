import java.util.Scanner;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    // Конструктор класу з перевіркою можливості створення трикутника
    public Triangle(double sideA, double sideB, double sideC) {
        if (isValidTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        } else {
            throw new IllegalArgumentException("Трикутник з такими сторонами неможливий!");
        }
    }

    // Метод для перевірки можливості існування трикутника
    private boolean isValidTriangle(double sideA, double sideB, double sideC) {
        return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
    }

    // Метод для обчислення периметра трикутника
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    // Метод для обчислення площі трикутника за формулою Герона
    public double getArea() {
        double p = getPerimeter() / 2; // півпериметр
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    // Метод для порівняння двох трикутників за площею
    public boolean isLargerThan(Triangle other) {
        return this.getArea() > other.getArea();
    }

    // Метод для порівняння площ трикутників: менше, більше або дорівнює
    public int compareTo(Triangle other) {
        double thisArea = this.getArea();
        double otherArea = other.getArea();

        if (thisArea > otherArea) {
            return 1; // поточний трикутник більший
        } else if (thisArea < otherArea) {
            return -1; // поточний трикутник менший
        } else {
            return 0; // площі трикутників однакові
        }
    }

    // Головний метод для взаємодії з користувачем
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення сторін першого трикутника
        System.out.println("Введіть сторони першого трикутника:");
        System.out.print("Сторона A: ");
        double sideA1 = scanner.nextDouble();
        System.out.print("Сторона B: ");
        double sideB1 = scanner.nextDouble();
        System.out.print("Сторона C: ");
        double sideC1 = scanner.nextDouble();

        // Створення першого трикутника
        Triangle t1;
        try {
            t1 = new Triangle(sideA1, sideB1, sideC1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Введення сторін другого трикутника
        System.out.println("Введіть сторони другого трикутника:");
        System.out.print("Сторона A: ");
        double sideA2 = scanner.nextDouble();
        System.out.print("Сторона B: ");
        double sideB2 = scanner.nextDouble();
        System.out.print("Сторона C: ");
        double sideC2 = scanner.nextDouble();

        // Створення другого трикутника
        Triangle t2;
        try {
            t2 = new Triangle(sideA2, sideB2, sideC2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Виводимо периметр і площу кожного трикутника
        System.out.println("Периметр трикутника t1: " + t1.getPerimeter());
        System.out.println("Площа трикутника t1: " + t1.getArea());

        System.out.println("Периметр трикутника t2: " + t2.getPerimeter());
        System.out.println("Площа трикутника t2: " + t2.getArea());

        // Порівнюємо трикутники за площею
        if (t1.isLargerThan(t2)) {
            System.out.println("Трикутник t1 більший за t2");
        } else if (t1.compareTo(t2) == 0) {
            System.out.println("Трикутники t1 і t2 мають однакову площу");
        } else {
            System.out.println("Трикутник t1 менший за t2");
        }

        scanner.close();
    }
}
