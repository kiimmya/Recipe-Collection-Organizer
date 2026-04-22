### Recipe Collection Organizer by Kim Diana COMFCI-25

### Project Description
The Recipe Collection Organizer is an application designed to manage cooking recipes in a structured and user-friendly manner. The system enables users to add, view, update, and delete recipes. Each recipe contains a name, category, detailed cooking description, and a list of ingredients with associated quantities.

The application provides both a Command Line Interface (CLI) and a Graphical User Interface (GUI) built with Java Swing. All recipe data is stored in external files, thereby ensuring persistence across program sessions. The program also incorporates input validation and error handling mechanisms to guarantee stable and reliable execution.

This project demonstrates the practical application of fundamental Object-Oriented Programming (OOP) principles, including encapsulation, inheritance, and polymorphism.

### Project Objectives
The principal objective of this project is to develop a fully functional recipe management system while applying core Java programming and OOP concepts.

The specific aims of the project are as follows:
- Implement complete CRUD (Create, Read, Update, Delete) functionality for recipes.
- Provide both CLI and GUI interfaces for user interaction.
- Ensure data persistence through file storage.
- Apply OOP principles (encapsulation, inheritance, polymorphism).
- Validate user input to prevent incorrect or incomplete data entry.
- Handle runtime errors using appropriate exception handling techniques.
- Organize the program into modular, reusable classes.
- Facilitate detailed recipe management, including ingredients and descriptions.

### Project Requirements
The system must satisfy the following requirements:
1. Implement CRUD operations for recipe management.
2. Provide a Command Line Interface (CLI) with menu-based navigation.
3. Provide a Graphical User Interface (GUI) using Java Swing.
4. Store recipe data including name, category, description, and ingredients.
5. Allow users to add and manage multiple ingredients per recipe.
6. Enable selective updates (name, category, ingredients, description).
7. Save all data to files to ensure persistence across sessions.
8. Validate user input (e.g., reject empty fields or invalid values).
9. Implement error handling using try-catch constructs.
10. Apply Object-Oriented Programming principles (encapsulation, inheritance, polymorphism).
11. Display recipes in a structured format (summary view plus detailed view).
12. Use one‑based indexing to facilitate user‑friendly navigation.

### Documentation

### Data Structures

1. The project employs the following data structures:
- ArrayList<Recipe> – to store all recipes dynamically.
- ArrayList<Ingredient> – within each recipe to store its ingredients.
These structures provide flexible resizing and simplified management of collections.

2. Main Classes and Modules:
- Recipe – stores recipe data (name, category, description, ingredients).
- RecipeDetails – stores cooking instructions separately.
- Ingredient – represents a single ingredient with name and amount.
- RecipeApp (CLI) – handles console‑based user interaction.
- RecipeGUI – provides the graphical interface using Java Swing.
- FileManager – manages saving to and loading from files.

3. Additional Module - Item (Base Class):
- Item – a parent/base class that stores common properties such as name.
- It is extended by the Recipe class to demonstrate inheritance.
- This class helps reduce code duplication and supports reusable structure.

4. Key Functions:
- addRecipe() – creates a new recipe.
- viewRecipes() – displays available recipes.
- updateRecipe() – modifies selected recipe data.
- deleteRecipe() – removes a recipe.
- showDetails() – displays full recipe information.
- save() / load() – handle file persistence.

5. Algorithms Used:
- Linear search for selecting recipes by index.
- Iteration through ArrayLists for displaying data.
- Conditional logic for handling menu commands.
- File serialization (or structured file storage) for saving data.

6. Challenges Faced: 
- Managing data synchronisation between the CLI and GUI components.
- Ensuring correct saving and loading of complex objects to/from files.
- Handling user input validation consistently across both interfaces.
- Designing a clean class structure that effectively uses multiple OOP principles.

