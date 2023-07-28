import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    protected CalculatorImplementation() throws RemoteException {
        super();
    }

    @Override
    public void pushValue(int val) throws RemoteException {

    }
}
