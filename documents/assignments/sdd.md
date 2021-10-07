# System design Document för shed

Samuel Kajava, Daniel Rygaard, Pouya Shirin & Emil Svensson

2021-10-07

v2.0

## 1 Introduction

### 1.1 Word book

## 2 System architecture
In this project the program does not use any databse, server or 
external source for storing or retrieving information. Instead, it uses a stored Json file with all the data that is needed.
Moreover, if any further information needs to be stored, it is stored via a file saving system now implemented into the Favorites feature.

### Components
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
Displays a list based on the amount of alcohol and the price of a certain product. The product with the most amount of alcohol and the cheapest price will be on the top of the list while the most expensive product with the least amount of alcohol will be at the bottom.

### Features
The features that will be implemented using these components are

- Filter and search for specific products based on user input
- Generate drinks based on certain criteria specified by the user
- See which products contain the best price for the most amount of alcohol



### Flow
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
As a consequence of using scenebuilder and fxml files with maven, is that the fxml files need to be in the resource folder.  Therefore the view is not a package in the java structure. However, the dependancies still apply correctly. When we create a FXML file a controller is associated with that file. The fxml file then points to that file and gives it all the Objects and information it needs to execute correctly.

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
A selection is a asserted number of products with specific attributes. This is a way of finding products with a specific attribute that the user have selected

- Sortiment,
This is where all the information of the products are, lets say the user wants information about a product. The program will then go to Sortiment, get that specific Selection with that product in it and the get the product from that selection.

- Drink
Represents all the information the program needs for a drink
	- Name
	- Ingredients(Products)
	- etc
	.......

- DrinkGenerator
This module is responsible for finding a drink based on a list of products(Beverages), the user will give it.

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
  This class is for the Template Method pattern, it provides a simpler interface to a complex subsystem. this will be the only connection that is accessable outside of the model package.
  The model uses all the different packages of the backend and represents a simpler way of using them.

- **Parser**
 ![ParsingDesign](Photos/ParsingDesignUML.png)
  The functionallity of this module is to fetch data from some type of data storage. In our case, we use a json file to store our products. Therefore we are using 


- **Filter**
![FilterDesign](Photos/FilterDesignUML.png)
- **Favorites**
 ![FavoritesDesign](Photos/FavoritesDesignUML.png)
- **Drink Generator**
 Not yet implemented

## 4 Persistent data management
- All product data is saved in `data.json`, and corresponds to Systembolagets sortiment. 
- All views are saved in `src/main/resources`. 
- Saved product ID:s are stored in `SavedLists.txt`.

## 5 Quality

### Tests
Testing the application is done with JUnit, and the test classes can be found in `src/test/java/shedbolaget`. All tests are run using [Travis](https://travis-ci.org/) whenever commits are pushed to the GitHub-repository. Only the backend is tested, since issues with controllers become apparent when using the user interface.

### Known issues
- `Filter` has no way of sorting products by variables that are not numeric, i.e. sorting by Strings like `name` or booleans like `isNew` is not possible at the moment.
- Loading images is very slow for larger quantities of products, making load times slow when looking at broad filters.
- There is no pagination in the `ProductsView`, making it only possible to view the first products in each category.

### Source code analysis

#### Dependency matrix
This matrix displays all dependencies in the project, marking cyclic dependencies in red.
![Dependency matrix](Photos/dependency_matrix.png)

#### Quality report
The overall code quaity has been analysed using PMD. With 1065 violations at the moment of analysis, it is apparent that there is work to be done here, mainly in areas such as documentation, commenting, making variables final and avoiding Law of Demeter.

![PMD result](Photos/pmd_result.png)