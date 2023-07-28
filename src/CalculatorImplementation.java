import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    Stack<Integer> mainStack = new Stack<>();
    protected CalculatorImplementation() throws RemoteException {
        super();
    }

    @Override
    public void pushValue(int val) throws RemoteException {
        mainStack.push(val);
    }
}
