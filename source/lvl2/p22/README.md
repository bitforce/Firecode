# Merge Two Sorted Arrays

Overview
---
The idea behind the classic Mergesort algorithm is to divide an array in 
half, sort each half, and then use a merge() method to merge the two 
halves into a single sorted array. Implement the merge() method that 
takes in two sorted arrays and returns a third sorted array that 
contains elements of both the input arrays. You can assume that 
the input arrays will always be sorted in ascending order and 
can have different sizes.

Analysis
---


Example
---

Usage
---
`java MergeSorted N A M B`, where _N_ and _M_ are the sizes of the array 
and _A_ and _B_ are arrays with sizes corresponding to _N_ and _M_

Examples:
* `java MergeSorted 2 8 9 0`
* `java MergeSorted 2 0 1 3 7 8 9`
* `java MergeSorted 3 3 4 5 3 6 7 8`

Note
---
* numbers are sorted in ascending order
* duplicate elements allowed
  * merge({2,3,5}, {1,2,4}) => {1,2,2,3,4,5}
* empty arrays allowed
  * merge({2,1,0}, {}) => {2,1,0} 
* array lengths may be different
  * merge({1}, {2,3}) => {1,2,3}
