# Minimum Sum Path in a Triangle

Overview
---
Given a 'triangle' as an ArrayList of ArrayLists of integers, with each list 
representing a level of the triangle, find the minimum sum achieved by 
following a top-down path and adding the integer at each level along 
the path. Movement is restricted to adjacent numbers from the top to 
the bottom.

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

You can only traverse through adjacent nodes while moving up or down the 
triangle. An adjacent node is defined as a node that is reached by 
moving down and left or down and right from a level. For eg, in 
the triangle shown below, if you are at the digit 3 in the 
second row, its adjacent nodes are 5 and 6


Because you are adding an object (addr) and not the vals alone, you can't 
simply just add 'blist', because each new iteration will change the vals 
and update all previous enters; thus, making the ArrayList uniform in 
element vals. So, we create a new ArrayList object everytime with the 
current vals of 'blist'.

