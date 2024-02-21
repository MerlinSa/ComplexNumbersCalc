package model;
import logger.ILogger;

/**
 * Реализация калькулятора для работы с комплексными числами.
 */
public class ComplexCalculator implements ICalculate {

    private ILogger logger;

    private double result;

    /**
     * Создает экземпляр калькулятора комплексных чисел с указанным логгером.
     * @param logger Логгер для записи логов операций калькулятора.
     */
    public ComplexCalculator(ILogger logger) {
        this.logger = logger;
        //this.result = result;

    }

    @Override
    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = num1.add(num2);
        logger.log("Выполненное сложение: " + num1 + " + " + num2 + " = " + result);
        return result;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = num1.multiply(num2);
        logger.log("Выполненное умножение: " + num1 + " * " + num2 + " = " + result);
        return result;
    }

    @Override
    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = num1.divide(num2);
        logger.log("Выполненное деление: " + num1 + " / " + num2 + " = " + result);
        return result;
    }

    @Override
    public double result() {
        System.out.printf("Result: %s%n", result);
        return result;
    }

    @ Override
    public void clear() {
        this.result = 0;

    }
}