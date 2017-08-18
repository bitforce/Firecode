# Delete At Head Circular Linked List

Overview
---


Usage
---


Note
---
This problem seems to not be working with the current implementation. All the 
solutions presented in the code appear to work on Firecode, but not here, so 
it may likely have to do with the internal implementation of a CLL--think 
to 08/12/17 when challenge 26 (delete specific node at index) took a 
ridiculous amount of time, near-solely for the reason that I did not 
correctly implement the correct initialization:
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
