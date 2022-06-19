## Screencast of the program
https://youtu.be/eddoe3BZfW0

I used the Creational pattern to create a factory style Character class 
that can be instantiated by the Characters class. This allows me to create specific 
Characters in the Characters class that slightly change compared to a base Character.

I used the Structural pattern to create an interface that holds the basics of the different 
pieces of equipment. The methods that carry over between the different equipment types
follow the same interface to save code and ensure they work similarly.

I used a Behavioral pattern to decide what algorithm to run at any specfic time. Since there 
are options for the user, I can use this pattern to adjust to the different algorithms
based on what the user selects (or what is randomly selected so the code runs automated).


## Requirements

In order to run the program, you will need the following tools:

* gradle 4.1
* java 1.8.0

## Commands

You can run the program using the following the commands:

* 'gradle build': create the bytecode and run the test suite
* 'gradle run': runs the code