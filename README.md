This project comes with a .in file that is read from for the program to run through and create a .out file. To change it to a different size, keep these constraints in place

The first number represents the number of simulated days that the program will run through (n)
After that there are n number of numbers that represent the number of customers for that day (m)
After that there are m number of customers in the following format:   
    <number of minutes after 12 that they arrive> <first name> <last name> <number of orders (p)>
After each customer there are p orders in the following format:
    <Order, specific inputs in MenuItem.java> <number of that item they ordered>
    
As an example, here is a shortened version:
1
10
0 CANDYCE FERET 4
Soft_Drink_Small 2
Grilled_Chicken_Sandwich 4
Waffle_Fries_Small 2
Chicken_Sandwich 4
1 WILHELMINA POWSEY 1
Grilled_Chicken_Sandwich_Combo 1
4 MARINDA FROMONG 4
Grilled_Chicken_Sandwich_Combo 4
Milkshake_Large 4
Nuggets_12_Piece_Combo 1
Waffle_Fries_Large 4
7 SHEENA ZAPPIA 1
Soft_Drink_Small 3
7 OLLIE WHITBREAD 4
Waffle_Fries_Medium 4
Nuggets_8_Piece_Combo 4
Waffle_Fries_Small 3
Nuggets_12_Piece_Combo 4
8 LANELLE MARFIL 2
Soft_Drink_Large 1
Soft_Drink_Small 3
11 KENNITH HILBNER 2
Soft_Drink_Small 4
Waffle_Fries_Medium 2
11 ANGIE DOCKWILLER 3
Chicken_Sandwich_Spicy 2
Soft_Drink_Small 1
Grilled_Chicken_Sandwich 3
11 RALPH RIESER 5
Soft_Drink_Medium 3
Nuggets_12_Piece 4
Chicken_Sandwich 1
Nuggets_12_Piece 2
Grilled_Chicken_Sandwich_Combo 4
12 ALPHA JORY 4
Nuggets_12_Piece_Combo 3
Milkshake_Large 1
Waffle_Fries_Medium 1
Waffle_Fries_Medium 3
