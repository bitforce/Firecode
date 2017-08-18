# Transpose Matrix

Overview
---
You are given a square 2D image matrix where each integer represents a pixel. 
Write a method transposeMatrix to transform the matrix into its Transpose - 
in-place. 

Usage
---
The program arguments: row length (_N_), column length (_M_), array (_A_) of 
integers with a cardinality of (_N_ x _M_); however, for this specific 
problem, _N_ should equal _M_.
`java TransposeMatrix N M A`

Examples:
* `java TransposeMatrix 1 1`
* `java TransposeMatrix 2 2 1 2 3 4`
* `java TransposeMatrix 3 3 1 2 3 4 5 6 7 8 9`

Note
---
Transposition involves taking column (left to right) and making rearranging 
them into rows (top to bottom); essentially, turn all rows into columns 
and turn all columns into rows; for example:

1 2 3 | 1 4 7
4 5 6 | 2 5 8
7 8 9 | 3 6 9

1 0 0 | 1 0 0
0 2 0 | 0 2 0
0 0 3 | 0 0 3

1 0 2 | 1 0 3
0 3 0 | 0 3 0
4 0 5 | 2 0 5
