# Delete At Head Circular Linked List

Overview
---
Given a circular linked list, implement a method to delete its head node. 
Return the list's new head node.

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
This problem seems to not be working with the current implementation. All the 
solutions presented in the code appear to work on Firecode, but not here, so 
it may likely have to do with the internal implementation of a CLL--think 
to 08/12/17 when challenge 26 (delete specific node at index) took a 
ridiculous amount of time, near-solely for the reason that I did not 
correctly implement the correct initialization

`list.print()`
`head = deleteAtMiddle(head, Integer.parseInt(args[0]))`
`list.print()`
but rather was trying to:
 `list.print()`
`deleteAtMiddle(head, Integer,parseInt(args[0]))`
`list.print()`
Where the primary problem is that since `deleteAtMiddle()` isn't a void method,
we needed to set `head` equal to it, because leaving it out on it's own line 
wouldn't actually change the global `head` pointers/values.


For some reason, all the solutions except deleteAtHead3() appear to work on
Firecode.io; however, fail to work when run here. I can't tell if it's 
because of the print() method that I am missing something or it the 
code for deleting the head is actually wrong. All the other code 
submitted, including my own, achieved success on the site.
