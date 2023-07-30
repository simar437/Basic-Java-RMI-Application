JAVAC = javac
JAVA = java

SRC_DIR = src
OUT_DIR = out

SERVER_CLASS = CalculatorServer
CLIENT_CLASS = CalculatorClient


default: compile server client

compile:
	$(JAVAC) -d $(OUT_DIR) $(SRC_DIR)/*.java

# Run the CalculatorServer
server:
	$(JAVA) -cp $(OUT_DIR) $(SERVER_CLASS)

# Run the CalculatorClient
client:
	$(JAVA) -cp $(OUT_DIR) $(CLIENT_CLASS)

