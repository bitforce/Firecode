# Introduction to Tries

Overview
---
A Trie or Prefix Tree an efficient data lookup structure - often used to store 
large collections of words or dictionaries. With a Trie, search complexities 
can be reduced to O(k) where k is the key or word length. The autocorrect on 
your iOS or Android keyboard uses a Trie of the most commonly used words 
along with fuzzy match algorithms to autocorrect and autosuggest words 
as you type. You're given a completed TrieNode class that represents 
one node of a Trie, and a partially complete Trie class. Your task 
is to complete the insertWord, searchWord and searchPrefix methods 
on the Trie class. Take a look at the examples below to see what 
each of these do.

Analysis
---
N/A

Example
---
```
A='bob al alice bob' => true, true
A='bob bo alice' => false, false
A='bob al bobi' => false, false
A='bob bo bob' => true, true
```

Usage
---
`make L=3 P=14 A='W P T'`

Note
---
Where _T_ is a string of words, _P_ is a prefix, and _W_ is the word to be searched.

Since we are focusing solely on the methods of the classes, there is one constructor 
to be used for all instantiation.
