# System design Document för shed

Samuel Kajava, Daniel Rygaard, Pouya Shirin & Emil Svensson

2021-09-04

v1.0

## 1 Introduction

### 1.1 Word book

## 2 System architecture
In this project the program does not use any databse, server or 
external source for storing or retrieving information. Instead, it uses a stored Json file with all the data that is needed.
Moreover, if any further information needs to be stored, it is stored via a file saving system now implemented into the Favorites feature.

###Components
Furthermore, the program has several components that represents the functionality of a certain niched feature.
Therefore, these features combined creates the whole functionality of the program.

 - **Model.** 
A public interface and state handler of the backend. To clarify, 
this is where the front end will have access to the backend functionality.

- **Favorites.**
Responsible for handling what products the user has marked as favorite. 
The favorite's module then stores all the products marked as favorite in a local txt file when the program gets closed. Furthermore, the txt file is then read by the program on the program startup and represented in the gui 

- **Parsing.**
 Handles all the static data that is represented in the gui. In addition, the parser translates all the products from a Json file and into the program

- **Filter.**
This component is responsible for filtering all the products in different ways. The allround purpose is for the front end to be able to put in certain criteria, for those products that  met those criterias are then returned and will then be represented in gui.

- **Drink generator,**
 generates drinks based on certain criteria as well as ingredients that will be specified by the user.
 The ingredients put in will be products, the program will then read a set amount of drinks from a local file and check which drinks have these products as an ingredient

- **APK Leaderboard,**
Gives a list based on the amount of alcohol and the price of a certain product. The product with the most amount of alcohol and the cheapest price will be on the top of the list while the most expensive product with the least amount of alcohol will be at the bottom.

###Features
The features that will be implemented using these components are
- Filter and search for specific products based on user input
- Generate drinks based on certain criteria specified by the user
- See which products contain the best price for the most amount of alcohol



###Flow
Moreover, the program will be used as a utility tool by the user to find information that is needed.
When the user starts the application, he or she will be presented with several products and a carousel, 
in addition there will also be a navigation with different connections to all the features that are listed above.
The user will be able to close the program at any point in the process.
 
## 3 System design

### Package Diagram

![PackageDiagramAll](PackageDiagramBig.png)
This package digram shows the entirety of the program in it's biggest package model. The uml shows that Model,view,controller structure i followed. 

#### Model
![PackageDiagramModel](PackageDiagramModel.png)
The model package is responsible for handling the logic and handling all the data that the program saves or represents for the user. The features implemented in the model right now is, - filter, filters all the products
- Favorites, saves products as favorites
- Parsing, fetches the data from a Json file

#### View
As a consequence of using scenebuilder and fxml files with maven, is that the fxml files need to be in the resource folder.  Therefore the view is not a package in the java structure. However, the dependancies still apply correctly. When we create a FXMl file a controller is assosiated with that file. The fxml file then points to that file and gives it all the Objects and information it needs to execute correctly.

#### Controller
This package includes all of the controllers that is associated to the different fxml files.
A controller for an fxml files handles what happens when a user does any sort of input




### Domain model
![DomainModel](Photos/DomainModel.png)

Domain model represents the program in a more abstract format. The program will work as follows,

- Product
The product represents all the information that is needed from a beverage by the program 
	- Name 
	- Price
	- Alcohol percentage
	- etc
	.......

- Selection
A selection is a asserted number of products with specific attributes. This is a way of finding products with a specifik attribute that the user have selected

- Sortiment,
This is where all the information of the products are, lets say the user wants information about a product. The program will then go to Sortiment, get that specifik Selection with that product in it and the get the product from that slection.

- Drink
Represents all the information the program needs for a drink
	- Name
	- Ingredients(Products)
	- etc
	.......

- DrinkGenerator
This module is responsible for finding a driunk based on a list of products(Beverages), the user will give it.

- FavoriteProducts
FavoriteProducts will save th products that is selected by the user and represent them in a lst of favoritised products

- Drinking game
This module is responsible for handling drinking games, the module will have the functionality for the user to play drinking games. The moduel has several different players that will be specified by the user

- Player
Represents the information needed by a player for the drinking games
	- name


### Design Model

- **Model**
 ![ModelDesign](Photos/ModelDesignUML.png)
 This class si for the Template Method pattern, it provides a simpler interface to a complex subsystem. this will be the only conncection that is accessable outside of the model package.
 The model uses all the different pakcages of the backend and represents a simpler way of using them.
 
- **Parser**
 ![ParsingDesign](Photos/ParsingDesignUML.png)
 The functionallity of this module isto fetch data from some type of datastorage. In our case, we use a json file to store our products. Therefore we are using 
 
 
- **Filter**
![FilterDesign](Photos/FilterDesignUML.png)
- **Favorites**
 ![FavoritesDesign](Photos/FavoritesDesignUML.png)
- **Drink Generator**
 Not yet implemented







Draw an UML package diagram for the top level for all components that you have
identified above (which can be just one if you develop a standalone application). Describe the interfaces and dependencies between the packages. Describe how you have
implemented the MVC design pattern.
Create an UML class diagram for every package. One of the packages will contain
the model of your application. This will be the design model of your application,
describe in detail the relation between your domain model and your design model.
1
There should be a clear and logical relation between the two. Make sure that these
models stay in ‘sync’ during the development of your application.
Describe which (if any) design patterns you have used.
The above describes the static design of your application. It may sometimes be
necessary to describe the dynamic design of your application as well. You can use an
UML sequence diagram to show the different parts of your application communicate
an in what order.

## 4 Persistent data management(Samuel)

## 5 Quality(Samuel)

### 5.1 Access control and security (if relevant)

## 6 References