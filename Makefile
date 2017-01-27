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


level1: java
	@echo " --- Check Level1.looc---"
	@java $(PGM) $(SAMPLE_DIR)/Level1.looc

level2: java
	@echo " --- Check Level2.looc---"
	@java $(PGM) $(SAMPLE_DIR)/Level2.looc	

level3: java
	@echo " --- Check Level3.looc---"
	@java $(PGM) $(SAMPLE_DIR)/Level3.looc

level4: java
	@echo " --- Check Level4.looc---"
	@java $(PGM) $(SAMPLE_DIR)/Level4.looc	