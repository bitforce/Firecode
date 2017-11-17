# Flip It! 

Overview
---
You are given an m x n 2D image matrix where each integer represents a pixel. 
Flip it in-place along its vertical axis.

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
1 0  <-- a[0][0] a[0][1]
1 0  <-- a[1][0] a[1][1]
---
0 1 
0 1

Say we have a function f(x); to flip it vertically across the origin, we make
it into f(-x): such that every variable (x) is replaced with -x. For example:
----
f(x) = x^2 + 2x + n --> (-x)^2 + 2(-x) + m
----
Simply apply this logic to your array mutation.

Note how the row values aren't moved; however, the column values are swapped.
Thus, you are only working with [c] in m[r][c].

SWAP ROWS
                temp = matrix[r][c];
                matrix[r][c] = matrix[r][rowlen - c - 1];
                matrix[r][rowlen - c - 1] = temp;

SWAP COLUMNS
                temp = matrix[r][c];
                matrix[r][c] = matrix[r][collen - c - 1];
                matrix[r][collen - c - 1] = temp;

Note that for the column swap, the inner for-loop must, c < collen/2 so that 
you don't swap continously through the rows and arrive in the same position.
