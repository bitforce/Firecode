# Iterative BST Validation

Overview
---
Given the root node of a Binary Tree, write a method - validateBSTItr to 
iteratively determine if it is a Binary Search Tree. A BST must satisfy 
the following conditions:

- The right subtree of a node contains  nodes data > its data.
- The left subtree of a node contains nodes with data < its data.
- A node's left and right subtrees follow the above two conditions.

Analysis
---
_V1_
...

_V2_
...

_V3_
...

Example
---
```
make args='20 15 40 14 26' => false
make args='20 15 40 14 16' => true
make args='2 3 1' => false
make args='2 1 3' => true
```

Usage
---
`make args=T`

Note
---
Where _T_ is an array of values.

**Version 1 is the best solution.**

We extended to a BinaryTree instead of a BST for this problem because we wanted 
to test invalid and valid trees according to BST property and the other class 
automatically ensures that the tree is valid via the insertion method.
