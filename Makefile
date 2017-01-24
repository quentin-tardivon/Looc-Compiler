SRC_DIR = src
BIN_DIR = bin
OUTPUT_DIR = output
SAMPLE_DIR = samples
PGM = TestLooc
PGM_JAVA = $(PGM).java
LOG_FILE_ANTLR = antlr.log

# Create needed directories
$(shell mkdir -p $(OUTPUT_DIR))
$(shell mkdir -p $(BIN_DIR))

export CLASSPATH=/usr/local/lib/antlr-3.3-complete.jar:.:./bin:$$CLASSPATH

all: java

java: antlr
	@echo "\n --- Compile java classes ---"
	javac -d $(BIN_DIR) $(OUTPUT_DIR)/LoocLexer.java $(OUTPUT_DIR)/LoocParser.java $(SRC_DIR)/$(PGM_JAVA)
	@echo ""

antlr:
	@echo "\n --- Execute Antlr ---"
	-java org.antlr.Tool -o $(OUTPUT_DIR) Looc.g 2>&1 |tail -n 5

clean:
	rm -r $(OUTPUT_DIR)
	rm -r $(BIN_DIR)
	rm -f $(LOG_FILE_ANTLR)

parse: java
	@echo " --- Execute TestLooc ---"
	@java $(PGM)
