#==============================================================================
PATH=source/lvl$(L)/p$(P)/Source
auto:
	javac $(PATH).java
	java $(PATH) $(A)
	rm $(PATH).class
test-temp:
	javac source/test/TestTemplates.java
	java source/test/TestTemplates
test-lvls:
	javac source/test/TestLevels.java
	java source/test/TestLevels $(L)
clean-problem:
	find source/lvl$(L)/p$(P)/ -type f -name '*.class' -delete
clean-level:
	find source/lvl$(L)/ -type f -name '*.class' -delete
clean-temp:
	find source/temp/ -type f -name '*.class' -delete	
clean-test:
	find source/test/ -type f -name '*.class' -delete
clean-root:
	find source/ -type f -name '*.class' -delete
#==============================================================================
