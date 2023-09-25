package Calculator;

import org.assertj.core.api.Assertions;

public class Calculator {
    public static void main(String[] args) {
        // Примеры вызова метода
        try {
            double discountedPrice = calculatingDiscount(100,10);
            System.out.println("Сумма с учетом скидки: " + discountedPrice);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
        if(num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, double discountAmount) {
        if (purchaseAmount < 0 || discountAmount < 0) {
            throw new ArithmeticException("Недопустимые аргументы");
        }

        discountAmount = purchaseAmount - discountAmount / 100;
        double discountedPrice = purchaseAmount - discountAmount;
        return discountedPrice;
    }

    void testCalculateDiscountWithValidArguments() {
        double purchaseAmount = 100;
        double discountAmount = 10;
        double expectedDiscountedPrice = 90;
        double actualDiscountedPrice = Calculator.calculatingDiscount(purchaseAmount, discountAmount);

        Assertions.assertThat(actualDiscountedPrice).isEqualTo(expectedDiscountedPrice);
    }

    void testCalculateDiscountWithNegativePurchaseAmount() {
        double purchaseAmount = -100;
        double discountAmount = 10;

        Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Недопустимые аргументы");
    }

    void testCalculateDiscountWithNegativeDiscountPercentage() {
        double purchaseAmount = 100;
        double discountAmount = -10;

        Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Недопустимые аргументы");
    }
}
