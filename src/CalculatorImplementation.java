import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
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
    int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
    @Override
    public void pushOperation(String operator) throws RemoteException {
        int x = 0;
        int min = Collections.min(mainStack);
        int max = Collections.max(mainStack);
        switch (operator) {
            case "min":
                x = min;
                break;
            case "max":
                x = max;
                break;
            case "gcd":
                x = gcd(min, max);
                break;


        }
        mainStack.clear();
        pushValue(x);
    }

    @Override
    public String stackState() throws RemoteException {
        String state = "";
        for (int i : mainStack) {
            state += i + " ";
        }
        return state;
    }

    @Override
    public boolean isEmpty() throws RemoteException {
        return mainStack.isEmpty();
    }

    @Override
    public int pop() throws RemoteException {
        return mainStack.pop();
    }

    @Override
    public int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pop();
    }
}
