import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.UUID;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {

    HashMap<String, Stack<Integer>> mainStack = new HashMap<>();
    protected CalculatorImplementation() throws RemoteException {
        super();
    }

    @Override
    public void pushValue(int val, String clientID) throws RemoteException {
        mainStack.get(clientID).push(val);
    }
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    @Override
    public void pushOperation(String operator, String clientID) throws RemoteException {
        int x = 0;

        switch (operator) {
            case "min":
                x = Collections.min(mainStack.get(clientID));
                break;
            case "max":
                x = Collections.max(mainStack.get(clientID));
                break;
            case "gcd":
                x = mainStack.get(clientID).pop();
                while (!mainStack.get(clientID).isEmpty()) {
                    x = gcd(x, mainStack.get(clientID).pop());
                }
                break;
            case "lcm":
                x = mainStack.get(clientID).pop();
                while (!mainStack.get(clientID).isEmpty()) {
                    x = lcm(x, mainStack.get(clientID).pop());
                }
                break;
        }
        mainStack.get(clientID).clear();
        pushValue(x, clientID);
    }

    @Override
    public boolean isEmpty(String clientID) throws RemoteException {
        return mainStack.get(clientID).isEmpty();
    }

    @Override
    public int pop(String clientID) throws RemoteException {
        return mainStack.get(clientID).pop();
    }

    @Override
    public int delayPop(int millis, String clientID) throws RemoteException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pop(clientID);
    }

    @Override
    public String getClientID() throws RemoteException {
        String ID = UUID.randomUUID().toString();
        mainStack.put(ID, new Stack<>());
        return ID;
    }
}
