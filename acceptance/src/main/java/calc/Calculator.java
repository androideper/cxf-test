package calc;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    List<Double> stack = new ArrayList<Double>();
    double result;

    public double getResult() {
        return result;
    }

    public void push(double arg) {
        stack.add(arg);
    }

    public double divide() {
        result = stack.get(0) / stack.get(1);
        return result;
    }

    public double add() {
        result = stack.get(0) + stack.get(1);
        return result;
    }
}