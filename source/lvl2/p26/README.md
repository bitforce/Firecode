# Delete Node At Particular Position In a Linked List

Overview
---
Given a singly-linked list, implement a method to delete the node at a given 
position (starting from 1 as the head position) and return the head of the 
list. Do nothing if the input position is out of range.

Analysis
---

Example
---

Usage
---
`java Linkedlist M N`, where _M_ is the position to be searched and _N_ is an array 
of nodes for the linkedlist.

Examples
* `java Linkedlist 0 1 2 3`
* `java Permutations 1 1 2 3`
* `java Permutations 2 1 2 3`
* `java Permutations 3 1 2 3`
* `java Permutations 4 1 2 3`

Note
---
This particular solution was hard to come up with, because it's easy to 
forget that creating a reference to another object also means that the 
object referenced to now becomes mutable by the referencing objects 
actions/behaviors. That's why even though the _node_ var does all 
work in unlinking and repointing the references, _head_ is still 
returned. It's a easier thought to compare dealing with nodes in 
a linkedlist to stitching, sewing, and/or knitting.

* N.1) You may also notice the other confusing aspect may be 
that _i_ starts at 2 instead of 0 or 1. Well, first off, in 
most linkedlist, the structure is not zero-based, like an 
array; however, because we are setting _node_ to it's 
next pointer, we still want to be ahead so that the 
actual next pointer reference doesn't land on the 
index we want to get ride of. This is because we 
don't have a trailing pointer to fall back on, 
so we look ahead one node, so that we can skip 
over it.
* N.2) In this solution, a previous and current vars are used to perform  
the skip-unlink function; this creates extra memory, but may be more 
syntactically appealing.
* N.3) Even though this may be the slickest solution--code-wise, it's
problematic due to the O(n) runtime and memory; the method allocates 
a new node every time it's called.
