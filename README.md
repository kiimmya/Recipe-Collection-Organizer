Recipe Collection Organizer by Kim Diana COMFCI-25

Project Description

This project is a Recipe Collection Organizer helps users store and manage their recipes in a simple and organized way.
With this program, users can:
- Add new recipes – enter name, category, description, and ingredients
- View all recipes – see a list or open a recipe to read full details
- Update a recipe – change the name, category, ingredients, or cooking steps
- Delete a recipe – remove it when it is no longer needed

Each recipe contains:
- Name (e.g., "Spagetti Bolognese", "San Sebastian Cheesecake")
- Category (e.g., Main Course, Dessert, Soup, Breakfast)
- Description (the cooking instructions, step by step)
- List of ingredients (a number (quantity), and a unit (like grams, milliliters, or spoons) of each ingredient)

The program has two different ways to use it:
- Command Line Interface (CLI) – users type commands in the terminal.
- Graphical User Interface (GUI) – users click buttons and see windows (made with Java Swing).

All recipes are automatically saved to files on your computer.
This means that when you close the program and open it again later, your recipes are still there. Nothing is lost.

The program also checks what the user types – for example, it will not allow an empty recipe name or a negative amount of flour.
If something goes wrong (like the save file is missing), the program shows a friendly message instead of crashing.

This project uses:
- Classes and objects – each recipe and ingredient is an object
- Encapsulation – data is kept safe inside objects
- Inheritance – a child class can reuse code from a parent class
- Polymorphism – the same method can work differently for different types of objects
  

Project Objectives

The main goal of this project is to build a useful recipe organizer while practicing Java programming and OOP concepts.
Here are the specific objectives.

1. Implement CRUD operations:
- Create: add a new recipe with all its details
- Read: view one recipe or list all recipes
- Update: change the name, category, ingredients, or description of an existing recipe
- Delete: remove a recipe permanently

2. Provide two user interfaces:
- Command Line Interface (CLI) – for users who prefer typing commands
- Graphical User Interface (GUI) using Java Swing – for users who prefer clicking buttons and menus

3. Save data between sessions:
- Use file storage (serialization or text files) so recipes are not lost after closing the program
- Automatically load saved recipes when the program starts

4. Apply OOP principles correctly:
- Encapsulation: all fields are private, and access is done through public getters and setters
- Inheritance: create a base class (e.g., Item) and at least one child class (e.g., Recipe)
- Polymorphism: override methods from the parent class to provide specific behavior (e.g., getDescription())

5. Validate user input:
- Do not accept empty strings for names or categories
- Do not accept zero or negative numbers for ingredient quantities
- Show clear error messages and ask the user to try again

6. Handle errors gracefully:
- Catch file reading/writing errors without crashing
- Handle invalid menu choices or recipe numbers with friendly prompts
- Use try-catch blocks where necessary

7. Organize code into modules:
- Separate classes for different responsibilities
- Recipe – stores recipe data
- Ingredient – stores ingredient data
- RecipeManager – handles CRUD and file saving
- InputValidator – checks user input
- Main – runs the CLI
- RecipeGUI – runs the Swing interface

8. Store full recipe details:
- Recipe name, category, and description
- Ingredients with name, quantity (as a number), and unit (g, kg, cup, tbsp, etc.)
- Display ingredients in a clear column format

9. Make the program user-friendly:
- Clear menus with numbered options
- Support command abbreviations (e.g., add or just a)
- Allow uppercase and lowercase commands
- Use indexes starting from 1 (not 0) so it's easier for users

Overall, the project shows how to build a complete Java application that is both functional and user-friendly.
