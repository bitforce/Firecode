LIB_DIR = library/*
BIN_DIR = binary/
SRC_DIR = source/lvl$l/p$p/
SRC_CP_DIR = source.lvl$l.p$p.

JUNIT = org.junit.runner.JUnitCore

COMPILE_PROBLEM = javac $(SRC_DIR)Source.java -d $(BIN_DIR) 
COMPILE_MAIN = javac -cp $(LIB_DIR): $(SRC_DIR)SourceMain.java -d $(BIN_DIR)
COMPILE_TEST = javac -cp $(LIB_DIR): $(SRC_DIR)SourceTest.java -d $(BIN_DIR)

RUN_MAIN = java -cp $(BIN_DIR): $(SRC_DIR)SourceMain $a
RUN_TEST = java -cp $(BIN_DIR):$(LIB_DIR) $(JUNIT) $(SRC_CP_DIR)SourceTest

auto:
	$(COMPILE_PROBLEM)	
	$(COMPILE_MAIN)
	$(RUN_MAIN)

test:
	$(COMPILE_TEST)
	$(RUN_TEST)

compile:
	$(COMPILE_PROBLEM)
	$(COMPILE_MAIN)
	$(COMPILE_TEST)
