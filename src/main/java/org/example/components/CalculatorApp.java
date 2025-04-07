package org.example.components;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.exceptions.DivideByZeroException;
import org.example.exceptions.EmptyArrayException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Log4j
@AllArgsConstructor
public class CalculatorApp {
    private final Scanner scanner;
    private final Calculator calculator;

    public void run() {
        int option;
        do {
            option = chooseOption();
            if (option == 1) {
                option1();
            } else if (option == 2) {
                option2();
            } else {
                log.info("Saliendo...");
            }
        } while (option != 3);
    }

    private void option1() {
        try {
            var numbers = askNumbers();
            double average = calculator.media(numbers);
            log.info(average);
        } catch (EmptyArrayException e) {
            log.error("No se puede calcular la media de una lista vacía");
        }
    }

    private void option2() {
        try {
            var numerator = askDouble();
            var denominator = askDouble();
            double average = calculator.divide(numerator, denominator);
            log.info(average);
        } catch (DivideByZeroException e) {
            log.info("No se puede dividir por cero");
        }
    }

    private List<Double> askNumbers() {
        List<Double> numbers = new ArrayList<>();
        String response = "";
        do {
            numbers.add(askDouble());
            log.info("¿Vas a introducir otro número? (Y/n)");
        } while (!response.equalsIgnoreCase("n"));
        return numbers;
    }

    private double askDouble() {
        log.info("Introduce un número");
        Double number = null;
        do {
            try {
                number = scanner.nextDouble();
            } catch (InputMismatchException e) {
                log.error("EL valor introducido no es un número");
            }
            scanner.nextLine();
        } while (number == null);
        return number;
    }

    private int chooseOption() {
        int option = 0;
        do {
            log.info("Elige una opción");
            log.info("1. Calcular la media");
            log.info("2. Dividir");
            log.info("3. Salir");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("El valor introducido no es un  número");
            }
            scanner.nextLine();
            if (option < 1 || option > 3) {
                log.error("Opción inválida");
            }

        } while (option < 1 || option > 3);
        return option;
    }
}