SRC_DIR = src
BIN_DIR = out
CORE_DIR= core
TMP_DIR= tmp
ASM_DIR= asm
SAMPLE_DIR = samples
MICROPIUPK = microPIUPK.jar
SEMANTIC_ERRORS_DIR = errorSamples
PGM = TestLoocMakefile
EXTENSION = looc
PGM_JAVA = $(PGM).java
LOG_FILE_ANTLR = antlr.log

export CLASSPATH=/usr/local/lib/antlr-3.3-complete.jar:.:./$(BIN_DIR):./$(TMP_DIR):$$CLASSPATH

#$(shell mkdir -p $(ASM_DIR))

all: antlr

java: antlr
	@echo "\n --- Create out/ directory ---"
	mkdir -p $(BIN_DIR)
	@echo "\n --- Compile java classes ---"
	javac -d $(BIN_DIR) $(SRC_DIR)/$(CORE_DIR)/LoocLexer.java $(SRC_DIR)/$(CORE_DIR)/LoocParser.java $(SRC_DIR)/$(PGM_JAVA)
	@echo ""

antlr: clean
	@echo "\n --- Execute Antlr ---"
	java org.antlr.Tool -o $(SRC_DIR)/$(CORE_DIR) Looc.g 2>&1 |tail -n 5

clean:
	rm -rf output/
	rm -rf target/
	rm -rf $(BIN_DIR)
	rm -rf $(TMP_DIR)
	rm -f $(LOG_FILE_ANTLR)

javaTest:
	@echo "\n --- Create tmp/ directory ---"
	mkdir -p $(TMP_DIR)
	@echo "\n --- Execute Antlr ---"
	java org.antlr.Tool -o $(TMP_DIR) Looc.g 2>&1 |tail -n 5
	@echo "\n --- Compile java classes ---"
	javac -d $(TMP_DIR) $(TMP_DIR)/LoocLexer.java $(TMP_DIR)/LoocParser.java $(SRC_DIR)/$(PGM_JAVA)
	@echo ""

parse: javaTest
	java $(PGM) samples/errorSamples/ReturnValueTypeMismatchEx.looc
	@echo "\n\033[0m --- Delete tmp/ directory ---"
	rm -rf $(TMP_DIR)

testSyntaxErrors:
	@echo "\n --- Test Syntax errors ---"
	@for file in $(SAMPLE_DIR)/*.$(EXTENSION); do \
		FILE=$$(basename $$file); \
		TMP=$$(java $(PGM) $$file 2>&1|tr -d '\n'); \
		LETTER=$$(echo $$FILE | head -c 2); \
		if [ "$$LETTER" != '__' ] ; then \
			FIRST=$$(echo $$LETTER | head -c 1); \
			if [ "$$FIRST" = '_' ] ; then \
				if [ -z "$$TMP" ]; then \
					echo "\033[92m --- Check $$(basename $$file)\033[94m (Fichier avec erreur)"; \
					echo  "\t\033[91mIl devrait y avoir des erreurs...\033[0m"; \
				else \
					echo "\033[92m --- Check $$(basename $$file)\033[94m (Fichier avec erreur)"; \
					echo  "\t\033[90mErreur détecté: $$(echo $$TMP|head -c 50)...\033[0m"; \
				fi; \
			else \
				if [ -z "$$TMP" ]; then \
					echo  "\033[92m --- Check $$(basename $$file)\033[0m"; \
				else \
					echo  "\033[91m --- Check $$(basename $$file)\033[0m"; \
					echo  "\t\033[91m$$TMP\033[0m"; \
				fi; \
			fi; \
		fi; \
	done;
	@echo  ""

testSemanticErrors:
	@echo "\n --- Test Semantic errors ---"
	@for file in $(SAMPLE_DIR)/$(SEMANTIC_ERRORS_DIR)/*.$(EXTENSION); do \
			FILE=$$(basename $$file); \
			TMP=$$(java $(PGM) $$file 2>&1|tr -d '\n'); \
			if [ -z "$$TMP" ]; then \
				echo "\033[92m --- Check $$(basename $$file)\033[94m (Fichier avec erreur sémantique)"; \
			else \
				echo "\033[92m --- Check $$(basename $$file)\033[94m (Fichier avec erreur sémantique)"; \
				echo  "\t\033[91m$$TMP\033[0m"; \
			fi; \
		done;
		@echo  ""

test:javaTest testSyntaxErrors testSemanticErrors
	@echo "\n\033[0m --- Delete tmp/ directory ---"
	rm -rf $(TMP_DIR)


ass:
	java -jar $(MICROPIUPK) -ass $(file)

sim: ass
	#ASM_FILE=ASM_DIR/$$(basename $$file .asm).iup
	java -jar $(MICROPIUPK) -sim &
