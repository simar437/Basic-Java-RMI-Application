import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

public interface Calculator extends Remote {
    void pushValue(int val, String clientID) throws RemoteException;

    void pushOperation(String operator, String clientID) throws RemoteException;

    String printStack(String clientID) throws RemoteException;

    boolean isEmpty(String clientID) throws RemoteException;

    int pop(String clientID) throws RemoteException;

    int delayPop(int millis, String clientID) throws RemoteException;

    String getClientID() throws RemoteException, ServerNotActiveException;
}
