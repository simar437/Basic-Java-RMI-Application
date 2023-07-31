# Calculator RMI Application

This is a Java RMI (Remote Method Invocation) application that provides basic calculator functionality using a server-client architecture. The server implements the `Calculator` interface, which defines various mathematical operations, and the client interacts with the server to perform these operations on a stack.

## Files


### Calculator.java

This is the interface that defines the remote methods to be implemented by the server. It declares methods for pushing values, performing mathematical operations, printing the stack, checking if the stack is empty, and more.

### CalculatorImplementation.java

This is the server-side implementation of the `Calculator` interface. It contains the logic for the stack and the mathematical operations. The server exposes these methods for remote invocation by the client.

### CalculatorServer.java

This is the server main class responsible for starting the RMI server. It instantiates the `CalculatorImplementation` class, binds it to the RMI registry, and makes it available for the client to access.

### CalculatorClient.java

This is the client-side code responsible for interacting with the server. The client presents a command-line interface to the user, allowing them to push values onto the stack, perform mathematical operations, and retrieve stack information.

## How to Run

Follow these steps to run the RMI calculator application:

1. Compile the source code:
   ```
   make
   ```

2. Start the server:
   ```
   make server
   ```

3. In a separate terminal or command prompt, start the client:
   ```
   make client
   ```


## CalculatorClient.java Operations

### Following operations can be performed using the client: 

1. **Push Value**
    - Description: Pushes a given integer value onto the stack.
    - Input: An integer value to be pushed onto the stack.
    - Usage: Enter `1` from the menu, then input the integer value to push onto the stack.

2. **Pop Value**
    - Description: Pops (removes and returns) the top value from the stack.
    - Usage: Enter `2` from the menu.

3. **Delay Pop Value**
    - Description: Pops (removes and returns) the top value from the stack after a specified delay.
    - Input: An integer value representing the delay time in milliseconds.
    - Usage: Enter `3` from the menu, then input the delay time in milliseconds.

4. **Push Operation**
    - Description: Performs a specific mathematical operation on the values present in the stack and pushes the result back onto the stack.
    - Input: A mathematical operation keyword (e.g., "min," "max," "gcd," "lcm").
    - Usage: Enter `4` from the menu, then input the operation keyword.

5. **Check if Stack is Empty**
    - Description: Checks if the stack is empty.
    - Usage: Enter `5` from the menu.

6. **Exit the Program**
    - Description: Exits the client program and terminates the connection with the server.
    - Usage: Enter `-1` from the menu.

## Note

- Used ClientID at the time of method invocation for uniquely identifying the clients and use a separate stack for each client. 


