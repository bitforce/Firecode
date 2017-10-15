# Looping Lists : Space complexity O(n) 

Overview
---
Given a singly-linked list, implement a method to check if the list has cycles. 
The space complexity can be O(n). If there is a cycle, return true otherwise 
return false. Empty lists should be considered non-cyclic.

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

Note
---
This question was really weird, in all the "correct" solutions, they checked to 
see if the node's address was found again in the singly-linkedlist; however, 
if it is an SLL, then there should be no cyclic nodes and the only way to 
check it is to understand which predefined patterns to be looking for or 
to be using a circularly-linkedlist. My solution was accepted, but I 
don't believe it was tested correctly and is unfit according to the 
problem, since essentially what it is looking for it just other 
matching integers. I believe the two other solutions do work, 
but perhaps I did not test them correctly.
