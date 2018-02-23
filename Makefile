#==============================================================================
DIR=source/lvl$(L)/p$(P)/

auto:
	javac $(DIR)Source.java
	java $(DIR)Source $(A)
	rm $(DIR)Source.class

edit:
	vim $(DIR)Source.java

info:
	less $(DIR)README.md

clean:
	find source/ -type f -name '*.class' -delete
#==============================================================================
