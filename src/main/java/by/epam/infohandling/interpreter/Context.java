package by.epam.infohandling.interpreter;

import java.util.ArrayDeque;
//ok
public class Context {
    private ArrayDeque<Double> contextValue = new ArrayDeque<>();
    public Double pop() {
        return contextValue.pop();
    }
    public void push(Double number) {
        contextValue.push(number);
    }
}
