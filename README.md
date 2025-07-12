# Java Login System

A simple command-line based login and registration system in Java using file handling.

## Files

- `Main.java` - Entry point for the program with a menu for user interaction.
- `AuthSystem.java` - Handles user registration and login.
- `users.txt` - Stores usernames and passwords in a comma-separated format.

## Usage

1. Compile the Java files:
   ```bash
   javac Main.java AuthSystem.java
   ```

2. Run the program:
   ```bash
   java Main
   ```

## Notes

- Make sure `users.txt` is in the same directory when running the program.
- User data is stored in plain text. Do not use real credentials.
