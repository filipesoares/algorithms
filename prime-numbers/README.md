# Problem

You are working for a telecommunications company that is trying to upgrade the junction boxes all over Techlandia.
Some of the junction boxes already been upgraded, and other boxes not.
Your task is to identify the oldest boxes that need to be upgraded first but leaving the newer model boxes so that they will not be prioritized.

All the junction boxes are identified by an alphanumeric identifier, followed by space delimited version information. The older generation uses
space delimited lowercase English strings to identify the version, but the newer generation uses space delimited positive integers to identify 
the version.

Your task is to sort the junction boxes in the following order:

1. The older generation junction boxes with the earliest lexicographic version should come first;
2. If there are any ties in the older generation, ties should be broken by the alphanumeric identifier;
3. Finally, the newer generation boxes should also be returned, in the original order, they were in the List;

Example:

Input:
```code
["ykc 82 01"]
["eo first qpx"]
["09z cat hamster"]
["06f 12 25 6"]
["az0 first qpx"]
["236 cat dog rabbit snake"]
```
Output:
```code
["236 cat dog rabbit snake"]
["09z cat hamster"]
["az0 first qpx"]
["eo first qpx"]
["ykc 82 01"]
["06f 12 25 6"]
```