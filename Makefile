DIR=source/lvl$l/p$p/

auto:
	javac $(DIR)Source.java
	java $(DIR)Source $a
	rm $(DIR)Source.class

edit:
	vim $(DIR)Source.java

read:
	vim $(DIR)README.md

info:
	less $(DIR)README.md

list:
	less source/lvl$l/README

clean:
	find source/ -type f -name '*.class' -delete
