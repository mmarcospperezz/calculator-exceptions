package org.example.components;

import org.example.exceptions.DivideByZeroException;
import org.example.exceptions.EmptyArrayException;

import java.util.List;

public class Calculator {
    public double divide(double a, double b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
        } else{
            return a / b;
        }

    }

    public double media(List<Double> numeros) throws EmptyArrayException {
        if (numeros == null || numeros.isEmpty()) {
            throw new EmptyArrayException();
        }
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.size();
    }
}

