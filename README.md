# Firecode

Overview
---
These are all the problems I have completed on Firecode.io along with notes and 
resources I used to assist me. There are 5 levels to master and under _source_ 
are each of those levels with the respective code challenges required to 
complete each level. I've also included folders containing datastructure 
templates and test files which you can run. Everything can be compiled 
and ran from the root directory using `make`. For information on 
which problem-numbers correspond to which problems, you can see
the README contained in each level-folder. When possible, I 
[co-]code (either I come up with them or I find online)
alternative solutions to the same problem, just to give 
some perspective to how to go about solving it; a prime 
example being iterative & recursive solutions to the 
same problem. The exceptions are when the problem is 
either extremely difficult and I don't have the 
mental capacity to figure one out or the 
problem is so easy, there's not much 
need for other insight.

Currently, there are +130 solved coding challenges in the project; all come with 
documentation. I add more as I solve more; however, only specific to this site.

Setup
---
`git clone https://github.com/bitforce/Firecode`

Usage
---
_N_ corresponds to an integer [1,5] representing the level-folder.
_M_ corresponds to an integer representing a problem-folder.
_O_ represents the _potential_ argument needed to run.

You'll most likely use: `make L=N P=M A=O` to compile and run 
specific problems.

###### example
In the below example, I'm compiling and running problem 22 from level 3; using the 
following arguments: data (4), position in list (2), and the list (5 3 2 1 ). 
The objective of the code is to put the data in a certain position of a 
doubly-linkedlist. 

`make L=3 P=22 A='4 2 5 3 2 1'`

The second line of output should be: 5 4 3 2 1

_Generic testing of levels and template files_.
```
make test-temp
make test-levels N
```

_For cleaning directories of all those nasty class files_.
The follow commands will remove class files from the root, the level-folder, a 
specific problem directory, or even the template folder.
```
make clean problem L=N P=M
make clean-level L=N
make clean-temp
make clean-root
```

Note
---
There are a few golden nugget techniques littered around the solutions. The following
is a list of descriptions below and their locations.

- L:? P:? 2D array insertion of values into 1D array.
