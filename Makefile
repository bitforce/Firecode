#==============================================================================
MAKEFLAGS += --silent
PATH=source/lvl$(L)/p$(P)/Source
auto:
	javac $(PATH).java
	java $(PATH) $(A)
test:
	javac source/test/Test.java
	java source/test/Test
clean-problem:
	find source/lvl$(L)/_$(P)/ -type f -name '*.class' -delete
clean-level:
	find source/lvl$(L)/ -type f -name '*.class' -delete
clean-temp:
	find source/temp/ -type f -name '*.class' -delete	
clean-test:
	find source/test/ -type f -name '*.class' -delete
clean-root:
	find source/ -type f -name '*.class' -delete
#==============================================================================
