DIR=source/lvl$l/p$p/

auto:
	javac $(DIR)Source.java
	java $(DIR)Source $a
	rm $(DIR)Source.class

code:
	vim $(DIR)/Source.java

edit:
	vim $(DIR)/README.md

less:
	less $(DIR)/README.md

list:
	cat source/lvl$l/README

clean:
	find source/ -type f -name '*.class' -delete
