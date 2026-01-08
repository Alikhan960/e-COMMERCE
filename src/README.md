E-Commerce Project - Assignment 2
Project Overview
This is a simple e-commerce console app for my second assignment. I used my previous theme but upgraded it with more OOP stuff. It handles products like electronics and clothes, lets you create shoppers, and make orders.

How to run it
Put all .java files in one folder.

Open your terminal or CMD in that folder.

Compile everything: javac *.java

Run the main class: java Main

What I did for this Assignment (Requirements):
Abstraction: I made the Product class abstract. You can't just make a "Product" anymore—it has to be a specific type like Electronics or Clothing.

Inheritance: Electronics and Clothing both extend the Product class and get all its fields.

Encapsulation: All fields are private. I use getters and setters to access them.

Polymorphism: I used a List<Product> to store different types of items at once. I also overrode the toString() method so each product prints its own info correctly.

Overloading: I added extra constructors and methods. For example, you can set a price directly or use a discount percentage, and you can create an order with or without a specific quantity (defaults to 1).

Overriding: I manually overrode toString(), equals(), and hashCode() in all classes so the objects compare and print properly.

Data Pool & Logic: I'm using ArrayList to store everything. In the Main class, I added code to search for a product by name, filter the list for expensive electronics, and sort all items by price.