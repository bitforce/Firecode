# Remove Duplicate Nodes

Overview
---
N/A

Analysis
---
N/A

Example
---
N/A

Usage
---
N/A

Note
---
N/A

    /*
     * Spotted the problem: when map takes in 'head', it takes it in as 
     * the same head that is connected to all the other ndoes. In a 
     * sense, this is storing a lot of different memory: the map 
     * values are not connected to each other and each one 
     * contain another 'head' node point to X-more down 
     * the list. --> how about just store --> if you 
     * think about if where you would return just 
     * the Map interface, wouldn't you have 
     * broken links? --> that's why you use 
     * LinkedList<> to return.
     *
     * Next best option to use a set and re-build the list or a key-val 
     * store and map integer to listnode and then set those inputs tp 
     * connect to one another.
     */

So it turns out that the other solutions only take out only 1 duplicate in the 
list, which is strange because it should be able to remove all duplicates; 
however, the problem doesn't specify either way, so whatever.

__THIS SOLUTION NEEDS TO BE RECHECKED: ALL THE SOLUTION SUBMISSION SEEM TO BE 
DEFICIENT IN SOME MANNER__.
