# Boggle with Electronic Dictionary  

Overview
---
You're given a 2D Boggle Board which contains an m x n matrix of chars - char[][]
board, and a fast, electronic Dictionary in the form of a Prefix Tree or Trie. 
Write a method - boggleSearchWithDict that searches the Boggle Board for 
words in the dictionary. Your method should return an alphabetically 
sorted ArrayList of words that are present on the board as well as 
in the dictionary. Words on the board can be constructed with 
sequentially adjacent letters, where adjacent letters are 
horizontal or vertical neighbors (not diagonal). Also, 
each letter on the Boggle Board must be used only 
once. Your program should run in a reasonable 
amount of time (at max about 50 ms for each 
test case) and shouldn't time out. 

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
The Trie has two built-in methods that you'll find useful for this problem - 
searchWord(String s) and searchPrefix(String s). These will return true if 
the complete word or prefix are found in the dictionary, respectively.
