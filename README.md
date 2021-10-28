# songr

## Overview

This project is about using Spring Boot to create an backend application,and in this lab we create a number of end points in different ways and using the MVC structuer.

## How to run this application

you can clone it on your device then it will be build then:

1. open the project in terminal.
2. run: ./gradlew bootRun.
3. open a browser and type localhost:8080 follow it by the name of the end point.

## Test the application

you can run the app and test it on the browser.

## Packages and classes in this project

* Package com.ASAC.songr
  * SongrApplication.java

* Package controllers
  * HomePageController.java
  * AlbumController.java
  * CapitalizeController.java
  * HelloWorldController.java

* Package models
  * Albums.java

## Methods

* SongrApplication
  * The main method

* Controllers
  * capitalize(@PathVariable String text, Model model)
  * album(Model model)
  * helloWorld(@RequestParam("name") String name)
  * welcomeToHome(Model model)

## lab 12

### AlbumController

modifiy this controller to accept data from post method using @RequestParam.
and allow the user to enter and store new album using a form.

* Routers:

1. @GetMapping("/album")
2. @PostMapping("/addAlbum")
3. @GetMapping("/addAlbumsForm")
4. @PostMapping("/addAlbumsForm")

### How To Run

1. open a command line interface
2. clone the repo and build project
3. cd into the songr directory
4. run postgres database by pgstart
5. run: ./gradlew bootRun
6. open a browser and type localhost:8080 as the URL
7. try the different endpoints

## lab 13

The requirments:

1. A user should be able to see information about all the songs on the site.
2. A user should be able to view a page with data about one particular album.
3. A user should be able to add songs to an album.
4. A user should be able to see the songs that belong to an album when looking at that album.

* Routers:

1. @GetMapping("/allSongs")
2. @PostMapping("/songsError")
3. @GetMapping("/addSongForm")
4. @PostMapping("/addSongForm")

* `models`
  * `Song`

* Repositories:
  * songsrepository

### How To Run the application

1. open a command line interface
2. clone the repo and build project
3. cd into the songr directory
4. run postgres database by pgstart
5. run: ./gradlew bootRun
6. open a browser and type localhost:8080 as the URL
7. try the different endpoints
