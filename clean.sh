class='*.class' 
if test "find . -name $class"; then
    find . -name $class -type f -exec echo "removing '{}'" \;
    rm -rf `find . -type f -name $class`
fi
