# Find the Number that Appears Once

Overview
---
Write a method that returns a number that appears only once in an array.
Assume the array will surely have a unique value. The array will never 
be empty.

Usage
---
`java FindUniqueNumber T A`, where _T_ is the target and _A_ is an array of values.

Note
---
If this problem was specific to making _all non-unique values appear an even
number of times_, then the following solutions would work well:
```
int singleNumber(int[] A) {
    Set<Integer> set = new HashSet<>();
    for(int i : A) if(!set.remove(i)) set.add(i);
    assert set.size() == 1;
    return set.iterator().next();
}

int singleNumber(int[] A) {
    int x = 0;
    for(int i : A)
        x ^= i;
    return x;
}
```
This is because XOR (^) works by flipping bits and an odd pattern would cause 
this method to return a false-positive. Also note that the latter solution is 
much faster.

Explanation
---
N/A
