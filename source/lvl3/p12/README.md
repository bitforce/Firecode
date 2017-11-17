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
N/A

Example
---
N/A

Usage
---
N/A

Note
---
**Version 1 is the best solution.**

We used a BinaryTree instead of a BST for this problem because we wanted to
test invalid and valid trees instead of the BinarySearchTree class since it 
automatically inserts nodes according to BST principle.
