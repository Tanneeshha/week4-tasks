## Objective
**IT Club (Navigating The Future Of IT)**  
**Week 4: Exception Handling and File I/O**

## Task 1: Read and Write Data to a Text File

### Description
The goal of this task is to implement a Java program that performs file operations using Exception Handling and File I/O. 
The program:
- Prompts the user for input and write it to a text file (`task1.txt`).
- Reads the contents of `task1.txt` and display them on the console.
- Handles any potential file-related exceptions.

### Code Implementation
The Java program uses `FileWriter` and `BufferedWriter` to write data into a text file, and `FileReader` and `BufferedReader` to read data from it. The program ensures proper resource management using `try-with-resources` statements and handles exceptions gracefully.

### Exception Handling
- If there is an issue with file writing (e.g., permission error), an error message is displayed, and the stack trace is printed.
- If the file is not found or cannot be read, an appropriate error message is displayed.

### File Linked (`task1.txt`)

### Summary
This task demonstrates the use of File I/O operations in Java with exception handling. The program efficiently manages reading and writing data while ensuring proper error handling mechanisms.


## Task 2: Implement Error Handling for File Operations

### Description
This task focuses on implementing error handling mechanisms for file operations. The Java program:
- Prompts the user for a file name.
- Reads and displays the contents of the specified file.
- Handles potential exceptions such as file not found and invalid input.

### Code Implementation
The Java program uses `File` and `Scanner` to read data from a file while implementing error handling for cases like missing files and invalid inputs.

### Exception Handling
- If the file is not found, the program displays a meaningful error message.
- If the user provides an empty input, they are prompted again until valid input is given.
- If an unexpected input error occurs, it is caught and displayed appropriately.

### File Linked (`task2.txt`)

### Summary
This task demonstrates how to properly handle errors when working with files in Java. It ensures user-friendly error messages and input validation to prevent crashes and unexpected behavior.


## Task 3: Contacts List Management Application

### Description
This task involves creating a simple Java-based contact management application that allows users to:
- Add new contacts
- View all saved contacts
- Search for a specific contact
- Delete an existing contact
- Edit contact details
- Save contacts to a file for future access

### Code Implementation
The Java program utilizes file handling and exception handling to manage contact information effectively. Contacts are stored in `contacts.txt`, and the program ensures that data is persistently saved and retrieved.

### Exception Handling
- If the contacts file (`contacts.txt`) is missing or cannot be read, the program informs the user that no existing contacts were found.
- When saving contacts, any file writing errors (e.g., permission issues) are caught, and an appropriate error message is displayed.
- If the user enters an invalid input, such as an empty name or phone number, the program allows them to retry.
- When searching, editing, or deleting contacts, the program handles cases where no matching contact is found and provides meaningful feedback.
- Proper resource management (`try-with-resources`) is used for reading and writing files to avoid resource leaks.

### File Linked (`contacts.txt`)

### Summary
This task demonstrates file handling and error handling by developing a simple contact management system in Java. Users can add, view, search, edit, and delete contacts, ensuring data persistence through file storage.
