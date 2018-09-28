LIB_DIR = archive/*
BIN_DIR = binary/
SRC_DIR = source/lvl$l/p$p/
SRC_CP_DIR = source.lvl$l.p$p.

JUNIT = org.junit.runner.JUnitCore

auto:
	javac $(SRC_DIR)Source.java -d $(BIN_DIR) 
	javac -cp $(LIB_DIR): $(SRC_DIR)SourceMain.java -d $(BIN_DIR)
	java -cp $(BIN_DIR): $(SRC_DIR)SourceMain $a

junit:
	javac $(SRC_DIR)Source.java -d $(BIN_DIR) 
	javac -cp $(LIB_DIR): $(SRC_DIR)SourceTest.java -d $(BIN_DIR)
	java -cp $(BIN_DIR):$(LIB_DIR) $(JUNIT) $(SRC_CP_DIR)SourceTest

code:
	vim $(SRC_DIR)Source.java

main:
	vim $(SRC_DIR)SourceMain.java

test:
	vim $(SRC_DIR)SourceTest.java

list:
	less source/lvl$l/README

edit:
	vim $(SRC_DIR)README.md

view:
	less $(SRC_DIR)README.md
