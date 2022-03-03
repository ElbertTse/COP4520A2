# COP4520A2

Assignment 2 for COP 4520.

Both solutions will require an input for the number of guests/threads.

## Problem 1

Same as p prisoners problem. one thread is a leader, should take the cupcake and ctr++. others should ask for a cupcake if there is no other cupcake and leave it. Follower threads can only request a cupcake once. When leader ctr == n - 1, all guests have entered the labyrinth and they can stop.

Cake should be an atomic boolean. Leader should set it to false, others should set it to true.

This implementation will ask the user for how many guests/threads there are.

To run:

    make p1

    
## Problem 2

The guests should choose strategy 3. To implement strategy 3, I implemented a CLH Lock based on the example in the textbook but with minor modifications since it does not work verbatim.

To run:

    make p2

### Advantages
* Better than 1st and 2nd strategy since it guarantees that each guest will enter the showroom since CLH Lock is a queue lock.
* Improves on Array-based Queue Lock since it eliminates false sharing by using ThreadLocal references and reduces space complexity.
* Is an improvement on 2nd strategy since there is a queue to enforce ordering.

### Disadvantages
* Not as portable, will not work well on NUMA architectures.
* Takes up more space than a simpler mutex lock.
* Is more complex to implement than a simple mutex lock that could be used for strategy 1.