# Assignment 6 - Exceptions
In this assignment, you will write a program to simulate an online store for a small business. The application should allow customers to browse and purchase items from the store's inventory. The store's inventory is stored in a file called `inventory.txt` and has the following format:

	item_name,price,quantity
	item_name,price,quantity
	...

Starter code has been provided for you. Your task is to complete the starter code in `Main.java` and to create a new class called `Store` that has the methods detailed below. You will also create custom `Exception` classes.

## Assignment Submission
You will submit your assignment using GitHub Classroom.  When you are finished and want to make your final submission, use the checkin comment "FINAL SUBMISSION":

        git add .
        git commit -m "FINAL SUBMISSION"
        git push origin main

Any submission not having this comment will be assumed to be a work-in-progress and therefore will be ignored.  This implies that you must make your final push with this commit comment before the deadline.


## Methods to be Created
The following methods will need to be created in the `Store` class:
 - `public Store(String inventoryFilePath)`: Constructor that takes the path to the inventory file as a parameter and initializes the store's inventory by reading the file and storing the data in a `List<Item>` The file should be read using `try-with-resources`. The fields in the `inventory.txt` file are of type `String` (the item name), `float` (the price) and `int` (the quantity) respectively. If a `NumberFormatException` is encountered while reading any of the values, it should be caught and the error message shown in the output example below should be printed. Processing of the file should stop at that point so that the final `List<Item>` contains only objects derived from the valid records encountered up to the point of the error. If an `IOException` is encountered during this process (because the input file does not exist), it should be thrown so that the condition can be handled by the calling method.

 - `public void browseInventory()`: This method should print a list of all the items in the store's inventory, along with their prices and quantities.

 - `public void purchase(String itemName, int quantity)`: This method should allow a customer to purchase a specified quantity of a given item from the store's inventory. This method should throw the custom Exceptions `ItemNotFoundException` and `InsufficientQuantityException` when the implied conditions are encountered.

## Implementation Details
 - To complete this assignment, you will need to handle Exceptions appropriately and create the `InsufficientQuantityException` and `ItemNotFoundException` custom Exception classes.
 - use the `StringTokenizer` class to tokenize the input lines before converting them an instantiating a new `Item` instance.
 - use `String.format()` where necessary to format your output.
 - Your custom `Exception` classes should be created in a package called `exception`.
 - To open a file and read its contents (without using a `try-with-resources` block), you will need to perform the steps shown below. Your implementation will be modified because you will be using `try-with-resources`:

~~~~
FileReader reader = new FileReader(inventoryFilePath);
BufferedReader br = new BufferedReader(reader);

// read a line
br.readLine();

br.close();
reader.close();
~~~~
## Input
The inventory data is the `inventory.txt` file and the `bad_inventory.txt` file. All other input is taken from the user at runtime.

## Output
Your output should match the scenarios below exactly to receive full credit.  You should use the `String.format()` function to accomplish the correct spacing.

### Example 1
This example shows the expected interaction when attempting to read a file that does not exist

~~~~
>$ java Main no_file.txt
Unable to open inventory file.
~~~~
### Example 2
This example shows how the program should handle encountering a file with a bad input record.

~~~~
>$ java Main bad_inventory.txt 
Warning: Partial load of inventory file

Choose an option:
1: Print Inventory Report
2: Purchase Items
3: Quit
im> 1

	Inventory Report
	Hammer    : 5

Choose an option:
1: Print Inventory Report
2: Purchase Items
3: Quit
im> 3
~~~~
### Example 3
This example shows the following steps:
 1. printing the inventory report
 2. attempting to purchase 6 hammers (more than what is in stock)
 3. attempting to purchase 4 nails (an item that does not exist)
 4. attempting to purcahse 3 hammers (success)
 5. printing the inventory report again
 6. exiting the program

~~~~
>$ java Main inventory.txt
Choose an option:
1: Print Inventory Report
2: Purchase Items
3: Quit
im> 1

	Inventory Report
	Hammer    : 5
	Saw       : 10
	Monkey Wrench: 10
	bench     : 10

Choose an option:
1: Print Inventory Report
2: Purchase Items
3: Quit
im> 2
Item Name> Hammer
Quantity> 6

	Hammer: 6 requested but only 5 available.

Choose an option:
1: Print Inventory Report
2: Purchase Items
3: Quit
im> 2
Item Name> Nail
Quantity> 4

	Nail not found in inventory.

Choose an option:
1: Print Inventory Report
2: Purchase Items
3: Quit
im> 2
Item Name> Hammer
Quantity> 3

Choose an option:
1: Print Inventory Report
2: Purchase Items
3: Quit
im> 1

	Inventory Report
	Hammer    : 2
	Saw       : 10
	Monkey Wrench: 10
	bench     : 10

Choose an option:
1: Print Inventory Report
2: Purchase Items
3: Quit
im> 3
~~~~
