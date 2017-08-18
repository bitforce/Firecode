swap='*.swp'
class='*.class' 
if test "find . -name $class"; then
    find . -name $class -type f -exec echo "removing '{}'" \;
    rm -rf `find . -type f -name $class`
fi
if test "find . -name $swap"; then
    find . -name $swap -type f -exec echo "removing '{}'" \;
    rm -rf `find . -type f -name $swap`
fi
