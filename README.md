# Project Description

This project implements a coffee management application using a custom `CoffeeSet` collection to manage different types of coffee. The application allows adding, removing, iterating over coffee objects, and performing various operations like checking for duplicates and clearing the set. The main class, `App`, demonstrates these operations with sample coffee objects.

## Running the Project

To run the project, follow these steps:

1. Navigate to the `.\src\` directory:
    ```bash
    cd .\src\
    ```

2. Run the command to build and execute the program:
    ```bash
    .\buildrun.cmd App
    ```

## Classes Overview

1. **Coffee**: A class representing different types of coffee, with attributes like name, price, weight, and quality rating. It provides methods to print coffee details.
2. **Node**: A generic class used within the `CoffeeSet` to represent each element of the set in a doubly linked list structure. Each node contains references to the previous and next nodes, as well as the coffee object it stores.
3. **CoffeeSet**: A custom implementation of the `Set` interface, managing a collection of `Coffee` objects. It uses a doubly linked list structure to store elements and ensures no duplicates are added. The set supports basic operations like adding, removing, checking for containment, and iteration.
4. **App**: The main class that demonstrates the functionality of the `CoffeeSet` by performing operations such as adding, removing, iterating, and clearing coffee objects in the set.

## CoffeeSet Functional Overview

The `CoffeeSet` class is a custom collection designed to hold `Coffee` objects without duplicates. It is implemented as a doubly linked list to efficiently manage the coffee items while allowing for dynamic resizing and efficient insertion and removal operations. Here are the functionalities in detail:

- **add(Coffee coffee)**: Adds a coffee object to the set if it doesn't already exist. 
     - If the set is empty, the coffee becomes the head and tail of the linked list.
     - New elements are added at the end of the list, with the `prev` and `next` pointers updated accordingly.
     - Returns `true` if the coffee was added, `false` if it already exists in the set.
   
- **remove(Object o)**: Removes the coffee object from the set by comparing its value.
     - The method updates the links of the neighboring nodes (`prev` and `next`) to maintain the structure of the list after removal.
     - Returns `true` if the object was found and removed, otherwise returns `false`.

- **contains(Object o)**: Checks if the coffee object exists in the set by iterating through the list.
     - Returns `true` if the object is found, `false` otherwise.

- **size()**: Returns the current number of elements (coffee objects) in the set.

- **isEmpty()**: Checks if the set is empty. 
     - Returns `true` if the set has no elements, otherwise returns `false`.

- **clear()**: Clears all elements from the set.
     - Resets the set by removing all references to the nodes (setting `head` and `tail` to `null` and size to `0`).

- **addAll(Collection<? extends Coffee> c)**: Adds all coffee objects from the provided collection to the set, skipping duplicates.
     - Iterates over the collection and attempts to add each object to the set.
     - Returns `true` if the set was modified (i.e., at least one element was added), otherwise returns `false`.

- **removeAll(Collection<?> c)**: Removes all elements in the set that are also present in the provided collection.
     - Iterates through the set and removes any object found in the collection.
     - Returns `true` if the set was modified (i.e., elements were removed), otherwise returns `false`.

- **retainAll(Collection<?> c)**: Retains only those elements in the set that are present in the provided collection.
     - Iterates through the set and removes any object not found in the collection.
     - Returns `true` if the set was modified (i.e., elements were removed), otherwise returns `false`.

- **containsAll(Collection<?> c)**: Checks if the set contains all the elements from the provided collection.
     - Returns `true` if all elements are present, otherwise returns `false`.

- **iterator()**: Returns an iterator to traverse the elements of the set.
     - The iterator starts from the head of the list and moves to the next node until it reaches the end of the list.

- **toArray()**: Converts the elements of the set into an array.
     - Returns an `Object[]` array containing all the elements of the set.

- **toArray(T[] a)**: Converts the elements of the set into an array of the specified type.
     - If the provided array is smaller than the size of the set, a new array of the same type is created to hold the elements.
     - Returns the array containing all the elements of the set.

## Description of Actions

Upon execution of the program, the following actions will be performed:

- The program initializes an empty `CoffeeSet` and checks its initial state.
- It defines a series of coffee objects (`Espresso`, `Latte`, `Cappuccino`, etc.) and adds them to the set.
- The program checks if specific coffee types (like `Latte` and `Americano`) are present in the set.
- It iterates over the coffee set, printing details of each coffee.
- The program demonstrates the removal of a coffee object (`Latte`) from the set and verifies that it has been removed.
- It adds a collection of coffee objects (`Americano` and `Mocha`) to the set and ensures that duplicates are not added when attempting to add already existing coffees.
- The final state of the set is displayed, and the set is cleared at the end, with the final state verified as empty.
