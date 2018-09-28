LIB_DIR = archive/*
BIN_DIR = binary/
SRC_DIR = source/lvl$l/p$p/

JUNIT = org.junit.runner.JUnitCore

auto:
	javac $(SRC_DIR)Source.java -d $(BIN_DIR) 
	javac -cp $(LIB_DIR):. $(SRC_DIR)SourceTest.java -d $(BIN_DIR)
	java -cp $(BIN_DIR):$(LIB_DIR):. $(JUNIT) $(SRC_DIR)SourceTest $a

code:
	vim $(SRC_DIR)Source.java

test:
	vim $(SRC_DIR)SourceTest.java

list:
	less source/lvl$l/README

edit_readme:
	vim $(SRC_DIR)README.md

view_readme:
	less $(SRC_DIR)README.md

clean:
	find source/ -type f -name '*.class' -delete
