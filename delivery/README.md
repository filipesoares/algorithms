# Problem

Amazon Fresh is a grocery delivery services that offers consumers option of purchansing their groceries online and having them delivered on schedule.
The Amazon Fresh team is planning a route for a deplivery area for each order to effectively plan the route.
The area is abstracted as a grid. Not all alocations area acessible by road. The truck only needs to make a single delivery.

Write an algorithm to determine the minimum distance required for the truck to deliver the order.

Assumptions:

- Some places in the delivery area cannot be accessed by the driver, as there are no roads into those locations;
- The delivery area can be represented as a two-dimensional grid of integers, where each integer representes one cell;
- The truck must start from the top-left corner of the area, wich is always accessible, and can move one cell up, down, left or right at a time;
- The truck must navigate around the areas without roads and cannot leave the area;
- The accessible areas are represented as 1, areas with without roads are represented by 0 and the order destination is represented by 9;

Input:

The input to the function/method consists of three arguments: 
- numRows, an integer representing the number of rows;
- numColumns, an integer representing the number of columns;
- area, respresenting the two-dimensional grid of integers;

Output:
Return an integer representing the total distance traversed to deliver the order else return -1;

Constraints:
1 <= numRows, numColumns <=1000

Example:
    
    Input:
        numRows=3
        numColumns=3
        area=[
                [1,0,0],
                [1,0,0],
                [1,9,1]
            ]
    Output:
        3

    Input:
        area=[1,1,1,1]
             [0,1,1,1]
             [0,1,0,1]
             [1,1,9,1]
             [0,0,1,1]

Explanation:
Starting from the top-left corner, the truck traversed the cells (0,0) -> (1,0) -> (2,0) -> (2,1). The truck traversed the total distance 3 to deliver the order.

00 01 11 21 31 30