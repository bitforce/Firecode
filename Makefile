DIR = source/lvl$l/p$p/
VIM = /usr/bin/vim

ifeq ($(shell uname), Darwin)
	VIM = /usr/local/bin/vim
endif

auto:
	javac $(DIR)Source.java
	java $(DIR)Source $a
	rm $(DIR)Source.class

code:
	$(VIM) $(DIR)Source.java

edit:
	$(VIM) $(DIR)README.md

less:
	less $(DIR)README.md

list:
	less source/lvl$l/README

clean:
	find source/ -type f -name '*.class' -delete
