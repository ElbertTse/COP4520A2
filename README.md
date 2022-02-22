# COP4520A2

Assignment 2 for COP 4520.

## Problem 1

Same as p prisoners problem. one thread is a leader, should take the cupcake and ctr++. others should ask for a cupcake if there is no other cupcake and leave it. Follower threads can only request a cupcake once. When leader ctr == n - 1, all guests have entered the labyrinth and they can stop.

Cake should be an atomic boolean. Leader should set it to false, others should set it to true.

This implementation will ask the user for how many guests/threads there are.

To compile:

    javac P1Main.java P1Leader.java P1Follower.java

TO run:

    java P1Main
    
## Problem 2

The guests should choose strategy 3.

### Advantages

### Disadvantages