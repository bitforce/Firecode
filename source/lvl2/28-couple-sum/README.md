# Couple Sum

Overview
---
Given an array of integers, find two numbers such that they sum up to a 
specific target. The method coupleSum should return the indices of the 
two numbers in the array, where index1 must be less than index2. 
Please note that the indices are not zero based, and you can 
assume that each input has exactly one solution. Target 
linear runtime and space complexity.

Usage
---
`java CoupleSum T A`, where _T_ is the target integer and _A_ is an array of vals.

`java CoupleSum 7 1 2 5`
`java CoupleSum 10 1 9 3 5`
`java CoupleSum 14 1 2 3 4 10`
`java CoupleSum 20 1 2 9 11 25`

Note
---
Some things to be aware of are not being able to combine the same index twice to 
equal the target. For example assuming T=10 and A={1,3,5}, you will not be able 
to return {3,3}. Fortunately, for this problem, that issue was not addressed 
and although an attempt to deal with it during the development version 
was made (`map.get(diff) != i`), it was eventually taken out to more 
properly fit the problem scope.
