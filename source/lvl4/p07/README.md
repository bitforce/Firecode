# Mirror Mirror on the Wall ... 

Overview
---
Write a method to check if the two given binary trees are the mirror images of 
each other. Return true if they are, false otherwise. What's a binary tree's 
mirror image? Hold it by the root and rotate all other nodes by 180 degrees!

Analysis
---
N/A

Example
---
`make L=4 P=07 A='1 2 3'`

Usage
---
Arguments should be a list of integers.

Note
---
Because of laziness and not wanting to complicated things, I decided I didn't 
want to figure out creating a separate method for mirroring the tree values, 
but code-wise, it makes perfect sense. What I did instead was put identical 
trees into the algorithm, which should automatically spit false back.
