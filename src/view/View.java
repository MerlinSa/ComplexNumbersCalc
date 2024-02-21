package view;

import model.ComplexNumber;
import model.ICalculate;
import util.Operators;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * User interface.
 */

public class View {
    private final ICalculate calculator;
    private final List<String> validOperators;

    public View(ICalculate calculator) {
        this.calculator = calculator;
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());
    }

    public void run() {
        while (true) {
            prepare();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    private void prepare() {
        // Создаем объект Scanner для считывания ввода от пользователя
        Scanner scanner = new Scanner(System.in);

        // Просим пользователя ввести первое комплексное число
        System.out.println("Введите действительную часть первого комплексного числа:");
        double real1 = scanner.nextDouble();
        System.out.println("Введите мнимую часть первого комплексного числа:");
        double imaginary1 = scanner.nextDouble();
        ComplexNumber num1 = new ComplexNumber(real1, imaginary1);

        String operator = getOperator(); // команда вывода оператора

        // Просим пользователя ввести второе комплексное число
        System.out.println("Введите действительную часть второго комплексного числа:");
        double real2 = scanner.nextDouble();
        System.out.println("Введите мнимую часть второго комплексного числа:");
        double imaginary2 = scanner.nextDouble();
        ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

        if (operator.equals("*")) {
            ComplexNumber product = calculator.multiply(num1, num2);
            System.out.println("Произведение: " + product);
        }

        if (operator.equals("+")) {
            ComplexNumber sum = calculator.add(num1, num2);
            System.out.println("Сумма: " + sum);
        }

        if (operator.equals("/")) {
            ComplexNumber quotient = calculator.divide(num1, num2);
            System.out.println("Деление: " + quotient);
        }
        //calculator.result();
        calculator.clear();


    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.out.println("Continue?... (y/n)");
        return in.nextLine();
    }

    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the math operation (*, +, /) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Entered invalid math operator. " + "Enter the math operation (*, +, /) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }

    private double promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        double result = -1D;
        try {
            result = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Not number was enter. Please enter number");
            promptInt(message);
        }
        return result;
    }

}
