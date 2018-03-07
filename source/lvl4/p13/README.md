# Bit Swapping 

Overview
---
Given a 32 bit integer input x, swap its odd and even bits and return the 
resulting integer. (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 
are swapped, and so on).

Analysis
---
We extract all even bits out of the number and thus we use &A. Since they 
mention it being 32bit, we use 5 As. A == 10 == 1010, which is all the 
odd numbers (remember 2^0 is 0 and we start at 0th position). Doing 
the same for all odd bits, we use &5, b/c 5 == 0101, which is all 
the even number flipped. Thus we have:

X = 0111
E = 0010
O = 0101

Now that we have odd and even bits from their respective positions, we 
now need to shift them one over to be in the opposite position. So 
we shift the even bits to one side and the odd bits to the other; 
if we'd shifted them to them each over to the same side, nothing 
would've changed.

E = 0001
O = 1010

Finally, we combine them using OR, which so long as it's not false (1) 
and false (1), everything stays true; therefore,

X = 1011

Example
---
I: 5  => 0101
O: 10 => 1001

Usage
---
N/A

Note
---
N/A
