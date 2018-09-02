# Even Split 

Overview
---
Given an array of integers, determine if it is possible to split the array into two parts such 
that the sum of all elements in each part is the same.

Analysis
---
N/A

Example
---
splitArray({1,2,3,4}) ==> true
splitArray({1,2,4}) ==> false

Usage
---
A='A', where _A_ is an array of integers.

A='1 2 3 4'
A-'1 2 4'

Note
---
The split-array doesn't need to be a contiguous subset of the original. Adding all the numbers 
together and validating the number's parity (odd/even), will tell you right away if it's even 
possible.
