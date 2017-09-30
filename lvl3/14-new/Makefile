#==============================================================================
MAKEFLAGS += --silent
run:
	javac $(wildcard *.java)
	java Source $(args)
	make clean
clean: 
	$(RM) *.class temp/node/*.class temp/list/*.class temp/tree/*.class
#==============================================================================
