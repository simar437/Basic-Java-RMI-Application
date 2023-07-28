import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Calculator calculator = (Calculator) registry.lookup("Calculator");
            calculator.pushValue(10);
            calculator.printStack();

        } catch (Exception ignore) {}
    }
}
