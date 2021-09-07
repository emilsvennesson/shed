# Requirements and Analysis Document for shed

Samuel Kajava, Daniel Rygaard, Pouya Shirin & Emil Svensson

2021-09-04

v1.0

## 1 Introduction

Shed is a project that aims to extend the functionality of Systembolaget's website with additional features in a desktop application.

### 1.1 Word book

## 2 Requirements

### 2.1 User Stories


#### 2.1.1 User story 

Story Identifier: US01

Story Name: Cheapest Prices


##### Description 

As a student, I want to be able to find the products with the highest APK in order to save money.

##### Confirmation

List all acceptance criteria; you should be able to test/confirm these.

###### Functional

- Can I find products with the highest APK in an APK leaderboard?
- If I click on a product, can I see its APK?

###### Non-functional
- Can I access the APK leaderboard from all views in the application?
____

#### 2.1.2 User story 

Story Identifier: US02

Story Name: Categories


##### Description 

As a wine enthusiast, I want to be able to sort out wine products so that I can discover and find new favorites.

##### Confirmation

List all acceptance criteria; you should be able to test/confirm these.

###### Functional

- Can I filter out other products that are not wine?
- Can I be more specific and filter out products that are not red wine?
- Can I combine filters and filter out products that are not red or white wine?


###### Non-functional
- From where in the application can I access the filters?
____

#### 2.1.3 User story

Story Identifier: US03

Story Name: Product Listing


##### Description 

As a student, I want to be able to browse the range of products so that I can get an overview of what's available.

##### Confirmation

List all acceptance criteria; you should be able to test/confirm these.

###### Functional

- Can I view products in the application?
- Can I see an image of the product?
- Can I show more specific data related to a product?


###### Non-functional
- From where in the application can I find the browsing feature?
____

#### User story  2.1.4

Story Identifier: US04

Story Name: Search


##### Description 

As an experienced drinker, I want to be able to search for specific products so that I can access my favorites more easily.

##### Confirmation

List all acceptance criteria; you should be able to test/confirm these.

###### Functional

- Can I search for specific products in the range of products?
- Can I use the search function to filter out products in a specific category?


###### Non-functional
- Is the search function accessible at all times?
____

#### User story 2.1.5

Story Identifier: US05

Story Name: Search


##### Description 

As a party host, I want to be able to find drinks based on products I select so that I can improve my bartender abilities.

##### Confirmation

List all acceptance criteria; you should be able to test/confirm these.

###### Functional

- Can I combine different ingredients and get suggestions on drinks I can make?
- Can I randomize ingredients and get suggestions on drinks I can make?
____

#### User story 2.1.6 

Story Identifier: US06

Story Name: View products from a specific property

##### Description  

As a customer, I need to be able to search for products from a particular brand/type/price so I can view all products from the manufacturer in question.

##### Confirmation

###### Functional

- Can I load all products from a specific property?
- Can I view products from two properties at the same time?
- Can I see which property I am looking at?

###### Non-functional

- Can I view items while I'm offline?

____

#### User story 2.1.7

Story Identifier: US07

Story Name: View popular drinks

##### Description 

As a customer, I need to see popular beverages as soon as I launch the application because I often want to find good drinks when I'm unsure what to order at the bar.

##### Confirmation

###### Functional

- Can I see a picture of the popular beverage and its name when I load the start page?
- If I click on an interesting item, can I read basic information about it?

###### Non-functional

- Can I view popular products without an internet connection?

____

##### User story 2.1.8

Story Identifier: US08

Story Name: Mark tasted drinks


##### Description 

As a customer, I want to be able to mark some products as tasted because I want to differentiate between drinks I have tried and those which I have not.

##### Confirmation

###### Functional

- Can I mark a beverage as tasted?
- If I change my mind after marking a drink as atsted, can I easily unmark it?
____

#### User story 2.1.9

Story Identifier: US09

Story Name: Detailed information


#### Description 

As a customer, I need more detailed information about the product  so that i can learn more about it

#### Confirmation

###### Functional

- Can i click on the product to get more information

###### Non-functional
- Can i get more detailed information of all the products from all the pages?

____

#### User story 2.1.10
Story Identifier: US10

Story Name: Shopping list


#### Description 

As a customer, I want to add products to a list, because I want to make a shopping list.

#### Confirmation

###### Functional

- Can i add a product to the list?
- Can i remove a product from the list?
- Can i see the total amount of products that i have added?
- Can i have multiple lists?

###### Non-functional
- Can i add a product to the shopping list from all places in the program?
- Can i look at the shopping list from all places in the program

____
#### User story 2.1.11
Story Identifier: US11

Story Name: Drinking games


#### Description 

As a party host, i want to play the most popular drinking games

#### Confirmation

###### Functional

- Can i add all of our names to the game
- Can i quit the game and come back with the game stored
- Can i browse through multiple games
- Can i start a game

###### Non-functional
- Can I browse through games at any point in the program?

______________________________________________________________________________________________________________________

#### User story 2.1.12
Story Identifier: US12

Story Name: Random beverage/drink


#### Description 

As a regular alcohol beverage drinker,  I want to find something random new to drink

#### Confirmation

###### Functional

- Can I get a random product/drink from the list
- Can constraint the products that are randomly generated
	- Based on Beer/Drink/Wine/etc
____

### 2.2 Definition of Done

- All acceptance criteria are met.
- All JUnit tests pass.
- All Travis checks pass.
- Completed Java doc (if applicable)
  - All new files need to have an author.
  - All methods except getters and setters has Javadoc.
- Pull request is accepted by everyone in the group.

### 2.3 User interfaces

## 3 Domain model

### 3.1 Class responsibilities

## 4 References