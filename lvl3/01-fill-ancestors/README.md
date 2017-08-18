# Fill in the Ancestors of the Node in a Binary Tree

Overview
---
Given a binary tree's root node, an empty ArrayList and an integer nodeData, 
write a method that finds a target node - N with data = nodeData and 
populates the ArrayList with the data of the ancestor nodes of N - 
added from the bottom - up.

Usage
---
`java BinaryTree T A`, where _T_ is the target and _A_ is an array of values.

`java BinaryTree 0 1`
`java BinaryTree 1 1`
`java BinaryTree 3 1 2 3
`java BinaryTree 3 1 2 3`
`java BinaryTree 7 1 2 3 4 5 6 7`

Note
---
Due to changing global ArrayList var, we only are using the best solution, 
which happens to be the recursive one. The iterative solution does work.
