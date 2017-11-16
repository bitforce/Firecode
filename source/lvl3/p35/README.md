# Distance of a node from the root 

Overview
---
Given the root of a Binary Tree  and an integer that represents the data value 
of a TreeNode present in the tree, write a method - pathLengthFromRoot that 
returns the distance between the root and that node. You can assume that 
the given key exists in the tree. The distance is defined as the minimum 
number of nodes that must be traversed to reach the target node.

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
The original solution; even though validated by Firecode engine, does not find 
the minimum if you search the left next node first instead of the right. Note 
that typically the smaller values will be on the right side--even though it 
shouldn't matter when searching a regularly binary tree rather than a BST.
