import java.util.HashMap;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class ReversePolishNotation {
    private static HashMap<String, BinaryOperator<Double>> operations = new HashMap<>();
    private static Stack<Double> valueStack = new Stack<>();

    static {
        operations.put("+", (a, b) -> a+b);
        operations.put("-", (a, b) -> b-a);
        operations.put("*", (a, b) -> a*b);
        operations.put("/", (a, b) -> b/a);
        operations.put("^", (a, b) -> Math.pow(b, a));
    }

    public static double calculate(String calculatedValue) throws CalculateException {
        if(calculatedValue.isEmpty())
            return 0;
        for(String c : calculatedValue.split(" "))
            if(c.matches("[0-9]+"))
                valueStack.push(parse(c));
            else if(operations.containsKey(c))
                handleOperation(operations.get(c));
            else
                throw new CalculateException("Unexpected symbol "+c+".");
        return getResult();
    }

    private static void handleOperation(BinaryOperator<Double> bio) throws CalculateException {
        if(valueStack.size() < 2)
            throw new CalculateException("Invalid calculate value.");
        double firstValue = valueStack.pop();
        double secondValue = valueStack.pop();
        valueStack.push(bio.apply(firstValue, secondValue));
    }

    private static double getResult() throws CalculateException {
        if(valueStack.size() > 1)
            throw new CalculateException("Invalid calculate value.");
        return valueStack.pop();
    }

    private static double parse(String value){
        return Double.parseDouble(value);
    }


}
