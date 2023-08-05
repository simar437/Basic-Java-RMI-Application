import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            Registry registry = LocateRegistry.getRegistry(1099);
            Calculator calculator = (Calculator) registry.lookup("Calculator");
            String clientID = calculator.getClientID();
            loop: while (true) {
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        calculator.pushValue(sc.nextInt(), clientID);
                        break;
                    case 2:
                        System.out.println(calculator.pop(clientID));
                        break;
                    case 3:
                        System.out.println(calculator.delayPop(sc.nextInt(), clientID));
                        break;
                    case 4:
                        calculator.pushOperation(sc.next(), clientID);
                        break;
                    case 5:
                        System.out.println(calculator.isEmpty(clientID));
                        break;
                    case -1:
                        break loop;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
