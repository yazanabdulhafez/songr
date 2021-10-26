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
  * albums(Model model)
  * helloWorld(@RequestParam("name") String name)
  * welcomeToHome(Model model)

## lab 12

### AlbumController

modifiy this controller to accept data from post method using @RequestParam.

* Routers:

1. @GetMapping("/albums")
2. @PostMapping("/addAlbum")
