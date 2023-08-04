import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

public interface Calculator extends Remote {
    void pushValue(int val, String clientID) throws RemoteException;

    void pushOperation(String operator, String clientID) throws RemoteException;


    boolean isEmpty(String clientID) throws RemoteException;

    int pop(String clientID) throws RemoteException;

    int delayPop(int millis, String clientID) throws RemoteException;

    // Custom function to generate Client ID and put it in HashMap
    String getClientID() throws RemoteException, ServerNotActiveException;
}
