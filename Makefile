export CLASSPATH=/usr/local/lib/antlr-3.3-complete.jar:.:$$CLASSPATH

all: java

java: antlr
	javac LoocLexer.java LoocParser.java TestLooc.java

antlr:
	-java org.antlr.Tool Looc.g

clean:
	rm -rf ./out/*.class
	rm -rf ./out/*.tokens
