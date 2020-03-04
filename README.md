# Linked Lists in C and java

This project will have you create Linked Lists in both C and Java. From class you should already have the pseudo code to add a node to the end of a list, as well as a basic C implementation. You will also have to add functionality to remove an element, add elements in sorted order, and clear out the list.

Project Goals:
  - Understand pointers/references in both C and Java
  - See a more complex C project composed of multiple files
  - Use the `make` build system to compile and run your code

You will be creating a linked list data structure which holds a playlist -- artist name, song, and song duration. You will be given a template that already contains the data structures to use for your list and a print function that demonstrates how to step through the list and display all the elements.

The C structure is defined in the `llist.h` file:

```c
struct LList
{
  struct LNode* head;
};

struct LNode {
  char* artistName;
  char* songName;
  double duration;
  struct LNode* next;
};
```

In Java you will have similar code put into `LList` and `LNode` classes.  You **may not** change the fields defined in the classes/structs.

>*Deadlines:*
>  - Algorithm Psuedocode due 10/20 (preferably earlier)
>  - Complete project due 10/27

## Phase 1: Algorithms
Before writing your code you must prepare pseudo code algorithms for each of the different functions. You must submit these in your repository [Algorithms/README.md](Algorithms/README.md) file **by Sunday 10/20/19 at 11:00PM**. You are encouraged to submit much sooner so that you can make progress on your coding -- if you submit sooner, you will get feedback sooner! Keep in mind that your algorithms should be language agnostic since you will be using this for both C and Java.

`addNode:` This should add a song to the end of the list.
  * Inputs: artistName, songName, and duration of the new entry in your playlist.
  * Return the index of where the element was added (i.e., if the list was empty, it should return 0; if the new entry is the 4th entry, it should return 3), or -1 on an error.
  * Note: Our LList data structure only contains a reference to the head of the list, so you will *not* be able to directly add to the rear like was done in our class example!

`addSortedDuration:` Add a song to the list sorted by duration.
  * Inputs: artistName, songName, and duration of the new entry in your playlist.
  * Return the index of where the element was added (i.e., if the list was empty, it should return 0; if the new entry is the 4th entry, it should return 3), or -1 on an error.
  * You can assume that if a user wants a list to be sorted by duration, they will only use `addSortedDuration` (not a mix of that and `addNode`).

`addSortedName:` Add a song to the list sorted by artist name.
  * Inputs: artistName, songName, and duration of the new entry in your playlist.
  * Return the index of where the element was added (i.e., if the list was empty, it should return 0; if the new entry is the 4th entry, it should return 3), or -1 on an error.
  * If there is a song or more by the same artist, the new entry will be added at after all the current entries.
  * Implementation tip: you cannot test if two strings are equal with `==` in C or Java! In C you will have to learn to use the [strcmp](https://www.tutorialspoint.com/c_standard_library/c_function_strcmp.htm) function and in Java you will want to use `.equals`
  * You can assume that if a user wants a list to be sorted by artist name, they will only use `addSortedName` (not a mix of that and `addNode` or `addSortedDuration`).

`remNode:` Remove a song by name
  * Input: The name of the song to remove.
  * Note: If there happen to be two entries in the list with the same name, you should remove the entry closest to the head of the list.
  * Implementation tip: you cannot test if two strings are equal with `==` in C or Java! In C you will have to learn to use the [strcmp](https://www.tutorialspoint.com/c_standard_library/c_function_strcmp.htm) function and in Java you will want to use `.equals`
  * Return the index where the element was removed, or -1 on an error.

`clearList:` Clear a list
  * Remove all locations in the list
  * Return the total number of entries that were removed.

## Phase 2: Implementation
The git repository has starter code for both C and Java, as well as some test cases to see how well your code works.
  - You must use those as a base and *may not change the structure or class definitions* (e.g., you may not add a rear pointer to your list structure).
  - You *may not* use other data structure libraries (e.g., the java collections framework) to implement your code. You should be writing your linked lists from scratch.

This is our first C program that spans multiple files:
  - `llist.h` is a "Header File" that defines the prototypes for the functions and data structures used in the Linked List library
  - `llist.c` is the C file that implements those functions. This is where you will write your code.
  - `tests.c` is a C file containing the program's `main` function. It has a variety of test cases that you can use to validate the correctness of your program.  You should not modify the test functions, but you can modify `main` to control which tests are executed.

The java code only includes the simplest possible test case to see if you can add an entry to a list that has already been started. You must add other test cases to verify that your different functions are working correctly.

**How to run your code:** You will see that the C code is made up of several files, so to simplify compilation we have provided a `Makefile` that automates the building and running process.  Simply run the commands listed below to build or execute either the C or Java code.

To build and run the C code use:
```
  make c
  make runc
```

To build and run the Java code use:
```
  make java
  make runjava
```

**Where to run your code:** Repl.it is not ideal when working with programs spread across multiple files, but we can use seasdb.seas.gwu.edu server to run your project, or locally on your computer.
