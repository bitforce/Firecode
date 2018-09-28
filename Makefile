LIB_DIR = archive/
BIN_DIR = binary/
SRC_DIR = source/lvl$l/p$p/

auto:
	javac $(SRC_DIR)Source.java -d $(BIN_DIR)
	javac -cp $(BIN_DIR):$(LIB_DIR) $(SRC_DIR)Test.java -d $(BIN_DIR)
	java -cp $(BIN_DIR):$(LIB_DIR) $(SRC_DIR)Test $a

src:
	vim $(SRC_DIR)Source.java

test:
	vim $(SRC_DIR)Test.java

list:
	less source/lvl$l/README

edit_readme:
	vim $(SRC_DIR)README.md

view_readme:
	less $(SRC_DIR)README.md

clean:
	find source/ -type f -name '*.class' -delete
