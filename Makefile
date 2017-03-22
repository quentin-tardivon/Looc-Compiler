SRC_DIR = src
BIN_DIR = out
CORE_DIR= core
SAMPLE_DIR = samples
PGM = TestLoocMakefile
EXTENSION = looc
PGM_JAVA = $(PGM).java
LOG_FILE_ANTLR = antlr.log

# Create needed directories
$(shell mkdir -p $(BIN_DIR))

export CLASSPATH=/usr/local/lib/antlr-3.3-complete.jar:.:./$(BIN_DIR):$$CLASSPATH

all: java

java: antlr
	@echo "\n --- Compile java classes ---"
	javac -d $(BIN_DIR) $(SRC_DIR)/$(CORE_DIR)/LoocLexer.java $(SRC_DIR)/$(CORE_DIR)/LoocParser.java $(SRC_DIR)/$(PGM_JAVA)
	@echo ""

antlr:
	@echo "\n --- Execute Antlr ---"
	java org.antlr.Tool -o $(CORE_DIR) Looc.g 2>&1 |tail -n 5
	#java org.antlr.Tool -o $(CORE_DIR) Looc.g

clean:
	rm -r $(BIN_DIR)
	rm -f $(LOG_FILE_ANTLR)

parse: java
	@echo " --- Execute TestLooc ---"
	@java $(PGM)

#level1: java
#	@echo " --- Check Level1.looc---"
#	@java $(PGM) $(SAMPLE_DIR)/Level1.looc

#level2: java
#	@echo " --- Check Level2.looc---"
#	@java $(PGM) $(SAMPLE_DIR)/Level2.looc

#level3: java
#	@echo " --- Check Level3.looc---"
#	@java $(PGM) $(SAMPLE_DIR)/Level3.looc

#level4: java
#	@echo " --- Check Level4.looc---"
#	@java $(PGM) $(SAMPLE_DIR)/Level4.looc

#level5: java
#	@echo " --- Check Level5.looc---"
#	@java $(PGM) $(SAMPLE_DIR)/Level5.looc
#
# level6: java
#	@echo " --- Check Level6.looc---"
#	@java $(PGM) $(SAMPLE_DIR)/Level6.looc

#levelHardcore: java
#	@echo " --- Check levelHardcore.looc---"
# @java $(PGM) $(SAMPLE_DIR)/LevelHardcore.looc

#test: level1 level2 level3 level4 level5 level6 levelHardcore

test: java
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
