# Merge k Sorted Linked Lists 

Overview
---
Write a method to merge k Sorted Linked Lists. Why would you ever want to do that? Well, 
if you're dealing with a list of over 200 Million Integers that needs to be sorted, an 
efficient approach might involve splitting up the massive list into k smaller lists, 
sorting each list in memory and then combining the sorted lists to re-create the 
original list, albeit sorted. 

Analysis
---
N/A

Example
---
Variables: _N_ _M_ _A_, where _N_ is the number of lists you will have, _M_ is the _N_ 
numbers each representing the respective list sizes. The following example, there are 
3 lists, where each list will contain 2, 3, and 4 elements respectively. The sequence 
of elements following are the values to be within the lists--the cut off being the 
length of each _M_ and thus, the next sequence of _M_ numbers starting.

Below we have 3 lists of lengths: 2, 3, and 4 respectively, where said lists are 
[0, 1], [2, 3, 4], [5, 6, 7, 8]

`3 2 3 4 0 1 2 3 4 5 6 7 8`

Usage
---
N/A

Note
---
N/A
